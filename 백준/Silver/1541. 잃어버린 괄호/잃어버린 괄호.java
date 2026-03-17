import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] line = br.readLine().split("-");
		int value = 0;

		String[] temp = line[0].split("\\+");

		for (String t : temp) {
			value += Integer.parseInt(t);
		}

		if (line.length != 1) {
			for (int i = 1; i < line.length; i++) {
				temp = line[i].split("[+-]");

				for (String t : temp) {
					value -= Integer.parseInt(t);
				}
			}

		}
		bw.write(String.valueOf(value));

		bw.flush();
		br.close();
		bw.close();

	}
}