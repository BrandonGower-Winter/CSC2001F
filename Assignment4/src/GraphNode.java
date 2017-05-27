
import java.util.*;

public class GraphNode
{
  public boolean isHospital;
  public int numVictims;
  public Hashtable<Integer,Integer> paths;
  public int distance;
  public int pathTo;
  public GraphNode()
  {
    isHospital = false;
    numVictims = 0;
    distance = Integer.MAX_VALUE;
    pathTo = -1;
    paths = new Hashtable();
  }

  public String toString()
  {
    String stringToReturn = "";
    stringToReturn += "Is Hospital: " + isHospital +"\n";
    stringToReturn += "Number of victims: " + numVictims +"\n";
    stringToReturn += "Paths:\n";
    for(Enumeration<Integer> e = paths.keys(); e.hasMoreElements();)
    {
      int element = e.nextElement().intValue();
      stringToReturn += "Node: " + element + " Cost: " + paths.get(element) + "\n";
    }
    return stringToReturn;
  }
}
