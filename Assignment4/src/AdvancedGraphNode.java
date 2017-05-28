import java.util.*;
/**
* Data model for an advanced graph node
* Contains a Hashtable of paths and a index;
* @author Brandon Gower-Winter
*/
public class AdvancedGraphNode
{
  int index;
  Hashtable<Integer,Integer> paths;
  int pathTo;
  int distance;
  /**
  * Default Constructor instantiates a new Hashtable
  */
  public AdvancedGraphNode()
  {
    paths = new Hashtable();
    pathTo = 0;
    distance = 0;
  }

  /**
  * Creates a deep copy of a Advanced GraphNode
  * @return AdvancedGraphNode
  */
  public AdvancedGraphNode clone()
  {
    AdvancedGraphNode n = new AdvancedGraphNode();
    n.index = index;
    n.pathTo = 0;
    n.distance = 0;
    for(Enumeration<Integer> e = paths.keys(); e.hasMoreElements();)
    {
      int key = e.nextElement().intValue();
      n.paths.put(key,paths.get(key).intValue());
    }
    return n;
  }

}
