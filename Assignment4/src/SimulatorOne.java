/*
Test 1:
5
0 1 98 2 5 3 16 4 16
1 0 13 2 47 3 3 4 40
2 0 71 1 51 3 43 4 30
3 0 20 1 94 4 46
4 0 1 1 10 2 28 3 15
2
2 3
2
0 1
*/
import java.util.*;

public class SimulatorOne
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    int nodeNum = Integer.parseInt(input.nextLine());
    String nodeData[] = new String[nodeNum];
    for(int i = 0; i < nodeNum; i++)
    {
      nodeData[i] = input.nextLine();
    }
    int numHosp = Integer.parseInt(input.nextLine());
    String hospData = input.nextLine();
    int numVictims = Integer.parseInt(input.nextLine());
    String vicData = input.nextLine();

    HospitalGraph graph = new HospitalGraph(nodeNum,nodeData,numHosp,hospData,numVictims,vicData);
    //System.out.println(graph.toString());
  }
}
