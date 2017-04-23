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
    * Add object to the Binary Search Tree
    * @param value Object to add to the Binary Search Tree
    * @return boolean
    */
    public boolean add(T value)
    {
      if(root == null)
      {
        root = new BinaryNode(value);
        if(debug)
          System.out.println("Object: " + root.value.toString() + " was added to the tree at root.");
        return true;
      }
      if(root.compareTo(value) > 0)
      {
        if(root.lessNode == null)
          root.lessNode = new BinaryNode(value);
        else
          return add(value,root.lessNode);
      }
      else
      {
        if(root.greatNode == null)
          root.greatNode = new BinaryNode(value);
        else
          return add(value,root.greatNode);
      }
      return true;
    }
    //Add new item to Tree
    /**
    * Add object to the Binary Search Tree
    * @param value Object to add to the Binary Search Tree
    * @param node Node to attempt to add the object
    * @return boolean
    */
    public boolean add(T value, BinaryNode<T> node)
    {
      if(node == null)
      {
        node = new BinaryNode(value);
        if(debug)
          System.out.println("Object: " + node.value.toString() + " was added to the tree.");
        return true;
      }
      if(node.compareTo(value) > 0)
      {
        if(node.lessNode == null)
          node.lessNode = new BinaryNode(value);
        else
          return add(value,node.lessNode);
      }
      else
      {
        if(node.greatNode == null)
          node.greatNode = new BinaryNode(value);
        else
          return add(value,node.greatNode);
      }
      return true;
    }
    /**
    * Delete object from the Binary Search Tree
    * @param value Object to delete from the Binary Search Tree
    */
    public void delete(T value)
    {
      root = delete(value,root);
    }
    /**
    * Delete object from the Binary Search Tree
    * @param value Object to delete from the Binary Search Tree
    * @param node Node to look for deletion.
    * @return BinaryNode<T>
    */
    public BinaryNode<T> delete(T value,BinaryNode<T> node)
    {
      if(node == null)
      {
        return null;
      }
      int compareVal = node.compareTo(value);
      if(compareVal > 0)
      {
        node.lessNode = delete(value,node.lessNode);
      }
      else if(compareVal < 0)
      {
        node.greatNode = delete(value,node.greatNode);
      }
      else
      {
        if(node.lessNode == null && node.greatNode == null)
        {
          if(debug)
            System.out.println("Object: " + node.value.toString() + " was deleted from the tree.\nHad no children.");
          return null;
        }
        if(node.lessNode != null && node.greatNode == null)
        {
          if(debug)
            System.out.println("Object: " + node.value.toString() + " was deleted from the tree.\nHad 1 child: lessNode.");
          return node.lessNode;
        }
        if(node.greatNode != null && node.lessNode == null)
        {
          if(debug)
            System.out.println("Object: " + node.value.toString() + " was deleted from the tree.\nHad 1 child: greatNode.");
          return node.greatNode;
        }
        if(debug)
          System.out.println("Object: " + node.value.toString() + " was deleted from the tree.\nHad 2 children.");
        BinaryNode<T> minNode = getMin(node.greatNode);
        node.greatNode = delete(minNode.value,node.greatNode);
        node.value = minNode.value;
        return node;
      }
      return node;
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
    /**
    * Determine the Height of the Tree
    * @return int
    */
    public int Height()
    {
      return Height(root);
    }
    /**
    * Determine the Height of a subtree.
    * @param node Node to count Height of.
    * @return int
    */
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
    * @return BinaryNode<T>
    */
    public BinaryNode<T> find(T value)
    {
      if(root == null)
      {
        if(debug)
          System.out.println("Searched for Object: " + value.toString() + " and was not found");
        return null;
      }
      int compareVal = root.compareTo(value);
      if(compareVal == 0)
      {
        if(debug)
          System.out.println("Searched for Object: " + value.toString() + " and was found");
        return root;
      }
      if(compareVal < 0)
      {
        if(root.greatNode == null)
          return null;
        else
        return find(value, root.greatNode);
      }
      else
      {
        if(root.lessNode == null)
          return null;
        else
          return find(value,root.lessNode);
      }
    }
    /**
    * Finds Object in Binrary Search Tree
    * Returns null if object cannot be found.
    * Uses compareTo function so that objects that are equal are defined by the object implementation
    * @param value Object that will be searched for in the Binary Search Tree
    * @param node Node to start search from.
    * @return BinaryNode<T>
    */
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
      if(compareVal < 0)
      {
        if(node.greatNode == null)
          return null;
        else
          return find(value, node.greatNode);
      }
      else
      {
        if(node.lessNode == null)
          return null;
        else
          return find(value,node.lessNode);
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
    /**
    * Gets the children of a node.
    * @param data List that data will be stored in.
    */
    public void getChildren(ArrayList<T> data)
    {
      getChildren(root,data);
    }
    /**
    * Gets the children of a node.
    * @param node Node to start getting child nodes from.
    * @param data List that data will be stored in.
    */
    public void getChildren(BinaryNode<T> node, ArrayList<T> data)
    {
      if(data == null)
        data = new ArrayList();
      if(node == null)
        return;
        getDataInOrder(node.lessNode,data);
        getDataInOrder(node.greatNode,data);
    }
    /**
    * Gets the smallest value in the tree.
    * @return BinaryNode<T>
    */
    public BinaryNode<T> getMin()
    {
      return getMin(root);
    }
    /**
    * Gets the smallest value in the tree.
    * @param node Node to use to find the smallest value in a subtree.
    * @return BinaryNode<T>
    */
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
    /**
    * Turns the debug function of the tree on or off.
    * @param value boolean value to set the debug option.
    */
    public void Debug(boolean value)
    {
      debug = value;
    }
}
