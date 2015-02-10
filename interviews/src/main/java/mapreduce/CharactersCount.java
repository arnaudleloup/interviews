package mapreduce;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Characters count using map reduce.
 */
public class CharactersCount {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		if (args.length != 2) {
			System.err.println("Usage: CharactersCount <input path> <output path>");
			System.exit(-1);
		}

		Job job = new Job();
		job.setJarByClass(CharactersCount.class);
		job.setJobName("CharactersCount");

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setMapperClass(CharactersCountMapper.class);
		job.setReducerClass(CharactersCountReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

	private static class CharactersCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();

			Map<Character, Integer> freq = new HashMap<Character, Integer>();
			for (char c : line.toCharArray()) {
				if (!freq.containsKey(c)) {
					freq.put(c, 0);
				}

				freq.put(c, freq.get(c) + 1);
			}

			for (Entry<Character, Integer> entry : freq.entrySet()) {
				char c = entry.getKey();
				int frequency = entry.getValue();
				context.write(new Text(String.valueOf(c)), new IntWritable(frequency));
			}
		}
	}

	private static class CharactersCountReducer extends Reducer<Text, IntWritable, Text, LongWritable> {

		@Override
		protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
			long sum = sum(values);
			context.write(key, new LongWritable(sum));
		}

		private long sum(Iterable<IntWritable> elements) {
			long sum = 0;

			if (elements != null) {
				for (IntWritable e : elements) {
					sum += e.get();
				}
			}

			return sum;
		}
	}
}