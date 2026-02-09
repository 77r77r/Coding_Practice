import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		int[] tree = new int[size];

		for (int i = 0; i < size; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}

		// 나무 사이의 거리
		int[] distance = new int[size - 1];

		for (int i = 0; i < size - 1; i++) {
			distance[i] = tree[i + 1] - tree[i];
		}

		// 각 거리의 최대 공약수
		// 1 3 7 13 -> 2 4 6
		int len = distance[0];

		for (int i = 1; i < distance.length; i++) {
			len = gcd(distance[i], len);
		}

		bw.write(((tree[size - 1] - tree[0]) / len) + 1 - tree.length + "\n");

		bw.flush();
		br.close();
		bw.close();
	}

	static int gcd(int num1, int num2) {
		while (num2 != 0) {
			int gcd = num1 % num2;
			num1 = num2;
			num2 = gcd;
		}

		return num1;
	}
}