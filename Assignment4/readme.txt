#################################README#################################
Part Two of Assignment 4 allows a user to:
  Specify ambulance  and hospital capacity
  Give both hospitals and Ambulances(Ambos) a company tage eg: MEDICLINIC
  Give Victims Names and a life expectency value
  Allows a user to give starting points to Ambulances different to that of their hospitals

  Use: Simple type make in the Assignment 4 directory to build classes
       Type runTwo in the Assignment 4 directory to execute  SimulatorTwo
       No Javadocs were made.

  Rules:
  Two companies can't share ambuances or hospitals.
  A hospital can only ever go over capacity when an abulance brings them passengers that causes them to go over capacity.
    EG: A Ambulance brings two victims to a hopsital with a capacity of 1. The hospital accepts both but is now over capacity.
  A code black is called when there are no available hospitals or no ambulances to take passengers to hospitals.
  After each ambulance arrives the distance value travelled is treated as a time value and is deducted from the life expectency of
    the victims that have not been rescued. Should a victims life expectency go below 0 they are treated as dead.
  Victims are order specific meaning victims defined first get help first.

  Format:
  "Syntax used is the same as that used in the Assignment 4 document."

  <number of nodes><new line>
  {<source node number> {<destination node number><weight>}<new line>}
  <number of hospitals><new line>
  {<hospital node number> <capacity> <clinic name><new line>}
  <number of ambulances><new line>
  {<ambulance node number> <capacity> <clinic name><new line>}
  <number of victims><new line>
  {<victime node number> <life expectency> <name><new line>}
  0

  ###Note: '0' must be added to the end of every entry.

Examples:
Test 1 (Has Death):
5
0 1 98 2 5 3 16 4 16
1 0 13 2 1 3 3 4 40
2 0 71 1 51 3 43 4 30
3 0 20 1 94 4 46
4 0 1 1 10 2 28 3 15
2
2 4 MEDICLINIC
3 4 MEDICARE
2
2 2 MEDICLINIC
3 2 MEDICLINIC
4
0 500 CLYDE
1 500 HARRY
0 500 BONNIE
0 25 RED_SHIRT_1
0
Test 2(Has full hospitals):
5
0 1 98 2 5 3 16 4 16
1 0 13 2 1 3 3 4 40
2 0 71 1 51 3 43 4 30
3 0 20 1 94 4 46
4 0 1 1 10 2 28 3 15
1
2 1 MEDICLINIC
2
2 2 MEDICLINIC
3 2 MEDICLINIC
4
0 500 CLYDE
1 500 HARRY
0 500 BONNIE
0 500 RED_SHIRT_1
0
Test 3:
5
0 1 98 2 5 3 16 4 16
1 0 13 2 1 3 3 4 40
2 0 71 1 51 3 43 4 30
3 0 20 1 94 4 46
4 0 1 1 10 2 28 3 15
2
2 2 MEDICLINIC
3 5 MEDICARE
2
2 2 MEDICLINIC
3 2 MEDICLINIC
4
0 500 CLYDE
1 500 HARRY
0 500 BONNIE
0 500 RED_SHIRT_1
0
