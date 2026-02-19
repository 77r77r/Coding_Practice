import java.io.*;
import java.util.*;

class Main {
	private static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			count = 0;
			String word = br.readLine();
			bw.write(isPalindrome(word) + " " + count + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static int isPalindrome(String s) {
		return recursion(s.toCharArray(), 0, s.length() - 1);
	}

	static int recursion(char[] s, int left, int right) {
		count++;
		if (left >= right) {
			return 1;
		} else if (s[left] != s[right]) {
			return 0;
		} else {
			return recursion(s, left + 1, right - 1);
		}
	}
}