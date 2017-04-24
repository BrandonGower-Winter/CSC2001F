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
  public void testAdditionToTheTree()
  {
    avl = new AVLTree();
    avl.add("Jane Doe");
    assertEquals(1,avl.Count());
  }
  //Test to see if value can be found within the AVLTree
  @Test
  public void testFound()
  {
    avl = new AVLTree();
    avl.add("Jane Doe");
    avl.add("Billy Bob");
    avl.add("John Doe");
    assertEquals("John Doe",avl.find("John Doe").Value());
  }
  //Test to see if value that doesn't exist can't be found within the AVLTree
  @Test
  public void testNotFound()
  {
    avl = new AVLTree();
    avl.add("Jane Doe");
    avl.add("Billy Bob");
    avl.add("John Doe");
    assertNull(avl.find("Allelujah Haptism"));
  }
  //Test to see if data can be returned in order from the AVLTree
  @Test
  public void testDataInOrder()
  {
    ArrayList list = new ArrayList();
    avl = new AVLTree();

    avl.add("Lockon Stratos");
    avl.add("Setsuna F. Seiei");
    avl.add("Allelujah Haptism");

    avl.getDataInOrder(list);
    assertEquals("Allelujah Haptism",list.get(0));
    assertEquals("Lockon Stratos",list.get(1));
    assertEquals("Setsuna F. Seiei",list.get(2));
  }
  @Test
  public void testHeight()
  {
    ArrayList list = new ArrayList();
    avl = new AVLTree();

    avl.add("Lockon Stratos");
    avl.add("Setsuna F. Seiei");
    avl.add("Allelujah Haptism");
    assertEquals(avl.Height(),2);
  }
  @Test
  public void testBalanceRight()
  {
    ArrayList list = new ArrayList();
    avl = new AVLTree();

    avl.add("A");
    avl.add("B");
    avl.add("C");
    assertEquals(avl.Height(),2);
  }
  @Test
  public void testBalanceRightInner()
  {
    ArrayList list = new ArrayList();
    avl = new AVLTree();

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

    avl.add("C");
    avl.add("B");
    avl.add("A");
    assertEquals(avl.Height(),2);
  }
  @Test
  public void testBalanceLeftInner()
  {
    ArrayList list = new ArrayList();
    avl = new AVLTree();

    avl.add("C");
    avl.add("A");
    avl.add("B");
    assertEquals(avl.Height(),2);
  }
  @Test
  public void testDelete()
  {
    ArrayList list = new ArrayList();
    avl = new AVLTree();
    avl.add("A");
    avl.add("B");
    avl.add("C");
    avl.delete("A");
    assertEquals(avl.Count(),2);
  }

}
