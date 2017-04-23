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
    boolean success = super.add(value,super.root);
    balance();
    return success;
  }

  public boolean add(T value,BinaryNode<T> node)
  {
    boolean success = super.add(value,node);
    balance();
    return success;
  }

  public boolean delete()
  {
    boolean success = super.delete(super.root);
    balance();
    return success;
  }

  public boolean delete(BinaryNode<T> node)
  {
    boolean success = super.delete(node);
    balance();
    return success;
  }

  private void rotateLeft(BinaryNode<T> node)
  {
    if(super.debug)
      System.out.println("Rotate " + node.value.toString() +" left.");
    BinaryNode<T> tempNode = node;
    node = node.greatNode;
    tempNode.greatNode = node.lessNode;
    node.lessNode = tempNode;
  }

  private void rotateRight(BinaryNode<T> node)
  {
    if(super.debug)
      System.out.println("Rotate " + node.value.toString() +" right.");
    BinaryNode<T> tempNode = node;
    node = node.lessNode;
    tempNode.lessNode = node.greatNode;
    node.greatNode = tempNode;
  }

  private void balance()
  {
    balance(root);
  }

  private void balance(BinaryNode<T> node)
  {
    if(node == null)
      return;

    int difference = super.Height(node.greatNode) - super.Height(node.lessNode);

    if(difference > 1)
    {
      balance(node.greatNode);
    }
    else if(difference < -1)
    {
      balance(node.lessNode);
    }
    else
    {
      return;
    }
    //Get difference again
    difference = super.Height(node.greatNode) - super.Height(node.lessNode);

    if(difference > 1)
    {
      if(super.debug)
        System.out.println("Balance required for " + node.value.toString() +" in greatNode");
      if(super.Height(node.greatNode.lessNode) > 0)
        rotateRight(node.greatNode);
      rotateLeft(node);
    }
    else if(difference < -1)
    {
      if(super.debug)
        System.out.println("Balance required for " + node.value.toString() +" in lessNode");
      if(super.Height(node.lessNode.greatNode) > 0)
        rotateLeft(node.lessNode);
      rotateRight(node);
    }
    else
    {
      if(super.debug)
        System.out.println("No Balance required for " + node.value.toString());
      return;
    }

  }

}
