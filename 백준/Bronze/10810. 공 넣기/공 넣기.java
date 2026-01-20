import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st =  new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] buckets = new int[N];
		Arrays.fill(buckets, 0);

		for (int x = 0; x < M; x++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

			int i = input[0] - 1;
			int j = input[1] - 1;
			int k = input[2];

			// i ~ J 위치에 k번 공 넣기
			for (int y = i; y <= j; y++) {
				buckets[y] = k;
			}
		}

		for (int bucket : buckets) {
			wr.write(Integer.toString(bucket) + " ");
		}
		wr.close();
	}
}