import java.lang.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import BG.DataStructures.*;

public class SearchAVL
{
  public static void main(String[] args)
  {
    AVLTree<Person> avl = new AVLTree();
    //Get data from text file
    try
    {
      Scanner scFile = new Scanner(new File("./resources/testdata"));
      while(scFile.hasNextLine())
      {
        Scanner scLine = new Scanner(scFile.nextLine()).useDelimiter("\\|");
        String address = scLine.next();
        String number = scLine.next();
        String name = scLine.next();
        avl.add(new Person(name,number,address));
        scLine.close();
      }
      scFile.close();
    }
    catch(FileNotFoundException e)
    {
      System.err.println("Data file not found");
    }
    //Get query from text file and print search results
    try
    {
      Scanner scFile = new Scanner(new File("./resources/querydata"));
      while(scFile.hasNextLine())
      {
          String name = scFile.nextLine();
          Person personToFind = new Person(name);
          BinaryNode<Person> foundPerson= avl.find(personToFind);

          if(foundPerson == null)
          {
            System.out.println(name + " was not found");
          }
          else
          {
            System.out.println(foundPerson.Value().toString());
          }
      }
    }
    catch(FileNotFoundException e)
    {
      System.err.println("Query file not found");
    }
  }
}
