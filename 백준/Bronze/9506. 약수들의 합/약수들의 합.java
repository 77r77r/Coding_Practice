import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			int num = Integer.parseInt(br.readLine());
			int divisorSum = 1;

			if (num == -1) {
				break;
			}

			bw.write(String.valueOf(num));

			List<Integer> divisorList = new ArrayList<>();
			divisorList.add(1);

			for (int i = 2; i * i <= num; i++) {
				if (num % i == 0) {
					divisorList.add(i);
					divisorList.add(num / i);

					divisorSum += i + (num / i);
				}
			}

			if (num == divisorSum) {
				bw.write(" = ");
				Collections.sort(divisorList);

				for (int i = 0; i < divisorList.size(); i++) {
					bw.write(String.valueOf(divisorList.get(i)));

					if (i < divisorList.size() - 1)
						bw.write(" + ");
				}
				bw.write("\n");
			} else {
				bw.write(" is NOT perfect.\n");
			}
		}

		br.close();
		bw.close();
	}
}