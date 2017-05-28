import java.util.*;

public class AdvancedPathSet
{
  int source;
  AdvancedGraphNode nodes[];
  public AdvancedPathSet(int source, AdvancedGraphNode nodes[])
  {
    this.source = source;
    this.nodes = new AdvancedGraphNode[nodes.length];
    AdvancedGraphNode unvisited[] = new AdvancedGraphNode[nodes.length];
    for(int i = 0; i < nodes.length; i++)
    {
      unvisited[i] = nodes[i].clone();
      unvisited[i].pathTo = -1;
      unvisited[i].distance = Integer.MAX_VALUE;
      this.nodes[i] = unvisited[i];
    }

    unvisited[source].distance = 0;
    unvisited[source].pathTo = source;

    while(!isEmpty(unvisited))
    {
      int index = getMin(unvisited);
      this.nodes[index] = unvisited[index];
      unvisited[index] = null;
      for(Enumeration<Integer> e = this.nodes[index].paths.keys(); e.hasMoreElements();)
      {
        int element =  e.nextElement().intValue();
        //System.out.println("Element " + element + " index " + index);
        if(this.nodes[element].distance > this.nodes[index].distance + this.nodes[index].paths.get(element))
        {
          this.nodes[element].distance = this.nodes[index].distance + this.nodes[index].paths.get(element);
          this.nodes[element].pathTo = index;
        }
      }
    }

  }
  private boolean isEmpty(AdvancedGraphNode nodes[])
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
  private int getMin(AdvancedGraphNode nodes[])
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
  public int getDistance(int index)
  {
    return nodes[index].distance;
  }
  public String getPath(int index)
  {
    String toReturn = "";
    ArrayList<String> list = new ArrayList();
    int previous = -1;
    while(source != index)
    {
      list.add(index + "");
      index = nodes[index].pathTo;
    }
    list.add(source + "");
    for(int i = list.size()-1; i >= 0; i--)
    {
      toReturn += list.get(i) + " ";
    }
    return toReturn;
  }
}
