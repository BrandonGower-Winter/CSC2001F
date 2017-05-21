package BG.DataStructures.Hashes;

import java.lang.*;

/**
* HashFunction for strings that adds their unicode values together.
* @author Brandon Gower-Winter
*/
public class LinearStringASCIIHash extends HashFunction
{
  /**
  * Hash funtion for a string value that returns the summation of it's characters unicode values.
  * @param key String to be hashed
  * @return int
  */
  public int hash(Object key)
  {
    String s = (String) key;
    int result = 0;
    for(int i = 0; i < s.length();i++)
    {
      result+= s.charAt(i);
    }
    return result;
  }
}
