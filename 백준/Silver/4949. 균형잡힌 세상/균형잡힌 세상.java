import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = br.readLine();

		while (!Objects.equals(line, ".")) {
			char[] stack = new char[101];
			int point = -1;
			boolean check = true;

			for (char c : line.toCharArray()) {
				if (c == '(') {
					stack[++point] = c;
				} else if (c == ')') {
					if (point == -1 || stack[point] != '(') {
						check = false;
						break;
					} else {
						point--;
					}
				} else if (c == '[') {
					stack[++point] = c;
				} else if (c == ']') {
					if (point == -1 || stack[point] != '[') {
						check = false;
						break;
					} else {
						point--;
					}
				}
			}

			if (check && point == -1) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}

			line = br.readLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}
}