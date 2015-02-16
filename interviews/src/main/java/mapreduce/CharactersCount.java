package mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;

/**
 * Characters count using map reduce.
 */
public class CharactersCount extends Configured implements Tool {

	@Override
	public int run(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.println("Usage: CharactersCount <input path> <output path>");
			System.exit(-1);
		}

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, getClass().getCanonicalName());

		job.setMapperClass(CharactersCountMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(NullWritable.class);

		job.setReducerClass(CharactersCountReducer.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		return job.waitForCompletion(true) ? 0 : 1;
	}

	public static void main(String[] args) throws Exception {
		CharactersCount cc = new CharactersCount();
		cc.run(args);
	}

	private static class CharactersCountMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

		private final Text character = new Text();

		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();

			for (char c : line.toCharArray()) {
				character.set(String.valueOf(c));
				context.write(character, NullWritable.get());
			}
		}
	}

	private static class CharactersCountReducer extends Reducer<Text, NullWritable, Text, LongWritable> {

		@Override
		protected void reduce(Text key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
			long sum = sum(values);
			context.write(key, new LongWritable(sum));
		}

		private long sum(Iterable<NullWritable> elements) {
			long sum = 0;

			if (elements != null) {
				for (@SuppressWarnings("unused") NullWritable e : elements) {
					sum++;
				}
			}

			return sum;
		}
	}
}