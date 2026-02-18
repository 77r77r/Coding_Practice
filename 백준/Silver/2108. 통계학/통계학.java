import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

import com.sun.jdi.Value;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		double sum = 0;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());

			arr[i] = num;
			sum += num;
			// 빈도 확인
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		Arrays.sort(arr);

		// 최빈값 확인
		int maxCnt = Collections.max(map.values());
		List<Integer> list = new ArrayList<>();

		// 최빈값 중복 여부 확인
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() == maxCnt) {
				list.add(e.getKey());
			}
		}

		Collections.sort(list);

		long mean = Math.round(sum / n);
		int median = arr[arr.length / 2];
		int mode = list.size() > 1 ? list.get(1) : list.get(0);
		int range = arr[arr.length - 1] - arr[0];

		bw.write(mean + "\n" + median + "\n" + mode + "\n" + range);

		bw.flush();
		br.close();
		bw.close();
	}
}