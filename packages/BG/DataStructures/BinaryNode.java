/**
* A generic node for a Binary Tree.
* The T parameter must implement the Comparable interface.
* The node stores a value of Type T.
* The node can store two other nodes of the same type. One node that is greater in value(greatNode)
  and another that is smaller in value(lessNode).
* @author Brandon Gower-Winter
*/
package BG.DataStructures;
public class BinaryNode<T extends Comparable>
{
    T value;
    BinaryNode<T> lessNode;
    BinaryNode<T> greatNode;

    public BinaryNode(T value)
    {
      this.value = value;
      lessNode = null;
      greatNode = null;
    }

    public int compareTo(T value)
    {
      return this.value.compareTo(value);
    }

    public T Value()
    {
      return value;
    }
}
