import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int sizeA = Integer.parseInt(st.nextToken());
		int sizeB = Integer.parseInt(st.nextToken());

		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();

		// A
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < sizeA; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}

		// B
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < sizeB; i++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}

		int count = 0;
		// A-B
		count += (int)setA.stream()
			.filter(a -> !setB.contains(a))
			.count();

		// B-A
		count += (int)setB.stream()
			.filter(a -> !setA.contains(a))
			.count();

		bw.write(String.valueOf(count));

		bw.flush();
		br.close();
		bw.close();
	}
}