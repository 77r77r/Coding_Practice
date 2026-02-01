import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int target = Integer.parseInt(br.readLine());
		int count = 0;
		int num = 665;

		while (count != target) {
			num++;

			if (String.valueOf(num).indexOf("666") != -1) {
				count++;
			}
		}

		System.out.println(num);

		br.close();
	}
}