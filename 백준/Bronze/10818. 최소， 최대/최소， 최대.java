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
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		String[] arrs = br.readLine().split(" ");

		int min = Integer.parseInt(arrs[0]);
		int max = Integer.parseInt(arrs[0]);

		for(String arr : arrs) {
			int temp = Integer.parseInt(arr);

			if (temp < min) {
				min = temp;
			}

			if (temp > max) {
				max = temp;
			}
		}
		wr.write(min +" " + max);
		wr.close();
	}
}