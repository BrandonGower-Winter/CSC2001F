import java.lang.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import BG.DataStructures.*;
import java.time.Duration;
import java.time.Instant;
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
    //bst.Debug(true);
    //Get data from text file
    try
    {
      Scanner scFile = new Scanner(new File("./resources/testdata10000"));
      //Instant start = Instant.now();
      while(scFile.hasNextLine())
      {
        Scanner scLine = new Scanner(scFile.nextLine()).useDelimiter("\\|");
        String address = scLine.next();
        String number = scLine.next();
        String name = scLine.next();

        bst.add(new Person(name,number,address));

        scLine.close();
      }
      //Instant end = Instant.now();
      //Duration timeElapsed = Duration.between(start, end);
      //System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
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
      //Instant start = Instant.now();
      while(scFile.hasNextLine())
      {
          String name = scFile.nextLine();
          Person personToFind = new Person(name);
          BinaryNode<Person> foundPerson= bst.find(personToFind);

          if(foundPerson == null)
          {
            System.out.println(name + " was not found");
          }
          else
          {
            System.out.println(foundPerson.Value().toString());
          }
      }
      //Instant end = Instant.now();
      //Duration timeElapsed = Duration.between(start, end);
      //System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
    }
    catch(FileNotFoundException e)
    {
      System.err.println("Query file not found");
    }
    /*
    try
    {
      Scanner scFile = new Scanner(new File("./resources/querydata"));
      Instant start = Instant.now();
      while(scFile.hasNextLine())
      {
          String name = scFile.nextLine();
          Person personToFind = new Person(name);
          bst.delete(personToFind);
      }
      Instant end = Instant.now();
      Duration timeElapsed = Duration.between(start, end);
      System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
    }
    catch(FileNotFoundException e)
    {
      System.err.println("Query file not found");
    }
    */
  }
}
