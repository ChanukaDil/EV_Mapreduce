

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class CountyCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private boolean headerSkipped = false;

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (!headerSkipped) {
            headerSkipped = true;
            return;
        }

        String[] fields = value.toString().split(",");
        if (fields.length > 1) {
            String county = fields[1].trim();
            if (!county.isEmpty() && !county.equalsIgnoreCase("NA")) {
                context.write(new Text(county), new IntWritable(1));
            }
        }
    }
}
