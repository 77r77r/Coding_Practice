import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String word = br.readLine();
		char[] words = word.toCharArray();
		int tot = 0;

		// 65 ~ 97 = 'A' 'Z'
		for (int i = 0; i < word.length(); i++) {
			int numPad = getNumPad(words[i]);
			tot += numPad + 1;
		}

		bw.write(Integer.toString(tot));
		bw.close();
	}

	public static int getNumPad(char word) {
		switch (word) {
			case 'A': case 'B': case 'C':
				return 2;
			case 'D': case 'E': case 'F':
				return 3;
			case 'G': case 'H': case 'I':
				return 4;
			case 'J': case 'K': case 'L':
				return 5;
			case 'M': case 'N': case 'O':
				return 6;
			case 'P': case 'Q': case 'R': case 'S':
				return 7;
			case 'T': case 'U': case 'V':
				return 8;
			case 'W': case 'X': case 'Y': case 'Z':
				return 9;
			default:
				return 0;
		}
	}
}