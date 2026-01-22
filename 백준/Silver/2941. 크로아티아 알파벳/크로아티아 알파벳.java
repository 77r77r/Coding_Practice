import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

		String line = br.readLine();

		for (String h : alphabet) {
			while (line.contains(h)) {
				line = line.replace(h, "a");
			}
		}

		bw.write(line.length() + "");

		br.close();
		bw.close();
	}
}