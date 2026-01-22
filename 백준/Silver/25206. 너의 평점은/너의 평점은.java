import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		double totSubject = 0;    // 전공 과목별 합
		double totScore = 0;

		for (int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine());

			String subject = st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();

			if (grade.equals("P")) {
				continue;
			}

			totSubject += getScoreSubject(grade, score);
			totScore += score;
		}
		bw.write(totSubject / totScore + "");
		bw.close();
	}

	public static double getScoreSubject(String grade, double score) {
		double avg = 0.0;

		switch (grade) {
			case "A+":
				avg = 4.5;
				break;
			case "A0":
				avg = 4.0;
				break;
			case "B+":
				avg = 3.5;
				break;
			case "B0":
				avg = 3.0;
				break;
			case "C+":
				avg = 2.5;
				break;
			case "C0":
				avg = 2.0;
				break;
			case "D+":
				avg = 1.5;
				break;
			case "D0":
				avg = 1.0;
				break;
			default:
				avg = 0.0;
		}

		return (avg * score);
	}
}