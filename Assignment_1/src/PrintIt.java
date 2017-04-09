import java.lang.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

/**
* Main Class for task one of assignment one
* Adds data to a binary search tree
* Uses in order traversal to print out the data in alphabetical order.
* @author Brandon Gower-Winter
*/
public class PrintIt
{
    public static void main(String args[])
    {
        try
        {
            BinarySearchTree<Person> bst = new BinarySearchTree<Person>();
            Scanner scFile = new Scanner(new File("../resources/testdata"));
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
            ArrayList<Person> data = new ArrayList();
            bst.getDataInOrder(data);
            for(int i = 0; i < data.size(); i++)
            {
              System.out.println(data.get(i).toString());
            }

        }
        catch(FileNotFoundException e)
        {
            System.err.println("Data file not found");
        }
    }
}
