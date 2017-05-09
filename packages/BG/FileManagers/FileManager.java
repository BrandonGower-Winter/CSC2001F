package BG.FileManagers;

import java.lang.*;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public abstract class FileManager
{
  public static List<File> getContents(File folderToSearch)
  {
    List<File> files = new ArrayList();
    if(!folderToSearch.isDirectory())
    {
      return null;
    }
    else
    {
      for(File f : folderToSearch.listFiles())
      {
        if(f.isDirectory())
        {
          files.addAll(getContents(f));
        }
        else
        {
          files.add(f);
        }
      }
      return files;
    }
  }
}
