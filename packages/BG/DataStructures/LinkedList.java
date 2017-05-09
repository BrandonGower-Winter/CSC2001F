package BG.DataStructures;

import java.lang.*;

public class LinkedList<T extends Comparable> implements IDataStruct<T>
{
  private int count;

  private LinkedNode<T> head;

  public LinkedList()
  {
    count = 0;
    head = null;
  }
  public LinkedList(T value)
  {
    count = 1;
    head = new LinkedNode(value);
  }

  public void add(T value)
  {

  }
  public LinkedNode<T> add(T value, LinkedNode<T> node)
  {
    return null;
  }
  public void delete()
  {

  }
  public void delete(T value)
  {
    return null;
  }
  public T find(T value)
  {
    return null;
  }
  public int Count()
  {
    return count;
  }
  public T getFirst()
  {
    return null;
  }
  public T getLast();
}
