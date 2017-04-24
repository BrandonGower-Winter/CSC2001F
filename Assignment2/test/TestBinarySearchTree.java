import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.*;
import java.util.*;
import BG.DataStructures.*;

public class TestBinarySearchTree
{
  BinarySearchTree<String> bst;

  //Tests to see if the Binary Search Tree is initialised properly with no root node specified
  @Test
  public void testInitialisationEmptyTree()
  {
    bst = new BinarySearchTree();
    assertEquals(0,bst.Count());
  }
  //Tests to see if the Binary Search Tree is initialised properly with a root node.
  @Test
  public void testInitialisationWithRootNode()
  {
    bst = new BinarySearchTree("Jane Doe");
    assertEquals(1,bst.Count());
  }
  //Tests to see if nodes are being added to the tree.
  @Test
  public void testAdditionToTheTree()
  {
    bst = new BinarySearchTree();
    bst.add("Jane Doe");
    assertEquals(1,bst.Count());
  }
  //Test to see if value can be found within the BinarySearchTree
  @Test
  public void testFound()
  {
    bst = new BinarySearchTree();
    bst.add("Jane Doe");
    bst.add("Billy Bob");
    bst.add("John Doe");
    assertEquals("John Doe",bst.find("John Doe").Value());
  }
  //Test to see if value that doesn't exist can't be found within the BinarySearchTree
  @Test
  public void testNotFound()
  {
    bst = new BinarySearchTree();
    bst.add("Jane Doe");
    bst.add("Billy Bob");
    bst.add("John Doe");
    assertNull(bst.find("Allelujah Haptism"));
  }
  //Test to see if data can be returned in order from the BinarySearchTree
  @Test
  public void testDataInOrder()
  {
    ArrayList list = new ArrayList();
    bst = new BinarySearchTree();

    bst.add("Lockon Stratos");
    bst.add("Setsuna F. Seiei");
    bst.add("Allelujah Haptism");

    bst.getDataInOrder(list);
    assertEquals("Allelujah Haptism",list.get(0));
    assertEquals("Lockon Stratos",list.get(1));
    assertEquals("Setsuna F. Seiei",list.get(2));
  }
  @Test
  public void testDelete()
  {
    ArrayList list = new ArrayList();
    bst = new BinarySearchTree();

    bst.add("A");
    bst.add("B");
    bst.add("C");
    bst.delete("A");
    assertEquals(bst.Count(),2);
  }
}
