import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.*;
import java.util.*;
import BG.DataStructures.*;

public class TestAVLTree
{
  AVLTree<String> avl;

  //Tests to see if the Binary Search Tree is initialised properly with no root node specified
  @Test
  public void testInitialisationEmptyTree()
  {
    avl = new AVLTree();
    assertEquals(0,avl.Count());
  }
  //Tests to see if the Binary Search Tree is initialised properly with a root node.
  @Test
  public void testInitialisationWithRootNode()
  {
    avl = new AVLTree("Jane Doe");
    assertEquals(1,avl.Count());
  }
  //Tests to see if nodes are being added to the tree.

  @Test
  public void testBalanceRight()
  {
    ArrayList list = new ArrayList();
    avl = new AVLTree();
    avl.Debug(true);
    avl.add("A");
    avl.add("B");
    avl.add("C");
    avl.add("E");
    avl.add("D");
    assertEquals(avl.Count(),5);
  }
  @Test
  public void testBalanceRightInner()
  {
    ArrayList list = new ArrayList();
    avl = new AVLTree();
    avl.Debug(true);
    avl.add("A");
    avl.add("D");
    avl.add("C");
    assertEquals(avl.Height(),2);
  }
  @Test
  public void testBalanceLeft()
  {
    ArrayList list = new ArrayList();
    avl = new AVLTree();
    avl.Debug(true);
    avl.add("E");
    avl.add("D");
    avl.add("C");
    avl.add("A");
    avl.add("B");
    assertEquals(avl.Count(),5);
  }
  @Test
  public void testBalanceLeftInner()
  {
    ArrayList list = new ArrayList();
    avl = new AVLTree();
    avl.Debug(true);
    avl.add("C");
    avl.add("A");
    avl.add("B");
    assertEquals(avl.Height(),2);
  }
}
