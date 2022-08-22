import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.replaceAll("apa", "a"); // s문자열에 있는 모든 apa를 a로 변경. 리턴값을 s 문자열에 저장
		s = s.replaceAll("epe", "e"); // 변경된 s문자열에 있는 모든 epe를 e로 변경. 리턴값을 s 문자열에 저장
		s = s.replaceAll("ipi", "i"); // 변경된 s문자열에 있는 모든 ipi를 i로 변경. 리턴값을 s 문자열에 저장
		s = s.replaceAll("opo", "o"); // 변경된 s문자열에 있는 모든 opo를 o로 변경. 리턴값을 s 문자열에 저장
		s = s.replaceAll("upu", "u"); // 변경된 s문자열에 있는 모든 upu를 u로 변경. 리턴값을 s 문자열에 저장

		System.out.println(s);
	}
}
