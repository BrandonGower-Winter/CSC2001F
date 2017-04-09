#!bin/bash

for i in {1..20};
  do
      /usr/bin/time -f %U'\t'%S java -cp bin/:resources/ SearchIt &>> resources/TimeBSTRecordsEnd
  done
