# EV_Mapreduce

start Hadoop services:
  start-dfs.sh
  start-yarn.sh

Upload to HDFS:
  hdfs dfs -mkdir -p /user/hdoop/input
  hdfs dfs -put /home/hdoop/EV_Population_Data.csv /user/hdoop/input/

Compile and package:
  javac -classpath $(hadoop classpath) -d . CountyCountMapper.java CountyCountReducer.java CountyCountDriver.java
  jar -cvf countycount.jar *.class

Move JAR to home directory if needed:
  mv countycount.jar ~/
Running the MapReduce Job
  hadoop jar countycount.jar CountyCountDriver /user/hdoop/input/EV_Population_Data.csv /user/hdoop/output/ev_count_by_county
Viewing the Output
  hdfs dfs -cat /user/hdoop/output/ev_count_by_county/part-*



