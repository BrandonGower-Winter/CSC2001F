import java.lang.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
* Search it main class for task 2 of assignment 1
* Data is stored in Binary Search Tree
* Queries are taken from a file
* Query is searched for in the BST and an appropriate result is returned.
* @author Brandon Gower-Winter
*/
public class SearchIt
{
  public static void main(String args[])
  {
    BinarySearchTree<Person> bst = new BinarySearchTree();
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
        bst.add(new Person(name,number,address));
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
      Scanner scFile = new Scanner(new File("./resources/querydataE"));
      while(scFile.hasNextLine())
      {
          String name = scFile.nextLine();
          Person personToFind = new Person(name);
          personToFind = bst.find(personToFind);

          if(personToFind == null)
          {
            //System.out.println(name + " was not found");
          }
          else
          {
            //System.out.println(personToFind.toString());
          }
      }
    }
    catch(FileNotFoundException e)
    {
      System.err.println("Query file not found");
    }
  }
}
