import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());

		List<Integer> cardList = new LinkedList<>();

		for (int i = 1; i <= size; i++) {
			cardList.add(i);
		}

		if (cardList.size() > 1) {
			while (true) {
				cardList.remove(0);

				if (cardList.size() == 1) {
					break;
				}

				int temp = cardList.remove(0);
				cardList.add(temp);
			}
		}

		bw.write(String.valueOf(cardList.get(0)));

		bw.flush();
		br.close();
		bw.close();
	}
}