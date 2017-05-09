

package BG.DataStructures;
public interface IDataStruct<T>
{

  private int count;

  public void add(T value);
  //Delete specific entry
  public void delete(T value);
  //Find specific entry
  public T find(T value);
  //Count number of elements
  public int Count();
  //getFirst
  public T getFirst();
  //getLast
  public T getLast();
}
