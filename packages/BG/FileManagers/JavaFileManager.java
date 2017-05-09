package BG.FileManagers;

import java.lang.*;
import java.io.File;
import java.util.List;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLClassLoader;

public class JavaFileManager extends FileManager
{
  public static boolean isMainClass(File f,String name)
  {

    if(f == null)
    {
      return false;
    }
    try
    {
      URL url = f.toURI().toURL();
      URL[] urls = new URL[]{url};
      ClassLoader cl = new URLClassLoader(urls);
      Class cls = cl.loadClass(name);
      //cl.close();
      System.out.println("Class found:" + cls.getName());
      System.out.println("Getting method:" + cls.getMethod("main",String[].class));
      cls.getMethod("main",String[].class);
      return true;
    }
    catch(ClassNotFoundException e)
    {
      System.out.println("Class not found.");
      return false;
    }
    catch(MalformedURLException e)
    {
      System.out.println("Malformed URL");
      return false;
    }
    catch(NoSuchMethodException e)
    {
      System.out.println("No main method");
      return false;
    }
  }

  public static void runClass(String name)
  {

  }
}
