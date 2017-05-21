package BG.DataStructures.Hashes;

import java.lang.*;

/**
* Default hash funnction that returns the hashCode value supplied by java
* @author Brandon Gower-Winter
*/
public class HashFunction
{
  /**
  * Returns the object.hashCode() value
  * @return int
  * @param key Key to be hashed
  */
  public int hash(Object key)
  {
    return key.hashCode();
  }
}
