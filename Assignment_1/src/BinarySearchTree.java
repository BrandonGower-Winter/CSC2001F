import java.lang.*;
import java.util.*;

/**
* A generic Binary Search Tree data structure.
* The T parameter must implement the Comparable interface.
* The tree does not have a left and right node.
  It uses lessNode and greaterNode in which values smaller than and values greater
  than the current node are stored respectively
* @author Brandon Gower-Winter
*/
public class BinarySearchTree<T extends Comparable>
{
    //private variables
    private Node<T> root;
    private int count;
    /**
    * Default constructor for Binary Search Tree.
    * Sets root node to null
    */
    public BinarySearchTree()
    {
        root=null;
    }
    /**
    * Constructor for Binary Search Tree that has one argument
    * @param rootValue The object that will be set as the root node
    */
    public BinarySearchTree(T rootValue)
    {
        root = new Node<T>(rootValue);
    }

    //Add new item to Tree
    /**
    * Add object to the Binrary Search Tree
    * @param newValue Object to add to the Binary Search Tree
    */
    public void add(T newValue)
    {
        if(root != null)
            root.add(newValue);
        else
            root = new Node(newValue);
    }
    /**
    * Returns the number of nodes in the Binary Search Tree from the root node
    * @return int
    */
    public int Count()
    {
      if(root == null)
        return 0;

      return Count(root);
    }
    /**
    * Returns the number of nodes in the Binary Search Tree from the specified node
    * @param node The node to start counting from.
    * @return int
    */
    public int Count(Node<T> node)
    {
      if(node == null)
        return 0;

      return 1 + Count(node.lessNode) + Count(node.greaterNode);
    }
    /**
    * Finds Object in Binrary Search Tree
    * Returns null if object cannot be found.
    * Uses compareTo function so that objects that are equal are defined by the object implementation
    * @param valueToFind Object that will be searched for in the Binary Search Tree
    */
    public T find(T valueToFind)
    {
        if(root != null)
            return root.find(valueToFind);
        else
            return null;
    }
    /**
    * Prints the data in order within the Binary Seach Tree to the output stream
    * Prints from the root node
    * Uses in-order traversal algorithm
    */
    public void printDataInOrder()
    {
        if(root == null)
        {
          return;
        }
        printDataInOrder(root.lessNode);
        System.out.println(root.value.toString());
        printDataInOrder(root.greaterNode);

    }
    /**
    * Prints the data in order within the Binary Seach Tree to the output stream
    * Prints from the specified node
    * Uses in-order traversal algorithm
    @param node Specifies which node to start printing from.
    */
    public void printDataInOrder(Node<T> node)
    {
        if(node == null)
        {
          return;
        }
        printDataInOrder(node.lessNode);
        System.out.println(node.value.toString());
        printDataInOrder(node.greaterNode);
    }
    /**
    * Returns the data of the Binary Search Tree
    * Returns from root node
    * Uses in-order traversal algorithm
    * @param data The ArrayList that will have the data stored in it
    */
    public void getDataInOrder(ArrayList<T> data)
    {
      if(data == null)
      {
        data = new ArrayList();
      }
      if(root == null)
      {
        return;
      }
      getDataInOrder(root.lessNode,data);
      data.add(root.value);
      getDataInOrder(root.greaterNode,data);
    }
    /**
    * Returns the data of the Binary Search Tree
    * Returns from specified node
    * Uses in-order traversal algorithm
    * @param node Node to start getting from data from
    * @param data The ArrayList that will have the data stored in it
    */
    public void getDataInOrder(Node<T> node, ArrayList<T> data)
    {
      if(data == null)
      {
        data = new ArrayList();
      }
      if(node == null)
      {
        return;
      }
      getDataInOrder(node.lessNode,data);
      data.add(node.value);
      getDataInOrder(node.greaterNode,data);
    }
    //Inner Node Class
    /**
    * A generic node for a Binary Tree.
    * The T parameter must implement the Comparable interface.
    * The node stores a value of Type T.
    * The node can store two other nodes of the same type. One node that is greater in value(greaterNode)
      and another that is smaller in value(lessNode).
    * @author Brandon Gower-Winter
    */
    private class Node<T extends Comparable>
    {
        private T value;
        private Node<T> lessNode;
        private Node<T> greaterNode;
        /**
        * Constructor of a Node object.
        * Sets both lessNode and greaterNode to null.
        * @param value The object you wish to store in the node.
        */
        public Node(T value)
        {
            this.value = value;
            lessNode = null;
            greaterNode = null;
        }
        /**
        * Returns the less node.
        * Returns null if there is no less node
        * @return Node<T>
        */
        public Node<T> getLessNode()
        {
            return lessNode;
        }
        /**
        * Returns the greater node.
        * Returns null if there is no greater node.
        * @return Node<T>
        */
        public Node<T> getGreaterNode()
        {
            return greaterNode;
        }
        /**
        * Sets the less node to the node provided.
        * @param node The node which will be set as the less node.
        */
        public void setLessNode(Node<T> node)
        {
            lessNode = node;
        }
        /**
        * Sets the greater node to the node provided.
        * @param node The node which will be set as the greater node.
        */
        public void setGreaterNode(Node<T> node)
        {
            greaterNode = node;
        }
        /**
        * Returns the object of type T stores as the value of the node.
        * @return T
        */
        public T getValue()
        {
            return value;
        }
        /**
        * Sets the value of the node.
        * @param value The object of type T that you would like to store as the value of the node.
        */
        public void setValue(T value)
        {
            this.value = value;
        }
        /**
        * This is an extenstion to the add function within the BinarySearchTree class.
        * This function recursively goes through the BinarySearchTree until it gets to the correct place to add the Node.
        * @param newValue The value of type T that you would like to add to the Binary Search Tree.
        */
        public void add(T newValue)
        {
            int compareVal = value.compareTo(newValue);
            if(compareVal > 0)
            {
                //Less than
                if(lessNode == null)
                {
                    lessNode = new Node<T>(newValue);
                    return;
                }
                lessNode.add(newValue);
            }
            else if(compareVal < 0)
            {
                //Greater than
                if(greaterNode == null)
                {
                    greaterNode = new Node<T>(newValue);
                    return;
                }
                greaterNode.add(newValue);
            }
            else
            {
                //Equal to
                Node<T> tempNode = lessNode;
                lessNode = new Node<T>(newValue);
                lessNode.setLessNode(tempNode);
            }
        }
        /**
        * Searches through the Binary Tree for the value specified.
        * Extention of find in the BinarySearchTree class.
        * Search is done recursively.
        * @param valueToFind The value that will be looked for in the binary search tre.
        * @return T
        */
        public T find(T valueToFind)
        {
            int compareVal = value.compareTo(valueToFind);
            //base case
            if(compareVal == 0)
            {
                return value;
            }
            //Recursive Step
            if(compareVal < 0)
            {
                if(greaterNode==null)
                    return null;
                return greaterNode.find(valueToFind);
            }
            else
            {
                if(lessNode == null)
                    return null;
                return lessNode.find(valueToFind);
            }
        }
    }
}
