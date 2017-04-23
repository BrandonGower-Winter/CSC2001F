package BG.DataStructures;

import java.lang.*;
import java.util.*;

/**
* A generic AVL Tree data structure.
* The T parameter must implement the Comparable interface.
* The tree does not have a left and right node.
  It uses lessNode and greaterNode in which values smaller than and values greater
  than the current node are stored respectively.
* Inherits from the BinarySearchTree class.
* @author Brandon Gower-Winter
*/
public class AVLTree<T extends Comparable> extends BinarySearchTree<T>
{
  /**
  * Default constructor for AVL Tree.
  * Sets root node to null
  */
  public AVLTree()
  {
    super.root = null;
  }
  /**
  * Constructor for AVL Tree that has one argument
  * @param value The object that will be set as the root node
  */
  public AVLTree(T value)
  {
    super.root = new BinaryNode<T>(value);
  }
  /**
  * Add object to the AVL Tree
  * @param value Object to add to the AVL Tree
  * @return boolean
  */
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
  /**
  * Add object to the AVL Tree
  * @param value Object to add to the AVL Tree
  * @param node Node to attempt to add the object
  * @return boolean
  */
  public boolean add(T value,BinaryNode<T> node)
  {
    boolean success = super.add(value,node);
    root = balance();
    return success;
  }
  /**
  * Delete object from the AVL
  * @param value Object to delete from the Binary Search Tree
  */
  public void delete(T value)
  {
    super.delete(value);
    root = balance();

  }
  /**
  * Used for balancing AVL tree.
  * Will rotate node left
  * @param node Node to rotate left
  * @return BinaryNode<T>
  */
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
  /**
  * Used for balancing AVL tree.
  * Will rotate node right
  * @param node Node to rotate right
  * @return BinaryNode<T>
  */
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
  /**
  * Balances the AVL tree from the root down.
  * @return BinaryNode<T>
  */
  private BinaryNode<T> balance()
  {
    return balance(root);
  }
  /**
  * Balances the AVL tree from specified node down.
  * @param node The node to balance from.
  * @return BinaryNode<T>
  */
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
