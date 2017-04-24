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
  public void testAdd()
  {
    bst = new BinarySearchTree();
    bst.add("D");
    bst.add("F");
    bst.add("B");
    bst.add("A");
    bst.add("C");
    bst.add("E");
    bst.add("G");
    bst.add("A",null);
    assertEquals(7,bst.Count());
  }
  @Test
  public void testAddDebug()
  {
    bst = new BinarySearchTree();
    bst.Debug(true);
    bst.add("D");
    bst.add("F");
    bst.add("B");
    bst.add("A");
    bst.add("C");
    bst.add("E");
    bst.add("G");
    bst.add("A",null);
    assertEquals(7,bst.Count());
  }
  @Test
  public void testDelete()
  {
    bst = new BinarySearchTree();
    bst.add("B");
    bst.delete("B");

    bst = new BinarySearchTree();
    bst.add("B");
    bst.add("A");
    bst.delete("B");

    bst = new BinarySearchTree();
    bst.add("B");
    bst.add("D");
    bst.delete("B");

    bst = new BinarySearchTree();
    bst.add("B");
    bst.add("A");
    bst.add("D");
    bst.delete("B");

    assertNull(bst.delete("A",null));

    bst.delete("Z");
    bst.delete("A");

    assertEquals(1,bst.Count());
  }
  @Test
  public void testDeleteDebug()
  {
    bst = new BinarySearchTree();
    bst.Debug(true);
    bst.add("B");
    bst.delete("B");

    bst = new BinarySearchTree();
    bst.Debug(true);
    bst.add("B");
    bst.add("A");
    bst.delete("B");

    bst = new BinarySearchTree();
    bst.Debug(true);
    bst.add("B");
    bst.add("D");
    bst.delete("B");

    bst = new BinarySearchTree();
    bst.Debug(true);
    bst.add("B");
    bst.add("A");
    bst.add("D");
    bst.delete("B");

    assertNull(bst.delete("A",null));
    bst.add("E");
    bst.delete("Z");
    bst.delete("A");
    bst.delete("E");

    assertEquals(1,bst.Count());
  }
  //Test to see if value can be found within the BinarySearchTree
  @Test
  public void testFound()
  {
    bst = new BinarySearchTree();

    bst.add("D");
    bst.add("F");
    bst.add("B");
    bst.add("A");
    bst.add("C");
    bst.add("E");
    bst.add("G");
    assertEquals("A",bst.find("A").Value());
    assertEquals("B",bst.find("B").Value());
    assertEquals("C",bst.find("C").Value());
    assertEquals("D",bst.find("D").Value());
    assertEquals("E",bst.find("E").Value());
    assertEquals("F",bst.find("F").Value());
    assertEquals("G",bst.find("G").Value());
  }
  @Test
  public void testFoundDebug()
  {
    bst = new BinarySearchTree();
    bst.Debug(true);
    bst.add("D");
    bst.add("F");
    bst.add("B");
    bst.add("A");
    bst.add("C");
    bst.add("E");
    bst.add("G");
    assertEquals("A",bst.find("A").Value());
    assertEquals("B",bst.find("B").Value());
    assertEquals("C",bst.find("C").Value());
    assertEquals("D",bst.find("D").Value());
    assertEquals("E",bst.find("E").Value());
    assertEquals("F",bst.find("F").Value());
    assertEquals("G",bst.find("G").Value());
  }
  //Test to see if value that doesn't exist can't be found within the BinarySearchTree
  @Test
  public void testNotFound()
  {
    bst = new BinarySearchTree();
    assertNull(bst.find("Allelujah Haptism"));
    bst.add("N");
    assertNull(bst.find("Allelujah Haptism"));
    assertNull(bst.find("Setsuna F. Seiei"));
    bst.add("C");
    bst.add("X");
    assertNull(bst.find("Allelujah Haptism"));
    assertNull(bst.find("Hallelujah Haptism"));
    assertNull(bst.find("Setsuna F. Seiei"));
    assertNull(bst.find("Zeta Gundam"));
    assertNull(bst.find("Allelujah Haptism",null));
  }
  @Test
  public void testNotFoundDebug()
  {
    bst = new BinarySearchTree();
    bst.Debug(true);
    assertNull(bst.find("Allelujah Haptism"));
    bst.add("N");
    bst.add("C");
    bst.add("X");
    assertNull(bst.find("Allelujah Haptism"));
    assertNull(bst.find("Hallelujah Haptism"));
    assertNull(bst.find("Setsuna F. Seiei"));
    assertNull(bst.find("Zeta Gundam"));
    assertNull(bst.find("Allelujah Haptism",null));
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
  public void testDataInOrderNullList()
  {
    ArrayList list = null;
    bst = new BinarySearchTree();

    bst.add("Lockon Stratos");
    bst.add("Setsuna F. Seiei");
    bst.add("Allelujah Haptism");

    bst.getDataInOrder(list);
    assertNull(list);
  }
  @Test
  public void testDebug()
  {
    bst = new BinarySearchTree();
    bst.Debug(false);
    assertTrue(true);
  }
  @Test
  public void testMin()
  {
    bst = new BinarySearchTree();
    bst.add("D");
    bst.add("A");
    bst.add("E");
    assertEquals("A",bst.getMin().Value());
  }
  @Test
  public void testMinNull()
  {
    bst = new BinarySearchTree();
    assertNull(bst.getMin());
  }
  @Test
  public void testPrintDataInOrder()
  {
    bst = new BinarySearchTree();
    bst.add("");
    bst.printDataInOrder();
    assertTrue(true);
  }
  @Test
  public void testPrintDataInOrderNull()
  {
    bst = new BinarySearchTree();
    bst.printDataInOrder();
    assertTrue(true);
  }
  @Test
  public void testGetChildren()
  {
    ArrayList list = new ArrayList();
    bst = new BinarySearchTree("B");
    bst.add("A");
    bst.add("C");
    bst.getChildren(list);
    assertEquals("A",list.get(0));
    assertEquals("C",list.get(1));
  }
  @Test
  public void testGetChildrenNull()
  {
    ArrayList list = null;
    bst = new BinarySearchTree();
    bst.getChildren(list);
    assertNull(list);
  }
}
