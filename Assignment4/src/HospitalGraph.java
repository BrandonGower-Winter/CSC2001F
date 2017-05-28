
import java.util.*;

public class HospitalGraph
{

  private GraphNode nodes[];
  private int numHosp;
  private int numVictims;

  private Queue<Integer> victims;
  private int hospitals[];

  public HospitalGraph(int numNodes, String nodeData[], int numHosp, String hospData, int numVictims, String vicData)
  {
    nodes = new GraphNode[numNodes];
    this.numHosp = numHosp;
    this.numVictims = numVictims;

    victims = new ArrayDeque();
    hospitals = new int[numHosp];

    populateNodes(nodeData);
    populateHospitals(hospData);
    populateVictims(vicData);
  }

  public String solve()
  {
    String stringToReturn = "";
    while(!victims.isEmpty())
    {
      int vicIndex = victims.remove().intValue();
      stringToReturn+= "victim " + vicIndex + "\n";
      int minDistance = Integer.MAX_VALUE;
      ArrayList<Integer> shortHospitals = new ArrayList();
      ArrayList<String> paths = new ArrayList();
      //int dist = Integer.MAX_VALUE;
      for(int i = 0; i < hospitals.length; i++)
      {

        if(vicIndex == hospitals[i])
        {
          if(minDistance == 0)
          {
            shortHospitals.add(vicIndex);
            paths.add(new Integer(vicIndex).toString());
          }
          else
          {
            shortHospitals.clear();
            paths.clear();
            shortHospitals.add(vicIndex);
            paths.add(new Integer(vicIndex).toString());
            minDistance = 0;
          }
          continue;
        }

        int toVic =  new PathSet(hospitals[i],nodes).getDistance(vicIndex);
        int toHosp = new PathSet(vicIndex,nodes).getDistance(hospitals[i]);
        //System.out.println("Victim cost: " + toVic + " Hospital Cost: " + toHosp + " Total: " + (toHosp + toVic));
        if(toVic + toHosp < minDistance)
        {
          shortHospitals.clear();
          paths.clear();
          minDistance = toVic + toHosp;
          shortHospitals.add(hospitals[i]);
          String stringToAdd = new PathSet(hospitals[i],nodes).getPath(vicIndex,false) + " " + new PathSet(vicIndex,nodes).getPath(hospitals[i],true);
          paths.add(stringToAdd);
        }
        else if(toVic + toHosp == minDistance)
        {
          shortHospitals.add(hospitals[i]);
          String stringToAdd = new PathSet(hospitals[i],nodes).getPath(vicIndex,false) + " " + new PathSet(vicIndex,nodes).getPath(hospitals[i],true);
          paths.add(stringToAdd);
        }
      }
      for(int i = 0; i < shortHospitals.size(); i++)
      {
        stringToReturn+= "hospital " + shortHospitals.get(i) +"\n";
        stringToReturn+= paths.get(i) + "\n";
      }
    }
    return stringToReturn.substring(0,stringToReturn.length() - 1);
  }


  private void populateNodes(String nodeData[])
  {
    for(int i = 0; i < nodeData.length; i++)
    {
      Scanner line = new Scanner(nodeData[i]);
      int nodeNum =  line.nextInt();
      nodes[nodeNum] = new GraphNode();
      while(line.hasNextInt())
      {
        nodes[nodeNum].paths.put(line.nextInt(),line.nextInt());
      }
    }
  }

  private void populateHospitals(String hospData)
  {
    int counter = 0;
    Scanner line = new Scanner(hospData);
    while(line.hasNextInt())
    {
      int index = line.nextInt();
      nodes[index].isHospital = true;
      hospitals[counter] = index;
      counter++;
    }
    Arrays.sort(hospitals);
  }

  private void populateVictims(String vicData)
  {
    Scanner line = new Scanner(vicData);
    while(line.hasNextInt())
    {
      int index = line.nextInt();
      nodes[index].numVictims += 1;
      victims.add(index);
    }
  }

  public String toString()
  {
    String stringToReturn = "";
    for(int i = 0; i < nodes.length; i++)
    {
      stringToReturn += "Node " + i + ":\n";
      stringToReturn += nodes[i].toString() + "\n";
    }
    return stringToReturn;
  }

}
