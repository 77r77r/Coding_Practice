import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int cnt = Integer.parseInt(br.readLine());

		String[] line = br.readLine().split(" ");
		String find = br.readLine();

		long find_size = Arrays.stream(line)
			.filter(a -> a.equals(find))
			.count();

		System.out.println(find_size);
	}
}