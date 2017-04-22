package BG.DataStructures;

import java.lang.*;
import java.util.*;

public class AVLTree<T extends Comparable> extends BinarySearchTree
{
  public AVLTree()
  {
    super.root = null;
  }
  public AVLTree(T value)
  {
    super.root = new BinaryNode<T>(value);
  }
  //Add Balances
}
