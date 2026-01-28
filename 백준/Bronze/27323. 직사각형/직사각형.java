import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int width = Integer.parseInt(br.readLine());
		int height = Integer.parseInt(br.readLine());

		bw.write(String.valueOf(width * height));

		br.close();
		bw.close();
	}
}