import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String word = br.readLine();
		String[] words = word.split("");
		StringBuilder sb = new StringBuilder();

		for (String w : words) {
			sb.append(w);
		}
		sb.reverse();

		if (word.equals(sb.toString())) {
			bw.write("1");
		} else {
			bw.write("0");
		}

		bw.close();
	}
}