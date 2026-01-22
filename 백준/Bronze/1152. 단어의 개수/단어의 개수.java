import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String word = br.readLine().trim();

		if (word.length() != 0) {
			String[] words = word.split(" ");
			bw.write(Integer.toString(words.length));
		} else {
			bw.write("0");
		}

		bw.close();
	}
}