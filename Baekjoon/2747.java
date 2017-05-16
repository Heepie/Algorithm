import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int cnt = sc.nextInt();
                System.out.println(Fibo(cnt));
        }
        
        static int Fibo (int i) {
                switch(i) {
                case 0:
                        return 0;
                case 1:
                        return 1;
                default:
                         return Fibo(i-1) + Fibo(i-2);       
                }
        }
}
