import java.util.*;
import java.io.*;


public class Main
{   
    static boolean[] is0 = {true,true,true,true,true,true,false};
    static boolean[] is1 = {false,true,true,false,false,false,false};
    static boolean[] is2 = {true,true,false,true,true,false,true};
    static boolean[] is3 = {true,true,true,true,false,false,true};
    static boolean[] is4 = {false,true,true,false,false,true,true};
    static boolean[] is5 = {true,false,true,true,false,true,true};
    static boolean[] is6 = {true,false,true,true,true,true,true};
    static boolean[] is7 = {true,true,true,false,false,true,false};
    static boolean[] is8 = {true,true,true,true,true,true,true};
    static boolean[] is9 = {true,true,true,true,false,true,true};
    static boolean[] isnull = {false,false,false,false,false,false,false};

    static boolean[][] pre ;
    static int answer =0;
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++){
            answer =0;
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            pre = new boolean[5][7];

            int index = 4;
            while(!(A/10==0 && A%10==0)){
                int temp = A%10;
                switch(temp){
                    case 0: setpre(index, is0); break;
                    case 1: setpre(index,is1);break;
                    case 2: setpre(index,is2);break;
                    case 3: setpre(index,is3);break;
                    case 4: setpre(index,is4);break;
                    case 5: setpre(index,is5);break;
                    case 6: setpre(index,is6);break;
                    case 7: setpre(index,is7);break;
                    case 8: setpre(index,is8);break;
                    case 9: setpre(index,is9);break;
                }
                A/=10;
                index--;
            }

            for(int i=4; i>=0; i--){
                int temp = B%10;
                if(B/10==0&&temp==0){
                    convertpre(i, isnull);
                    continue;
                }
                switch(temp){
                    case 0: convertpre(i,is0);break;
                    case 1: convertpre(i,is1);break;
                    case 2: convertpre(i,is2);break;
                    case 3: convertpre(i,is3);break;
                    case 4: convertpre(i,is4);break;
                    case 5: convertpre(i,is5);break;
                    case 6: convertpre(i,is6);break;
                    case 7: convertpre(i,is7);break;
                    case 8: convertpre(i,is8);break;
                    case 9: convertpre(i,is9);break;
                }

                B/=10;
            }
            
            System.out.println(answer);

        }
    }

    static void convertpre(int n, boolean[] isnum){
        for(int i=0; i<7; i++){
            if(pre[n][i]!=isnum[i])answer++;
        }
    }

    static void setpre(int n, boolean[] isnum){
        for(int i=0; i<7; i++){
            pre[n][i] = isnum[i];
        }
    }
}
