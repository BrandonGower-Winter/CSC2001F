
import java.util.*;

public class PathSet
{
  public GraphNode nodes[];
  public int source;

  public PathSet(int source, GraphNode nodes[])
  {
    for(int i = 0; i < nodes.length; i++)
    {
      nodes[i].distance = Integer.MAX_VALUE;
      nodes[i].pathTo = -1;
    }
    this.source = source;
    this.nodes = nodes;
    GraphNode unvisited[] = new GraphNode[nodes.length];
    for(int i = 0; i < nodes.length; i++)
    {
      unvisited[i] = nodes[i];
    }
    unvisited[source].distance = 0;
    unvisited[source].pathTo = source;
    while(!isEmpty(unvisited))
    {
      int index = getMin(unvisited);
      //this.nodes[index] = unvisited[index];
      unvisited[index] = null;
      for(Enumeration<Integer> e = nodes[index].paths.keys(); e.hasMoreElements();)
      {
        int element =  e.nextElement().intValue();
        //System.out.println("Element " + element + " index " + index);
        if(nodes[element].distance > nodes[index].distance + nodes[index].paths.get(element))
        {
          nodes[element].distance = nodes[index].distance + nodes[index].paths.get(element);
          nodes[element].pathTo = index;
        }
      }
    }
  }

  private int getMin(GraphNode nodes[])
  {
    int min = -1;
    for(int i = 0; i < nodes.length; i++)
    {
      if(nodes[i] == null)
        continue;
      if(min == -1)
      {
        min = i;
      }
      if(nodes[i].distance < nodes[min].distance)
      {
        min = i;
      }
    }
    return min;
  }
  private boolean isEmpty(GraphNode nodes[])
  {
    for(int i = 0; i < nodes.length; i++)
    {
      if(nodes[i] != null)
      {
        return false;
      }
    }
    return true;
  }

  public String toString()
  {
    String stringToReturn = "";
    for(int i = 0; i < nodes.length; i++)
    {
      stringToReturn += "Node: " + i + " pathTo: " + nodes[i].pathTo + " distance: " + nodes[i].distance + "\n";
    }
    return  stringToReturn;
  }

  public String getPath(int destination)
  {
    if(nodes[destination].pathTo == -1)
    {
      return "cannot be helped";
    }
    int current = destination;
    String toReturn = "";
    while(nodes[current].pathTo != current)
    {
      toReturn +=  current + " ";
      current = nodes[current].pathTo;
    }
    toReturn += current;
    return new StringBuilder(toReturn).reverse().toString();
  }

  public int getDistance(int index)
  {
    return nodes[index].distance;
  }
}
