/*
Brandon Gower-Winter
Generic Binary Search Tree data structure
*/

import java.lang.*;

public class BinarySearchTree<T extends Comparable>
{
    //private variables
    private Node<T> root;
    
    public BinarySearchTree(T rootValue)
    {
        root = new Node<T>(rootValue);
    }
    
    //Add new item to Tree
    public void add(T newValue)
    {
        root.add(newValue);    
    }
    
    public T find(T valueToFind)
    {
        return root.find(valueToFind);
    }
    
    public void sort()
    {
        //Implement
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