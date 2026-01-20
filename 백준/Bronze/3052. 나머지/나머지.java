import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st =  new StringTokenizer(br.readLine());

		int[] arrs = new int[10];

		for (int i = 0; i < 10; i++) {
			arrs[i] = Integer.parseInt(br.readLine()) % 42;
		}

		int[] narrs = Arrays.stream(arrs).sorted().toArray();
		int cnt = 1;

		// System.out.println("narrs = " + Arrays.toString(narrs));

		for (int i = 1; i < 10; i++) {
			if (narrs[i - 1] != narrs[i]) {
				cnt++;
			}
		}
		wr.write(Integer.toString(cnt));
		wr.close();
	}
}