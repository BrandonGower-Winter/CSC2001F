package BG.DataStructures.Hashes;
/**
* Constant return Hash
* Returns a constant no matter what key is added
* @author Brandon Gower-Winter
*/
public class ConstantReturnHash extends HashFunction
{
  /**
  * Hash function that returns a constant of 0 for any key.
  * @param key The key that is used in the hash
  * @return int
  */
  public int hash(Object key)
  {
    return 0;
  }
}
