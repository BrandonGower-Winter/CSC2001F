package BG.DataStructures.Hashes;

import java.lang.*;

public class LinearStringASCIIHash extends HashFunction
{
  public int hash(Object key)
  {
    int result = 0;
    for(char c : ((String)key).toCharArray())
    {
      result+= (int)c;
    }
    return result;
  }
}
