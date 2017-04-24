import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.*;
import java.util.*;
import BG.DataStructures.*;

public class TestBinaryNode
{
  BinaryNode<String> node;

  @Test
  public void TestNodeValue()
  {
    node = new BinaryNode("A");
    assertEquals("A",node.Value());
  }
  @Test
  public void TestNodeCompareTo()
  {
    node = new BinaryNode("A");
    assertEquals(0,node.compareTo("A"));
  }
}
