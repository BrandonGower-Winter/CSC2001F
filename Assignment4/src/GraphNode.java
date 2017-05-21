/*
Test Data:
5
0 1 98 2 5 3 16 4 16
1 0 13 2 47 3 3 4 40
2 0 71 1 51 3 43 4 30
3 0 20 1 94 4 46
4 0 1 1 10 2 28 3 15
2
2 3
2
0 1
*/
import java.util.*;

public class GraphNode
{
  public boolean isHospital;
  public int numVictims;
  public Hashtable<Integer,Integer> paths;

  public GraphNode()
  {
    isHospital = false;
    int numVictims = 0;
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
