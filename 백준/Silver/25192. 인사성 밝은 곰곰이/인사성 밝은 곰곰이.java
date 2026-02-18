import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();
		int count = 0;

		while (n-- > 0) {
			String input = br.readLine();

			if (input.equals("ENTER")) {
				// 신규 입장시 초기화
				set.clear();
			} else {
				// ENTER 이후 채팅 입력 여부 확인
				if (!set.contains(input)) {
					set.add(input);
					count++;
				}
			}
		}

		bw.write(String.valueOf(count));

		bw.flush();
		br.close();
		bw.close();
	}
}