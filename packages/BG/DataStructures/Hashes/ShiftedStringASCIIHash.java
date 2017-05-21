package BG.DataStructures.Hashes;

import java.lang.*;
import java.lang.Math;

/**
* A hash funtion for the strings that returns the summation of it's characters unicode values shifted by a seed value
* @author Brandon Gower-Winter
*/
public class ShiftedStringASCIIHash extends HashFunction
{
  private int seed;

  /**
  * Constructor that sets the  seed value to 7
  */
  public ShiftedStringASCIIHash()
  {
    seed = 7;
  }
  /**
  * Constructor that sets the seed to the specified amount
  * @param seed Value of seed
  */
  public ShiftedStringASCIIHash(int seed)
  {
    this.seed = seed;
  }
  /**
  * Hash funstion for strings that returns the summation of the strings characters shifted by some seed value
  * @param key String to hash
  * @return int
  */
  public int hash(Object key)
  {
    int result = 0;
    for(char c : ((String)key).toCharArray())
    {
      result = (result*seed) + (int)c;
    }
    return Math.abs(result);
  }
  /**
  * Setter for seed
  * @param value New value of the seed
  */
  public void Seed(int value)
  {
    seed = value;
  }
  /**
  * Getter for seed
  * @return int
  */
  public int Seed()
  {
    return seed;
  }
}
