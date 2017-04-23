package BG.DataStructures;

import java.lang.*;
import java.util.*;

/**
* A generic Binary Search Tree data structure.
* The T parameter must implement the Comparable interface.
* The tree does not have a left and right node.
  It uses lessNode and greaterNode in which values smaller than and values greater
  than the current node are stored respectively.
* @author Brandon Gower-Winter
*/
public class BinarySearchTree<T extends Comparable>
{
    protected BinaryNode<T> root;
    protected boolean debug;
    /**
    * Default constructor for Binary Search Tree.
    * Sets root node to null
    */
    public BinarySearchTree()
    {
        root=null;
        debug = false;
    }
    /**
    * Constructor for Binary Search Tree that has one argument
    * @param rootValue The object that will be set as the root node
    */
    public BinarySearchTree(T rootValue)
    {
        root = new BinaryNode<T>(rootValue);
        debug = false;
    }

    //Add new item to Tree
    /**
    * Add object to the Binrary Search Tree
    * @param newValue Object to add to the Binary Search Tree
    */
    public boolean add(T valueToAdd)
    {
      return add(valueToAdd,root);
    }

    public boolean add(T valueToAdd, BinaryNode<T> currentNode)
    {
      if(currentNode == null)
      {
        currentNode = new BinaryNode(valueToAdd);
        if(debug)
          System.out.println("Object: " + valueToAdd.toString() + " was added to the tree.");
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

    public boolean delete()
    {
       return delete(root);
    }
    //Add Balance
    public boolean delete(BinaryNode<T> node)
    {
      //Implement
      if(node == null)
      {
        return false;
      }
      if(node.lessNode == null && node.greatNode == null)
      {
        if(debug)
          System.out.println("Object: " + node.value.toString() + " was deleted from the tree.\nHad no children.");
        node = null;
        return true;
      }
      if(node.lessNode != null && node.greatNode == null)
      {
        if(debug)
          System.out.println("Object: " + node.value.toString() + " was deleted from the tree.\nHad 1 child: lessNode.");
        node = node.lessNode;
        return true;
      }
      if(node.greatNode != null && node.lessNode == null)
      {
        if(debug)
          System.out.println("Object: " + node.value.toString() + " was deleted from the tree.\nHad 1 child: greatNode.");
        node = node.greatNode;
        return true;
      }
      if(debug)
        System.out.println("Object: " + node.value.toString() + " was deleted from the tree.\nHad 2 children.");
      BinaryNode<T> minNode = getMin(node.greatNode);
      node.value = minNode.value;
      minNode = null;
      return true;
    }
    /**
    * Returns the number of nodes in the Binary Search Tree from the root node
    * @return int
    */
    public int Count()
    {
      return Count(root);
    }
    /**
    * Returns the number of nodes in the Binary Search Tree from the specified node
    * @param node The node to start counting from.
    * @return int
    */
    public int Count(BinaryNode<T> node)
    {
      if(node == null)
        return 0;

      return 1 + Count(node.lessNode) + Count(node.greatNode);
    }

    public int Height()
    {
      return Height(root);
    }

    public int Height(BinaryNode<T> node)
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
    /**
    * Finds Object in Binrary Search Tree
    * Returns null if object cannot be found.
    * Uses compareTo function so that objects that are equal are defined by the object implementation
    * @param value Object that will be searched for in the Binary Search Tree
    */
    public BinaryNode<T> find(T value)
    {
        return find(value,root);
    }

    public BinaryNode<T> find(T value, BinaryNode<T> node)
    {
      if(node == null)
      {
        if(debug)
          System.out.println("Searched for Object: " + value.toString() + " and was not found");
        return null;
      }
      int compareVal = node.compareTo(value);
      if(compareVal == 0)
      {
        if(debug)
          System.out.println("Searched for Object: " + value.toString() + " and was found");
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
    /**
    * Prints the data in order within the Binary Seach Tree to the output stream.
    * Prints from the root node.
    * Uses in-order traversal algorithm.
    */
    public void printDataInOrder()
    {
      printDataInOrder(root);
    }
    /**
    * Prints the data in order within the Binary Seach Tree to the output stream.
    * Prints from the specified node.
    * Uses in-order traversal algorithm.
    @param node Specifies which node to start printing from.
    */
    public void printDataInOrder(BinaryNode<T> node)
    {
        if(node == null)
        {
          return;
        }
        printDataInOrder(node.lessNode);
        System.out.println(node.value.toString());
        printDataInOrder(node.greatNode);
    }
    /**
    * Returns the data of the Binary Search Tree.
    * Returns from root node.
    * Uses in-order traversal algorithm.
    * @param data The ArrayList that will have the data stored in it.
    */
    public void getDataInOrder(ArrayList<T> data)
    {
      getDataInOrder(root,data);
    }
    /**
    * Returns the data of the Binary Search Tree.
    * Returns from specified node.
    * Uses in-order traversal algorithm.
    * @param node Node to start getting from data from.
    * @param data The ArrayList that will have the data stored in it.
    */
    public void getDataInOrder(BinaryNode<T> node, ArrayList<T> data)
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
      getChildren(root,data);
    }
    public void getChildren(BinaryNode<T> node, ArrayList<T> data)
    {
      if(data == null)
        data = new ArrayList();
      if(node == null)
        return;
        getDataInOrder(node.lessNode,data);
        getDataInOrder(node.greatNode,data);
    }
    public BinaryNode<T> getMin()
    {
      return getMin(root);
    }

    public BinaryNode<T> getMin(BinaryNode<T> node)
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
    public void Debug(boolean value)
    {
      debug = value;
    }
}
