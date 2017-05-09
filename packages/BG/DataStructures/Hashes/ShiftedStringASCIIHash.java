package BG.DataStructures.Hashes;

import java.lang.*;

public class ShiftedStringASCIIHash extends HashFunction
{
  private int seed;

  public ShiftedStringASCIIHash()
  {
    seed = 37;
  }
  public ShiftedStringASCIIHash(int seed)
  {
    this.seed = seed;
  }

  public int hash(Object key)
  {
    int result = 0;
    for(char c : ((String)key).toCharArray())
    {
      result = (result*seed) + (int)c;
    }
    return result;
  }
  public void Seed(int value)
  {
    seed = value;
  }
  public int Seed()
  {
    return seed;
  }
}
