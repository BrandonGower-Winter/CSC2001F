import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.*;

public class TestPerson
{
  Person p;

  //Tests to see if the object instantiation is correct.
  @Test
  public void TestPersonInitialisation()
  {
    p = new Person("Setsuna F. Seiei","00","Exia,Ptolemaios");
    assertEquals("Setsuna F. Seiei\t00\tExia,Ptolemaios",p.toString());
  }
  //Test to see if the object instantiation is correct when only name is entered.
  @Test
  public void TestPersonInitialisationaName()
  {
    p = new Person("Mikazuki Augus");
    assertEquals("Mikazuki Augus", p.getName());
  }
  @Test
  public void TestCompareTo()
  {
    p = new Person("Mikazuki Augus");
    assertEquals(0,p.compareTo(new Person("Mikazuki Augus")));
  }
}
