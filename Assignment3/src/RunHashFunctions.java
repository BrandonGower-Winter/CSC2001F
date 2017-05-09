import java.lang.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import BG.DataStructures.Hashes.*;
import BG.Util.HashEntropy;

public class RunHashFunctions
{
  public static void main(String[] args) {
    try
    {
        Scanner scFile = new Scanner(new File("./resources/testdata"));
        while(scFile.hasNextLine())
        {
            Scanner scLine = new Scanner(scFile.nextLine()).useDelimiter("\\|");
            String address = scLine.next();
            String number = scLine.next();
            String name = scLine.next();
            scLine.close();
        }
        scFile.close();
    }
    catch(FileNotFoundException e)
    {
        System.err.println("Data file not found");
    }
  }
}
