
import java.util.*;

public class HospitalGraph
{

  private GraphNode nodes[];
  private int numHosp;
  private int numVictims;

  public HospitalGraph(int numNodes, String nodeData[], int numHosp, String hospData, int numVictims, String vicData)
  {
    nodes = new GraphNode[numNodes];
    this.numHosp = numHosp;
    this.numVictims = numVictims;

    populateNodes(nodeData);
    populateHospitals(hospData);
    populateVictims(vicData);
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
    Scanner line = new Scanner(hospData);
    while(line.hasNextInt())
    {
      nodes[line.nextInt()].isHospital = true;
    }
  }

  private void populateVictims(String vicData)
  {
    Scanner line = new Scanner(vicData);
    while(line.hasNextInt())
    {
      nodes[line.nextInt()].numVictims += 1;
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
