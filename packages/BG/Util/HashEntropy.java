package BG.Util;

import BG.DataStructures.Hashes.*;
import java.lang.Math;
/**
* Utility for testing the entropy of a hash function.
* @author Brandon Gower-Winter
*/
public class HashEntropy
{
  private boolean d;
  private int[] counter;

  private int testCounter;

  private double[] probabilityArray;
  private double[] computeArray;

  private HashFunction hf;
  /**
  * Constructor
  * @param arraySize Size of the array to be used for testing
  */
  public HashEntropy(int arraySize)
  {
    counter = new int[arraySize];
    probabilityArray = new double[arraySize];
    computeArray = new double[arraySize];
    populate();
    d = false;
    hf = new HashFunction();
    testCounter = 0;
  }
  /**
  * Constructor
  * @param arraySize Size of the array to be used for testing
  * @param hf The HashFunction you want to test
  */
  public HashEntropy(int arraySize, HashFunction hf)
  {
    counter = new int[arraySize];
    probabilityArray = new double[arraySize];
    computeArray = new double[arraySize];
    populate();
    d = false;
    this.hf = hf;
    testCounter = 0;
  }
  /**
  * Populates the array with zeros
  */
  private void populate()
  {
    for(int i = 0; i < counter.length; i++)
    {
      counter[i] = 0;
    }
  }
  /**
  * Runs test on hash function specified
  * @return int
  */
  public int addTest(Object o)
  {
    if(!d && hf != null)
    {
      int hashVal = (int)(hf.hash(o) % counter.length);
      counter[hashVal] +=1;
      testCounter++;
      return hashVal;
    }
    return -1;
  }
  /**
  * Calculates the probability of each value.
  * @return double[]
  */
  public double[] calculateProbability()
  {
    if(d)
    {
      for(int i = 0; i < counter.length; i++)
      {
        probabilityArray[i] = counter[i]/(double)testCounter;
      }
      return probabilityArray;
    }
    else
      return null;
  }
  /**
  * Calculates the entropy bits
  * @return double[]
  */
  public double[] computeProbabilityToEntropyBit()
  {
    if(d)
    {
      for(int i = 0; i < counter.length; i++)
      {
        if(probabilityArray[i] == 0)
          computeArray[i] = 0;
        else
        computeArray[i] = -1*probabilityArray[i]*Math.log(probabilityArray[i]);
      }
      return computeArray;
    }
    else
      return null;
  }
  /**
  * Calculates the Entropy
  *@return double
  */
  public double calculateEntropy()
  {
    double entropy = 0;
    if(d)
    {
      for(int i = 0; i < counter.length; i++)
      {
        entropy += computeArray[i];
      }
      return entropy;
    }
    else
      return -1;
  }
  /**
  * Marks the testing as done so probability and entropy can be tested
  * @returns Trivial hash table used to store counters
  * @return int[]
  */
  public int[] Done()
  {
    d = true;
    return counter;
  }
}
