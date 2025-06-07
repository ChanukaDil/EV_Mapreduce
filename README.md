# EV_Mapreduce

A Hadoop MapReduce project to calculate the number of Electric Vehicles (EVs) registered per county using Java.

---

## 🚀 Steps to Run the Project

### 1. Start Hadoop Services

```bash
start-dfs.sh
start-yarn.sh

Notes
Ensure the output directory does not already exist before running the job. Remove it if necessary:

bash
hdfs dfs -rm -r /user/hdoop/output/ev_count_by_county



