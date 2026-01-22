import java.io.*;
import java.util.*;

// 1 2 3
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 같은 알파벳이면 무조건 연속해서 나타나야함
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			boolean groupWord = true;
			String word = br.readLine();

			String words[] = word.split("");

			for (int c = 0; c < word.length(); c++) {
				int start = word.indexOf(words[c]);
				int end = word.lastIndexOf(words[c]);

				if (start != end) {
					String temp = word.substring(start, end + 1);

					Set<String> set = new HashSet<>();

					for (String s : temp.split("")) {
						set.add(s);
					}

					if (set.size() != 1) {
						groupWord = false;
						break;
					}
				}
			}

			if (groupWord) {
				cnt++;
			}
		}
		bw.write(cnt + "");
		bw.close();
	}
}