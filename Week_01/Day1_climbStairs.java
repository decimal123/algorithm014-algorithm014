public class Day1_climbStairs {
    //    day1
    //    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    //    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    //    https://leetcode-cn.com/problems/climbing-stairs/
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int m = 1; //n-2
        int l = 2; //n-1
        int a = 0;
        for (int i = 2; i < n; i++) {
            a = l;
            l = m + l;
            m = a;
            System.out.println("l=" + l + ";     m=" + m);

        }
        return l;
    }

    public static void main(String args[]) {

        System.out.println(new Day1_climbStairs().climbStairs(6));

    }
}
