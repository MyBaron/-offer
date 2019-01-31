package JianzhiOffer66;

public class No_7 {

    /**
     * 题目：
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
     */


    /*
    *
    * 思路：
    *   1. f(n)=f(n-1)+f(n-2)
    *   2. 从n=0开始计算，保存n-1和n-2两个值，计算出n
    * */
    public static int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int one = 0;
        int tow = 1;
        int sum = 0;
        for (int k=2;k<=n;k++) {
            sum = one + tow;
            one = tow;
            tow = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(9));
    }
}
