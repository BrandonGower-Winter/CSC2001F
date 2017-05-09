package BG.DataStructures;

public class LinkedNode<T extends Comparable> implements INode<T>
{
  T value;
  LinkedNode<T> child;

  public LinkedNode()
  {
    value = null;
    child = null;
  }
  public LinkedNode(T value)
  {
    this.value = value;
    child = null;
  }
  public LinkedNode(T value, LinkedNode<T> child)
  {
    this.value = value;
    this.child= child;
  }

  public T Value()
  {
    return value;
  }

  public void Value(T value)
  {
    this.value = value;
  }

  public int CompareTo(T compareVal)
  {
    return value.CompareTo(compareVal);
  }

}
