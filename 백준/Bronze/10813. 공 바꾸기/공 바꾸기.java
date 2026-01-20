import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st =  new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Integer[] buckets = new Integer[N];

		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = i + 1;
		}
		// 1 2 3 4 5
		// 2 1 3 4 5
		// 2 1 4 3 5
		// 3 1 4 2 5
		// 3 1 4 2 5

		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int temp = buckets[x - 1];
			buckets[x - 1] = buckets[y - 1];
			buckets[y - 1] = temp;
		}

		for (int bucket: buckets){
			wr.write(bucket +  " ");
		}

		wr.close();
	}
}