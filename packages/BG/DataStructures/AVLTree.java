package BG.DataStructures;

import java.lang.*;
import java.util.*;

public class AVLTree<T extends Comparable> extends BinarySearchTree<T>
{
  public AVLTree()
  {
    super.root = null;
  }
  public AVLTree(T value)
  {
    super.root = new BinaryNode<T>(value);
  }

  public boolean add(T value)
  {
    if(super.root == null)
    {
      root = new BinaryNode(value);
      return true;
    }
    boolean success = super.add(value,super.root);
    root = balance();
    return success;
  }

  public boolean add(T value,BinaryNode<T> node)
  {
    boolean success = super.add(value,node);
    root = balance();
    return success;
  }

  public void delete(T value)
  {
    super.delete(value);
    root = balance();

  }

  private BinaryNode<T> rotateLeft(BinaryNode<T> node)
  {
    if(super.debug)
      System.out.println("Rotate " + node.value.toString() +" left.");
    BinaryNode<T> tempNode = node.greatNode;
    node.greatNode = tempNode.lessNode;
    tempNode.lessNode = node;
    if(super.debug)
      System.out.println("Rotate complete " + tempNode.value.toString()
       +" now head node.");
    return tempNode;
  }

  private BinaryNode<T> rotateRight(BinaryNode<T> node)
  {
    if(super.debug)
      System.out.println("Rotate " + node.value.toString() +" right.");
    BinaryNode<T> tempNode = node.lessNode;
    node.lessNode = tempNode.greatNode;
    tempNode.greatNode = node;
    if(super.debug)
      System.out.println("Rotate complete " + tempNode.value.toString()
       +" now head node.");
    return tempNode;
  }

  private BinaryNode<T> balance()
  {
    return balance(root);
  }

  private BinaryNode<T> balance(BinaryNode<T> node)
  {
    if(node == null)
      return null;

    int difference = super.Height(node.greatNode) - super.Height(node.lessNode);

    if(difference > 1)
    {
      node.greatNode = balance(node.greatNode);
    }
    else if(difference < -1)
    {
      node.lessNode = balance(node.lessNode);
    }
    else
    {
      return node;
    }
    //Get difference again
    difference = super.Height(node.greatNode) - super.Height(node.lessNode);

    if(difference > 1)
    {
      if(super.debug)
        System.out.println("Balance required for " + node.value.toString() +" in greatNode");
      if(super.Height(node.greatNode.lessNode) > 0)
        node.greatNode = rotateRight(node.greatNode);
      node = rotateLeft(node);
    }
    else if(difference < -1)
    {
      if(super.debug)
        System.out.println("Balance required for " + node.value.toString() +" in lessNode");
      if(super.Height(node.lessNode.greatNode) > 0)
        node.lessNode = rotateLeft(node.lessNode);
      node = rotateRight(node);
    }
    else
    {
      if(super.debug)
        System.out.println("No Balance required for " + node.value.toString());
      return node;
    }
    return node;
  }

}
