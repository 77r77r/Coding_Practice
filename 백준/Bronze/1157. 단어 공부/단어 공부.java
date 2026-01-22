import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String word = br.readLine().toUpperCase();
		String[] words = word.split("");

		Map<String, Integer> mapWord = new LinkedHashMap<>();

		for (String w : words) {
			int cnt = mapWord.getOrDefault(w, 0) + 1;
			mapWord.put(w, cnt);
		}

		int max = -1;
		String result = "";
		boolean dupl = false;

		for (String key : mapWord.keySet()) {
			int cnt = mapWord.get(key);

			if (cnt == max) {
				dupl = true;
			}

			if (cnt > max) {
				max = cnt;
				result = key;
				dupl = false;
			}
		}
		
		bw.write(dupl ? "?" : result);
		bw.close();
	}
}