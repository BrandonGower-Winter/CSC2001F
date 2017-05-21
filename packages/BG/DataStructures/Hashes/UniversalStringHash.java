package BG.DataStructures.Hashes;

import java.util.Random;


/**
* Universal Hash function for strings.
* @author Brandon Gower-Winter
*/
public class UniversalStringHash extends HashFunction
{
  private int[] seedArray;
  private int tableSize;

  /**
  * Constructor
  * @param tableSize The size of the array where the hash values are being stored
  */
  public UniversalStringHash(int tableSize)
  {
    this.tableSize = tableSize;
    seedArray = new int[]{0,1,2,3,4,5,6,7,8,9};
  }
  /**
  * Constructor
  * @param tableSize The size of the array where the hash values are being stored
  * @param seed The value of the seed
  */
  public UniversalStringHash(int tableSize, long seed)
  {
    this.tableSize = tableSize;
    char[] charArray = Long.toString(seed).toCharArray();
    seedArray = new int[charArray.length];
    for(int i=0; i<charArray.length; i++)
    {
      seedArray[i] = Character.getNumericValue(charArray[i]);
    }
  }
  /**
  * Hash funtion for the UniversalStringHash
  * @param key String you want to Hash
  * @return int
  */
  public int hash(Object key)
  {
    int hashVal = 0;
    char[] charArray = ((String)key).toCharArray();
    for(int i = 0; i < charArray.length; i++)
    {
      if(i > seedArray.length - 1)
        hashVal += ((int)charArray[i]) * seedArray[0];
      else
        hashVal += ((int)charArray[i]) * seedArray[i];
    }
    return hashVal;
  }

}
