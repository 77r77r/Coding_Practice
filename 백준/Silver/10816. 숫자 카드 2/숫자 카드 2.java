import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int input = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < input; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		input = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < input; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (map.containsKey(num)) {
				bw.write(map.get(num) + " ");
			} else {
				bw.write("0 ");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}