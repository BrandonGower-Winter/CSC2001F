/*
Brandon Gower-Winter
Search It main class
*/
import java.lang.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class SearchIt
{
  public static void main(String args[])
  {
    BinarySearchTree<Person> bst = new BinarySearchTree();
    //Get data from text file
    try
    {
      Scanner scFile = new Scanner(new File("testdata"));
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
      Scanner scFile = new Scanner(new File("querydata"));
      while(scFile.hasNextLine())
      {
          String name = scFile.nextLine();
          Person personToFind = new Person(name);
          personToFind = bst.find(personToFind);

          if(personToFind == null)
          {
            System.out.println(name + " was not found");
          }
          else
          {
            System.out.println(personToFind.toString());
          }
      }
    }
    catch(FileNotFoundException e)
    {
      System.err.println("Query file not found");
    }
  }
}
