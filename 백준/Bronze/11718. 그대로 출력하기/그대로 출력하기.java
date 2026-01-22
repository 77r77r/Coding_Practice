import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line;

		while (true) {
			line = br.readLine();

			if (line == null) {
				break;
			}
			
			bw.write(line + "\n");
		}

		bw.close();
	}
}