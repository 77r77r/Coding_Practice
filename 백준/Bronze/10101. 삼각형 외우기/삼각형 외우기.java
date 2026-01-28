import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int angle1 = Integer.parseInt(br.readLine());
		int angle2 = Integer.parseInt(br.readLine());
		int angle3 = Integer.parseInt(br.readLine());

		int angleSum = angle1 + angle2 + angle3;

		if (angleSum != 180) {
			bw.write("Error");
		} else if (angle1 == angle2 && angle2 == angle3) {
			bw.write("Equilateral");
		} else if (angle1 == angle2 || angle2 == angle3 || angle1 == angle3) {
			bw.write("Isosceles");
		} else {
			bw.write("Scalene");
		}

		br.close();
		bw.close();
	}
}