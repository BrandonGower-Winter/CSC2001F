import java.lang.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


/**
* Search it main class for task 3 of assignment 1
* Data is stored in Array List
* Queries are taken from a file
* Query is searched for in the ArrayList and an appropriate result is returned.
* @author Brandon Gower-Winter
*/
public class SearchItLinear
{
  public static void main(String args[])
  {
    ArrayList<Person> dataArray = new ArrayList();
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
        dataArray.add(new Person(name,number,address));
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
          boolean found = false;
          for(int i = 0; i < dataArray.size(); i++)
          {
            if(dataArray.get(i).compareTo(personToFind) == 0)
            {
              personToFind = dataArray.get(i);
              found = true;
              break;
            }
          }
          if(found)
          {
            System.out.println(personToFind.toString());
          }
          else
          {
            System.out.println(personToFind.getName() + " was not found.");
          }
      }
    }
    catch(FileNotFoundException e)
    {
      System.err.println("Query file not found");
    }
  }
}
