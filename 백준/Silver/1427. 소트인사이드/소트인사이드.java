import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = Arrays.stream(br.readLine().split(""))
			.mapToInt(Integer::parseInt)
			.toArray();

		Arrays.sort(arr);

		for (int i = arr.length - 1; i >= 0; i--) {
			bw.write(String.valueOf(arr[i]));
		}

		bw.flush();

		br.close();
		bw.close();
	}
}