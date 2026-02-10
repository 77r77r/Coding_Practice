import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int commandCount = Integer.parseInt(br.readLine());
		int[] stack = new int[1000000];
		int point = -1;

		while (commandCount-- > 0) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int inputNum = 0;

			if (command == 1) {
				inputNum = Integer.parseInt(st.nextToken());
			}

			switch (command) {
				case 1:
					stack[++point] = inputNum;
					break;
				case 2:
					if (point != -1) {
						bw.write(stack[point--] + "\n");
					} else {
						bw.write("-1\n");
					}
					break;
				case 3:
					bw.write((point + 1) + "\n");
					break;
				case 4:
					if (point != -1) {
						bw.write("0\n");
					} else {
						bw.write("1\n");
					}
					break;
				case 5:
					if (point != -1) {
						bw.write(stack[point] + "\n");
					} else {
						bw.write("-1\n");
					}
					break;
				default:
					break;
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}