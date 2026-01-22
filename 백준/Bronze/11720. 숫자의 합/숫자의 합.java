import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = Integer.parseInt(br.readLine());
		String[] word = br.readLine().split("");

		int tot = 0;

		/*
		for (String s : word) {
			tot += Integer.parseInt(s);
		}
		*/

		for (int i = 0; i < cnt; i++) {
			tot += Integer.parseInt(word[i]);
		}

		bw.write(Integer.toString(tot));
		bw.close();
	}
}