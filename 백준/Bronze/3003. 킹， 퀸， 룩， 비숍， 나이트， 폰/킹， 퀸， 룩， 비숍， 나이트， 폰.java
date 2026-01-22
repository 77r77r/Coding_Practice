import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		// A + x = 1
		// x = 1 -A
		bw.write((1 - Integer.parseInt(st.nextToken())) + " ");
		bw.write((1 - Integer.parseInt(st.nextToken())) + " ");
		bw.write((2 - Integer.parseInt(st.nextToken())) + " ");
		bw.write((2 - Integer.parseInt(st.nextToken())) + " ");
		bw.write((2 - Integer.parseInt(st.nextToken())) + " ");
		bw.write((8 - Integer.parseInt(st.nextToken())) + "");

		bw.close();
	}
}