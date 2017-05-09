package BG.Util;

import BG.DataStructures.Hashes.*;
import java.lang.Math;

public class HashEntropy
{
  private boolean d;
  private int[] counter;

  private int testCounter;

  private double[] probabilityArray;
  private double[] computeArray;

  private HashFunction hf;

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

  private void populate()
  {
    for(int i = 0; i < counter.length; i++)
    {
      counter[i] = 0;
    }
  }

  public void addTest(Object o)
  {
    if(!d && hf != null)
    {
      int hashVal = (int)(hf.hash(o) % counter.length);
      counter[hashVal] +=1;
      testCounter++;
    }
  }

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

  public int[] Done()
  {
    d = true;
    return counter;
  }
}
