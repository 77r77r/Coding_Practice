import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String word = br.readLine();

		for (int i = 'a'; i <= 'z'; i++) {
			int check = word.indexOf(i);
			bw.write(check + " ");
		}
		
		bw.close();
	}
}