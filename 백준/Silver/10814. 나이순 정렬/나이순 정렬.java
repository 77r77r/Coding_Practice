import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());
		// Map?
		String[][] members = new String[size][2];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());

			members[i][0] = st.nextToken();
			members[i][1] = st.nextToken();
		}

		sort(members, 0, size - 1);

		for (String[] m : members) {
			bw.write(m[0] + " " + m[1] + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static void sort(String[][] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = (left + right) / 2;

		sort(arr, left, mid);
		sort(arr, mid + 1, right);

		// 정렬
		String[][] temp = new String[right - left + 1][2];
		int i = left;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= right) {
			if (Integer.parseInt(arr[i][0]) <= Integer.parseInt(arr[j][0])) {
				temp[k][0] = arr[i][0];
				temp[k++][1] = arr[i++][1];
			} else {
				temp[k][0] = arr[j][0];
				temp[k++][1] = arr[j++][1];
			}
		}

		while (i <= mid) {
			temp[k][0] = arr[i][0];
			temp[k++][1] = arr[i++][1];
		}

		while (j <= right) {
			temp[k][0] = arr[j][0];
			temp[k++][1] = arr[j++][1];
		}

		for (int t = 0; t < temp.length; t++) {
			arr[left + t][0] = temp[t][0];
			arr[left + t][1] = temp[t][1];
		}
	}
}