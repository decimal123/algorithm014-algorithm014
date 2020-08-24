public class Day9_MaxSlidingWindow {
    // https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
    // 剑指 Offer 59 - I. 滑动窗口的最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int maxid = 0;
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (i > 0 && maxid == i - 1 && nums[i + k - 1] > nums[maxid]) {
                res[i] = nums[i + k - 1];
                continue;
            }
            maxid = i;
            for (int j = i + 1; j < i + k; j++) {
                if (nums[maxid] < nums[j]) {
                    maxid = j;
                }
            }
            res[i] = nums[maxid];
        }
        return res;

    }

    public static void main(String args[]) {
        int data1[] = new int[3];
        data1[0] = 7;
        data1[1] = 3;
        data1[2] = 4;
//        data1[3] = -3;
//        data1[4] = 5;
//        data1[5] = 3;
//        data1[6] = 6;
//        data1[7] = 7;
        int data2[] = new Day9_MaxSlidingWindow().maxSlidingWindow(data1, 2);
        for (int i = 0; i < data2.length; i++) {
            System.out.println(data2[i]);
        }
    }
}