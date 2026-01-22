import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		String word = br.readLine();
		int i = Integer.parseInt(br.readLine());

		wr.write(word.substring(i - 1, i));
		wr.close();
	}
}