import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();

		while (n-- > 0) {
			String word = br.readLine();

			// 기준 길이보다 작으면 건너뛰기
			if (word.length() < length) {
				continue;
			}

			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		// 정렬
		List<String> list = map.entrySet().stream()
			.sorted((a, b) -> {
				// 1. 자주 나오는 횟수
				int flag = b.getValue() - a.getValue();

				if (flag != 0) {
					return flag;
				}

				// 길이가 같지 않다면 ? 2. 길이 : 3. 알파벳 사전
				return b.getKey().length() - a.getKey().length() != 0
					? b.getKey().length() - a.getKey().length()
					: a.getKey().compareTo(b.getKey());
			})
			.map(e -> e.getKey())
			.collect(Collectors.toList());

		for (String word : list) {
			bw.write(word + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}