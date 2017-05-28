import java.util.*;

public class AdvancedHospitalGraph
{
  int nodeCount = 0;
  int hospitalCount = 0;
  int amboCount = 0;
  int victimCount = 0;
  int trafficCount = 0;

  AdvancedGraphNode nodes[] = null;
  Hospital hospitals[] = null;
  Ambulance ambos[] = null;
  Victim victims[] = null;
  TrafficIncident incidents[] = null;

  public String solve()
  {
    System.out.println("--------------------------------------------");
    if(nodes == null)
      return "Error: No nodes set.";

    String toReturn = "";


    for(int v = 0; v < victimCount; v++)
    {
      if(victims[v].index == -1)
      {
        continue;
      }
      if(victims[v].timeLeft <= 0)
      {
        System.out.println("Victim " + victims[v].name + " has died... no Ambo arrived");
        System.out.println("--------------------------------------------");
        continue;
      }
      if(isFull() || !canTravel())
      {
        System.out.println("Hospitals are full.\n###CODE BLACK###\nDiverge incoming victims to other hospitals.");
        break;
      }
      //System.out.println("Victim: " + victims[v].index);
      ArrayList<Ambulance> ambulanceSource = new ArrayList();
      ArrayList<Hospital> hospitalSource = new ArrayList();
      int minDistance = Integer.MAX_VALUE;

      for(int a = 0; a < amboCount; a++)
      {
        //System.out.println("Ambulance: " + ambos[a].index);
        int shortAmbo = Integer.MAX_VALUE;
        int shortHosp = Integer.MAX_VALUE;
        int shortDistance = Integer.MAX_VALUE;
        int amboDistance = new AdvancedPathSet(ambos[a].index,nodes).getDistance(victims[v].index);
        //System.out.println("Shortest distance to " + victims[v].index + " is " + amboDistance);
        for(int h = 0; h < hospitalCount; h++)
        {
          //System.out.println("Hospital: " + hospitals[h].index);
          if(hospitals[h].type.compareTo(ambos[a].type) != 0 || hospitals[h].capacity <= 0)
          {
            //System.out.println("Not a match");
            continue;
          }
          //System.out.println("Match of type: " + hospitals[h].type);
          int hospDistance = new AdvancedPathSet(victims[v].index,nodes).getDistance(hospitals[h].index);
          //System.out.println("Shortest distance from " + victims[v].index + " to " + hospitals[h].index +  " is " + hospDistance);
          if(amboDistance + hospDistance < shortDistance)
          {
            //System.out.println("Distance is shorter than previous: " + shortDistance);
            shortDistance = amboDistance + hospDistance;
            shortAmbo = a;
            shortHosp = h;
          }
        }
        if(shortDistance < minDistance)
        {
          ambulanceSource.clear();
          hospitalSource.clear();
          ambulanceSource.add(ambos[shortAmbo]);
          hospitalSource.add(hospitals[shortHosp]);
          minDistance = shortDistance;
        }
      }
        for(int i= 0; i < ambulanceSource.size();i++)
        {
          System.out.println("Ambulance " + ambulanceSource.get(i).index + " devlivery to hospital " + hospitalSource.get(i).index);
          String toVic = new AdvancedPathSet(ambulanceSource.get(i).index,nodes).getPath(victims[v].index);
          String toHosp = new AdvancedPathSet(victims[v].index,nodes).getPath(hospitalSource.get(i).index);
          System.out.println("Estimated Time of Trip: " + minDistance);
          int newCap = ambulanceSource.get(i).capacity;
          newCap--;
          String carrying = victims[v].name + " ";
          for(int z = v + 1; z < victims.length; z++)
          {
            if(victims[z].index == -1)
            {
              continue;
            }
            else if(victims[v].index == victims[z].index && newCap > 0)
            {
              carrying+= victims[z].name + " ";
              victims[z].index = -1;
              newCap--;
            }
            else
            {
              //System.out.println("The min distance is: " + minDistance);
              victims[z].timeLeft -= minDistance;
            }
          }
          int totalPassengers = ambulanceSource.get(i).capacity - newCap;
          ambulanceSource.get(i).capacity = newCap;
          System.out.println("Carrying " + totalPassengers + " patient(s): " + carrying);
          System.out.println("Route:");
          System.out.println("Ambo "+ ambulanceSource.get(i).index+ " to Victim " + victims[v].index);
          System.out.println(toVic);
          System.out.println("Victim "+victims[v].index+ " to Hospital " + hospitalSource.get(i).index);
          System.out.println(toHosp);
          ambulanceSource.get(i).index = hospitalSource.get(i).index;
          hospitalSource.get(i).capacity -= totalPassengers;
          if(hospitalSource.get(i).capacity <= 0)
          {
            System.out.println("Hospital " + hospitalSource.get(i).index + " is at capacity");
          }
          ambulanceSource.get(i).capacity = totalPassengers + newCap;
        }
        System.out.println("--------------------------------------------");
    }
    return toReturn;
  }

  private boolean isFull()
  {
    for(int i = 0; i < hospitals.length; i++)
    {
      if(hospitals[i].capacity > 0)
        return false;
    }
    return true;
  }
  private boolean canTravel()
  {
    for(int i = 0; i < ambos.length; i++)
    {
      for(int j = 0;j < hospitals.length;j++)
      {
        if(hospitals[j].type.compareTo(ambos[i].type) == 0 && hospitals[j].capacity > 0)
        {
          return true;
        }
      }
    }
    return false;
  }

}
