/*
Brandon Gower-Winter
Generic Binary Search Tree data structure
*/

import java.lang.*;
import java.util.*;

public class BinarySearchTree<T extends Comparable>
{
    //private variables
    private Node<T> root;
    private int size;
    public BinarySearchTree()
    {
        root=null;
        size = 0;
    }

    public BinarySearchTree(T rootValue)
    {
        root = new Node<T>(rootValue);
        size = 1;
    }

    //Add new item to Tree
    public void add(T newValue)
    {
        if(root != null)
            root.add(newValue);
        else
            root = new Node(newValue);
        size++;
    }

    public T find(T valueToFind)
    {
        if(root != null)
            return root.find(valueToFind);
        else
            return null;
    }

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
    private class Node<T extends Comparable>
    {
        private T value;
        private Node<T> lessNode;
        private Node<T> greaterNode;

        public Node(T value)
        {
            this.value = value;
            lessNode = null;
            greaterNode = null;
        }

        public Node<T> getLessNode()
        {
            return lessNode;
        }

        public Node<T> getGreaterNode()
        {
            return greaterNode;
        }

        public void setLessNode(Node<T> node)
        {
            lessNode = node;
        }

        public void setGreaterNode(Node<T> node)
        {
            greaterNode = node;
        }

        public T getValue()
        {
            return value;
        }

        public void setValue(T value)
        {
            this.value = value;
        }

        public void add(T newValue)
        {
            int compareVal = value.compareTo(newValue);
            if(compareVal > 0)
            {
                //Greater than
                if(greaterNode == null)
                {
                    greaterNode = new Node<T>(newValue);
                    return;
                }
                greaterNode.add(newValue);
            }
            else if(compareVal < 0)
            {
                //Less than
                if(lessNode == null)
                {
                    lessNode = new Node<T>(newValue);
                    return;
                }
                lessNode.add(newValue);
            }
            else
            {
                //Equal to
                Node<T> tempNode = lessNode;
                lessNode = new Node<T>(newValue);
                lessNode.setLessNode(tempNode);
            }
        }
        public T find(T valueToFind)
        {
            int compareVal = value.compareTo(valueToFind);
            //base case
            if(compareVal == 0)
            {
                return value;
            }
            //Recursive Step
            if(compareVal > 0)
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
