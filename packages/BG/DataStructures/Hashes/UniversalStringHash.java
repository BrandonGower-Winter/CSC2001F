package BG.DataStructures.Hashes;

import java.util.Random;

public class UniversalStringHash extends HashFunction
{
  private int[] seedArray;
  private int tableSize;


  public UniversalStringHash(int tableSize)
  {
    this.tableSize = tableSize;
    seedArray = new int[]{0,1,2,3,4,5,6,7,8,9};
  }
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
