import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static String[] s, ss;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		
		s  = br.readLine().split("-");
		ss = s[0].split("\\+");
		for (int j = 0; j < ss.length; j++) {
			ans += Integer.parseInt(ss[j]);
		}
		// split된 앞부분만 더하기
		for (int i = 1; i < s.length; i++) {
			ss = s[i].split("\\+");
			for (int j = 0; j < ss.length; j++) {
				ans -= Integer.parseInt(ss[j]);
			}
		} // - 만난 순간 다 빼기
		
		
		System.out.println(ans);
	}
}
