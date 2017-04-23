import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.*;
import java.util.*;
import BG.DataStructures.*;

public class TestAVLTree
{
  AVLTree<String> avl;

  public void testInitialisationEmptyTree()
  {
    avl = new AVLTree();
    avl.Count();
  }

}
