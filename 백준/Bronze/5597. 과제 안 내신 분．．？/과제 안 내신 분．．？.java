import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st =  new StringTokenizer(br.readLine());

		ArrayList<Integer> list = new ArrayList();

		for (int i = 1; i <= 30; i++) {
			list.add(i);
		}

		for (int i = 0; i < 28; i++) {
			int num = Integer.parseInt(br.readLine());
			list.remove(Integer.valueOf(num));
		}

		wr.write(list.get(0) + "\n" + list.get(1));
		wr.close();
	}
}