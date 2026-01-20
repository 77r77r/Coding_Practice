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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arrs = new int[N];
		for (int i = 0; i < N; i++) {
			arrs[i] = i + 1;
		}

		String line = br.readLine();

		for (int z = 0; z < M; z ++) {
			st = new StringTokenizer(line);

			int i = Integer.parseInt(st.nextToken()) - 1;	// 1 (0)
			int j = Integer.parseInt(st.nextToken()) - 1;	// 4 (3)

			for (int x = 0; x < (j - i + 1)/2; x++) {
				int temp = arrs[i + x];
				arrs[i + x] = arrs[j - x];
				arrs[j - x] = temp;
			}

			line = br.readLine();

			if (line == null) {
				break;
			}
		}

		for (int arr : arrs) {
			wr.write(Integer.toString(arr) +" ");
		}
		wr.close();
	}
}