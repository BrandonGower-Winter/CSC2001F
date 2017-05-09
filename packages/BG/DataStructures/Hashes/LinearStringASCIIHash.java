package BG.DataStructures.Hashes;

import java.lang.*;

public class LinearStringASCIIHash extends HashFunction
{
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
