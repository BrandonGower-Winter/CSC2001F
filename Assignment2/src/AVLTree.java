import java.lang.*;
import java.util.*;

public class AVLTree<T extends Comparable>
{

  private Node<T> root;

  public AVLTree()
  {
    root = null;
  }
  public AVLTree(T value)
  {
    root = new Node<T>(value);
  }
  //Add Balance
  public boolean add(T valueToAdd)
  {
    if(root == null)
    {
      root = new Node(valueToAdd);
      return true;
    }
    if(root.compareTo(valueToAdd) > 0)
    {
      return add(valueToAdd,root.greatNode);
    }
    else
    {
      return add(valueToAdd,root.lessNode);
    }
  }
  //Add Balance
  public boolean add(T valueToAdd, Node<T> currentNode)
  {
    if(currentNode == null)
    {
      currentNode = new Node(valueToAdd);
      return true;
    }
    if(currentNode.compareTo(valueToAdd) > 0)
    {
      return add(valueToAdd,currentNode.greatNode);
    }
    else
    {
      return add(valueToAdd,currentNode.lessNode);
    }
  }
  //add Balance
  public boolean delete()
  {
    if(root == null)
    {
      return true;
    }
    //Has no child nodes
    if(root.lessNode == null && root.greatNode == null)
    {
      root = null;
      return true;
    }
    //Only has one child node (lessNode)
    if(root.lessNode != null && root.greatNode == null)
    {
      root = root.lessNode;
      return true;
    }
    //Only has one child node (greatNode)
    if(root.greatNode != null && root.lessNode == null)
    {
      root = root.greatNode;
      return true;
    }
    //Both Nodes contain values.
    //Get minNode of greatNode
    Node<T> minNode = getMin(root.greatNode);
    root.value = minNode.value;
    minNode = null;
    return true;
  }
  //Add Balance
  public boolean delete(Node<T> node)
  {
    //Implement
    if(node == null)
    {
      return true;
    }
    if(node.lessNode == null && root.greatNode == null)
    {
      node = null;
      return true;
    }
    if(node.lessNode != null && node.greatNode == null)
    {
      node = node.lessNode;
      return true;
    }
    if(node.greatNode != null && node.lessNode == null)
    {
      node = node.greatNode;
      return true;
    }
    Node<T> minNode = getMin(node.greatNode);
    node.value = minNode.value;
    minNode = null;
    return true;
  }

  //Add Balance

  public Node<T> find(T value)
  {
      if(root == null)
      {
        return null;
      }
      int compareVal = root.compareTo(value);
      if(compareVal == 0)
      {
        return root;
      }
      if(compareVal > 0)
      {
        return find(value,root.lessNode);
      }
      else
      {
        return find(value,root.greatNode);
      }
  }

  public Node<T> find(T value, Node<T> node)
  {
    if(node == null)
    {
      return null;
    }
    int compareVal = node.compareTo(value);
    if(compareVal == 0)
    {
      return node;
    }
    if(compareVal > 0)
    {
      return find(value, node.lessNode);
    }
    else
    {
      return find(value,node.greatNode);
    }
  }

  public int Height()
  {
    if(root == null)
    {
      return 0;
    }
    int lessHeight = Height(root.lessNode);
    int greatHeight = Height(root.greatNode);
    if(lessHeight > greatHeight)
    {
      return 1 + lessHeight;
    }
    else
    {
      return 1 + greatHeight;
    }
  }

  public int Height(Node<T> node)
  {
    if(node == null)
    {
      return 0;
    }
    int lessHeight = Height(node.lessNode);
    int greatHeight = Height(node.greatNode);
    if(lessHeight > greatHeight)
    {
      return 1 + lessHeight;
    }
    else
    {
      return 1 + greatHeight;
    }
  }

  public void getDataInOrder(ArrayList<T> data)
  {
    if(data == null)
      data = new ArrayList();
    if(root == null)
      return;
    getDataInOrder(root.lessNode,data);
    data.add(root.value);
    getDataInOrder(root.greatNode,data);
  }

  public void getDataInOrder(Node<T> node, ArrayList<T> data)
  {
    if(data == null)
      data = new ArrayList();
    if(node == null)
      return;
    getDataInOrder(node.lessNode,data);
    data.add(node.value);
    getDataInOrder(node.greatNode,data);
  }

  public void getChildren(ArrayList<T> data)
  {
    if(data == null)
      data = new ArrayList();
    if(root == null)
      return;
      getDataInOrder(root.lessNode,data);
      getDataInOrder(root.greatNode,data);
  }
  public void getChildren(Node<T> node, ArrayList<T> data)
  {
    if(data == null)
      data = new ArrayList();
    if(node == null)
      return;
      getDataInOrder(node.lessNode,data);
      getDataInOrder(node.greatNode,data);
  }

  public Node<T> getMin()
  {
    if(root == null)
    {
      return null;
    }
    if(root.lessNode == null)
    {
      return root;
    }
    else
    {
      return getMin(root.lessNode);
    }
  }

  public Node<T> getMin(Node<T> node)
  {
    if(node == null)
    {
      return null;
    }
    if(node.lessNode == null)
    {
      return node;
    }
    else
    {
      return getMin(node.lessNode);
    }
  }

  private class Node<T extends Comparable>
  {
      T value;
      Node<T> lessNode;
      Node<T> greatNode;

      public Node(T value)
      {
        this.value = value;
        lessNode = null;
        greatNode = null;
      }

      public int compareTo(T value)
      {
        return this.value.compareTo(value);
      }
  }
}
