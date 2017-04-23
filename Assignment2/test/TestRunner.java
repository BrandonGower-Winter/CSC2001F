import org.junit.runner.*;
import org.junit.runner.notification.*;

public class TestRunner
{
  public static void main(String[] args)
  {
    Class[] classes = {TestBinarySearchTree.class, TestPerson.class, TestAVLTree.class};
    Result r = JUnitCore.runClasses(classes);
    for(Failure f : r.getFailures())
    {
      System.out.println(f.toString());
    }
    System.out.println(r.wasSuccessful());
  }
}
