import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int have = Integer.parseInt(st.nextToken());
		int problem = Integer.parseInt(st.nextToken());

		Map<Integer, String> pokemon = new HashMap<>();
		Map<String, String> nameMap = new HashMap<>();

		for (int i = 0; i < have; i++) {
			String name = br.readLine();
			pokemon.put(i + 1, name);
			nameMap.put(name, String.valueOf(i + 1));
		}

		for (int i = 0; i < problem; i++) {
			String input = br.readLine();
			char c = input.charAt(0);

			if ('A' <= c && c <= 'Z') {
				bw.write(nameMap.get(input) + "\n");
			} else {
				bw.write(pokemon.get(Integer.parseInt(input)) + "\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}