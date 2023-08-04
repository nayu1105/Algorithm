import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] sum = new int[N];
        int temp = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            temp += Integer.parseInt(st.nextToken());
            sum[i] = temp;
        }

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            double sub = 0;
            if(A-2<0){
                sub = sum[B-1];
            }
            else{
                sub = sum[B-1]-sum[A-2];
            }

            sub = sub/(double)(B-A+1);

            System.out.printf("%.2f\n", Math.round((double)sub*100.0)/100.0);
        }
    }
}
