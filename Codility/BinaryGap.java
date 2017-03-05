
class Solution {
    public int solution(int N) {
        int R, count=0, max=0;
        boolean start = false;
        while(N != 0) {
            R = N%2;
            N /= 2;
            
            if (start == true && R == 0)
                count++;
                
            if (R == 1) {
                start = true;
                max = (max > count) ? max:count;
                count = 0;
            }                
        }
        return max;        
    }
}
