package BG.DataStructures.Hashes;

public class LinearStringASCIIHash extends HashFunction
{
  public int hash(Object key)
  {
    if(!(value instanceof String))
      throw new Exception("Value entered into hash is not of type String");

    int result = 0;
    for(char c : value.toCharArray())
    {
      result+= (int)c;
    }
    return result;
  }
}
