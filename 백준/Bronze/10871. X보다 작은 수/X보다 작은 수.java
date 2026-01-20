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
		int X = Integer.parseInt(st.nextToken());

		String[] arrs = br.readLine().split(" ");

		for(String arr : arrs) {
			if (Integer.parseInt(arr) < X) {
				wr.write(arr + " ");
			}
		}
		wr.close();
	}
}