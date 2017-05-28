import java.util.*;

/**
* Main class for Assignment 4 part 2
* @author Brandon Gower-Winter
*/
public class SimulatorTwo
{
  public static void main(String[] args)
  {
    Scanner scInput = new Scanner(System.in);
    int numNodes = Integer.parseInt(scInput.nextLine());
    AdvancedGraphNode nodes[] = new AdvancedGraphNode[numNodes];
    //Set Nodes
    for(int i = 0; i < numNodes; i++)
    {
      AdvancedGraphNode node = new AdvancedGraphNode();
      Scanner scLine = new Scanner(scInput.nextLine());
      node.index = scLine.nextInt();
      while(scLine.hasNextInt())
      {
        int key = scLine.nextInt();
        int val = scLine.nextInt();
        node.paths.put(key,val);
      }
      nodes[i] = node;
    }
    int numHosp = Integer.parseInt(scInput.nextLine());
    Hospital hospitals[] = new Hospital[numHosp];
    //Set hosp data;
    for(int i = 0; i < numHosp; i++)
    {
      Hospital hosp = new Hospital();
      Scanner scLine = new Scanner(scInput.nextLine());
      hosp.index = scLine.nextInt();
      hosp.capacity = scLine.nextInt();
      hosp.type = scLine.next();
      hospitals[i] = hosp;
    }
    int amboCount = Integer.parseInt(scInput.nextLine());
    Ambulance ambos[] =  new Ambulance[amboCount];
    //Set Ambulance data
    for(int i = 0; i < amboCount; i++)
    {
      Ambulance ambo = new Ambulance();
      Scanner scLine = new Scanner(scInput.nextLine());
      ambo.index = scLine.nextInt();
      ambo.capacity = scLine.nextInt();
      ambo.type = scLine.next();
      ambos[i] = ambo;
    }
    int numVics = Integer.parseInt(scInput.nextLine());
    Victim vics[] = new Victim[numVics];
    //Set Vic data
    for(int i = 0; i < numVics; i++)
    {
      Victim vic = new Victim();
      Scanner scLine = new Scanner(scInput.nextLine());
      vic.index = scLine.nextInt();
      vic.timeLeft = scLine.nextInt();
      vic.name = scLine.next();
      vics[i] = vic;
    }
    int trafficCount = Integer.parseInt(scInput.nextLine());
    TrafficIncident incidents[] = new TrafficIncident[trafficCount];
    //Set incidents
    for(int i = 0; i < trafficCount; i++)
    {
      TrafficIncident in = new TrafficIncident();
      Scanner scLine = new Scanner(scInput.nextLine());
      in.from = scLine.nextInt();
      in.to = scLine.nextInt();
      in.newCost = scLine.nextInt();
      incidents[i] = in;
    }

    AdvancedHospitalGraph map = new AdvancedHospitalGraph();
    map.nodeCount = numNodes;
    map.hospitalCount = numHosp;
    map.amboCount = amboCount;
    map.victimCount = numVics;
    map.trafficCount = trafficCount;

    map.nodes = nodes;
    map.hospitals = hospitals;
    map.ambos = ambos;
    map.victims = vics;
    map.incidents = incidents;
    System.out.println(map.solve());
  }

}
