import java.io.*;
import java.util.*;

class Main {
	static int[] numbers;
	static int[] operators = new int[4];
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());

		// 숫자 입력
		st = new StringTokenizer(br.readLine());
		numbers = new int[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		// 연산자 입력 (+, -, *, /)
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

		func(numbers[0], 1);

		bw.write(max + "\n" + min);
		bw.flush();

		br.close();
		bw.close();
	}

	static void func(int num1, int depth) {
		// 종료 조건 : 계산이 끝나면
		if (depth >= numbers.length) {
			max = Math.max(num1, max);
			min = Math.min(num1, min);

			return;
		}

		/**
		 * 1. 계산할 수를 꺼낸다.
		 * 2. 각 연산자를 대입한다.
		 * 3. 계산해서 최대, 최솟 값을 비교한다.
		 */

		int num2 = numbers[depth];

		// 연산자를 처음 꺼내서 계산하고, 그 다음 꺼 꺼내서 계산하고...
		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				// 해당 연산자가 있으면 계산
				operators[i]--;
				int result = calculation(num1, num2, i);
				func(result, depth + 1);
				operators[i]++;
			}
		}
	}

	static int calculation(int num1, int num2, int oper) {
		// num1, num2 음수 변환

		switch (oper) {
			case 0:    // +
				return num1 + num2;
			case 1:    // -
				return num1 - num2;
			case 2:    // *
				return num1 * num2;
			default: // /
				int result = num1 / num2;

				if (num1 < 0 && num2 > 0) {
					num1 = Math.abs(num1);
					result = (num1 / num2) * -1;
				}

				return result;
		}
	}
}