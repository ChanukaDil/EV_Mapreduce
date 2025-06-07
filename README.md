# EV_Mapreduce

1. Start Hadoop Services
bash
start-dfs.sh
start-yarn.sh
2. Upload the Dataset to HDFS
bash
hdfs dfs -mkdir -p /user/hdoop/input
hdfs dfs -put /home/hdoop/EV_Population_Data.csv /user/hdoop/input/
3. Compile and Package the Java Code
Navigate to your project directory containing the Java files:

bash
cd ~/mapreduce_project
javac -classpath $(hadoop classpath) -d . CountyCountMapper.java CountyCountReducer.java CountyCountDriver.java
jar -cvf countycount.jar *.class
Move the JAR to your home directory if needed:

bash
mv countycount.jar ~/
4. Run the MapReduce Job
From your home directory, execute:

bash
hadoop jar countycount.jar CountyCountDriver /user/hdoop/input/EV_Population_Data.csv /user/hdoop/output/ev_count_by_county
5. View the Output
bash
hdfs dfs -cat /user/hdoop/output/ev_count_by_county/part-*
Notes
Ensure the output directory does not already exist before running the job. Remove it if necessary:

bash
hdfs dfs -rm -r /user/hdoop/output/ev_count_by_county



