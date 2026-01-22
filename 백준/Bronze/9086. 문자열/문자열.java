import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < cnt; i++) {
			String word = br.readLine();
			char start = word.charAt(0);
			char end = word.charAt(word.length() - 1);
			wr.write(start + "" + end + "\n");
		}
		wr.close();
	}
}