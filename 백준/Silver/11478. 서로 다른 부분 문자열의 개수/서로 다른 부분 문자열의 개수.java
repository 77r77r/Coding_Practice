import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String word = br.readLine();
		int len = word.length();

		Set<String> set = new HashSet<>();

		// 글자 갯수 만큼 반복
		for (int w = 1; w <= len; w++) {
			for (int i = 0; i < len - (w - 1); i++) {
				set.add(word.substring(i, i + w));
			}
		}

		bw.write(String.valueOf(set.size()));

		bw.flush();
		br.close();
		bw.close();
	}
}