import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());

		int max = num;
		int cnt = 1;

		for (int i = 1; i < 9; i++) {
			num = Integer.parseInt(br.readLine());

			if (num > max) {
				max = num;
				cnt = i + 1;
			}
		}

		wr.write(max +"\n" + cnt);
		wr.close();
	}
}