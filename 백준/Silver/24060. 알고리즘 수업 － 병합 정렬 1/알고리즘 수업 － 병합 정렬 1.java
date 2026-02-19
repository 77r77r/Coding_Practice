import java.io.*;
import java.util.*;

class Main {
	private static int saveCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int size = Integer.parseInt(st.nextToken());
		int targetCount = Integer.parseInt(st.nextToken());
		int[] arr = new int[size];
		saveCount = 0;

		st = new StringTokenizer(br.readLine());

		// 배열 A에 값 할당
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		bw.write(String.valueOf(mergeSort(arr, 0, arr.length - 1, targetCount)));

		bw.flush();
		br.close();
		bw.close();
	}

	private static int mergeSort(int[] arr, int left, int right, int tCount) {
		int num = -1;

		if (left >= right) {
			return num;
		}

		int mid = (left + right) / 2;
		num = mergeSort(arr, left, mid, tCount);
		if (tCount == saveCount) {
			return num;
		}
		num = mergeSort(arr, mid + 1, right, tCount);
		if (tCount == saveCount) {
			return num;
		}
		num = merge(arr, left, mid, right, tCount);

		return num;
	}

	private static int merge(int[] arr, int start, int mid, int end, int tCount) {
		int[] temp = new int[end - start + 1];
		int left = start;
		int right = mid + 1;
		int idx = 0;

		int num = -1;

		while (left <= mid && right <= end) {
			temp[idx++] = arr[left] <= arr[right]
				? arr[left++]
				: arr[right++];

			saveCount++;

			if (checkCount(tCount)) {
				return temp[idx - 1];
			}
		}

		// 좌측 배열의 남은 값 처리
		while (left <= mid) {
			temp[idx++] = arr[left++];

			saveCount++;

			if (checkCount(tCount)) {
				return temp[idx - 1];
			}
		}

		// 우측 배열의 남은 값 처리
		while (right <= end) {
			temp[idx++] = arr[right++];

			saveCount++;

			if (checkCount(tCount)) {
				return temp[idx - 1];
			}
		}

		System.arraycopy(temp, 0, arr, start, temp.length);
		return -1;
	}

	private static boolean checkCount(int tCount) {
		if (tCount == saveCount) {
			return true;
		}
		return false;
	}
}