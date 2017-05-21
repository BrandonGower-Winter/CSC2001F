import java.lang.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import BG.DataStructures.Hashes.*;
import BG.Util.HashEntropy;

/**
* Testing place for HashEntropy utility
* Contains a main class and tests the entropy of 4 different hash funstions on data located int he resources folder.
* @author Brandon Gower-Winter
*/
public class RunHashFunctions
{
  public static void main(String[] args) {
    try
    {
        List<String> names = new ArrayList();
        Scanner scFile = new Scanner(new File("./resources/testdata"));
        while(scFile.hasNextLine())
        {
            Scanner scLine = new Scanner(scFile.nextLine()).useDelimiter("\\|");
            String address = scLine.next();
            String number = scLine.next();
            String name = scLine.next();
            names.add(name);
            scLine.close();
        }
        scFile.close();
        HashEntropy he;
        //Calculating Hashes
        HashFunction hf = new UniversalStringHash(20011,912471914);
        he = new HashEntropy(20011,hf);
        for(int i = 0; i<names.size(); i++)
        {
          int val = he.addTest(names.get(i));
          if(i < 10)
            System.out.println("Hash value for " +names.get(i)+" is: " + val%20011);
        }
        he.Done();
        he.calculateProbability();
        he.computeProbabilityToEntropyBit();
        System.out.println("Entropy of universal hash function is: " + he.calculateEntropy());
        hf = new ConstantReturnHash();
        he = new HashEntropy(20011,hf);
        for(int i = 0; i<names.size(); i++)
        {
          int val = he.addTest(names.get(i));
          if(i < 10)
            System.out.println("Hash value for " +names.get(i)+" is: " + val%20011);
        }
        he.Done();
        he.calculateProbability();
        he.computeProbabilityToEntropyBit();
        System.out.println("Entropy of constant return hash function is: " + he.calculateEntropy());
        hf = new LinearStringASCIIHash();
        he = new HashEntropy(20011,hf);
        for(int i = 0; i<names.size(); i++)
        {
          int val = he.addTest(names.get(i));
          if(i < 10)
            System.out.println("Hash value for " +names.get(i)+" is: " + val%20011);
        }
        he.Done();
        he.calculateProbability();
        he.computeProbabilityToEntropyBit();
        System.out.println("Entropy of ACII summation hash function is: " + he.calculateEntropy());
        hf = new ShiftedStringASCIIHash();
        he = new HashEntropy(20011,hf);
        for(int i = 0; i<names.size(); i++)
        {
          int val = he.addTest(names.get(i));
          if(i < 10)
            System.out.println("Hash value for " +names.get(i)+" is: " + val%20011);

        }
        he.Done();
        he.calculateProbability();
        he.computeProbabilityToEntropyBit();
        System.out.println("Entropy of shifted ASCII summation hash function is: " + he.calculateEntropy());

    }
    catch(FileNotFoundException e)
    {
        System.err.println("Data file not found");
    }
  }
}
