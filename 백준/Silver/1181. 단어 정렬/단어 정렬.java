import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		String[] words = new String[size];
		int cnt = 0;

		for (int i = 0; i < size; i++) {
			String word = br.readLine();

			if (!Arrays.stream(words).anyMatch(w -> word.equals(w))) {
				words[cnt++] = word;
			}
		}

		Arrays.sort(words, (a, b) -> {
			if (a == null && b == null) {
				return 0;
			}

			if (a == null) {
				return 1;
			}

			if (b == null) {
				return -1;
			}

			if (a.length() != b.length()) {
				return a.length() - b.length();
			}
			return a.compareTo(b);
		});

		for (String word : words) {
			if (word != null) {
				bw.write(word + "\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}