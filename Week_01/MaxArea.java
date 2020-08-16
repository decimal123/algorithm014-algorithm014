public class MaxArea {
    //盛最多水的容器
    //https://leetcode-cn.com/problems/container-with-most-water/
    public int maxArea1(int[] height) {
        int count = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j < height.length; j++) {
                if ((height[j] - height[i]) > 0 && height[i] * (j - i) > count) {
                    count = height[i] * (j - i);
                } else if ((height[j] - height[i]) < 0 && height[j] * (j - i) > count) {
                    count = height[j] * (j - i);
                }
            }
        }
        return count;
    }

    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }

    public static void main(String args[]) {

        int data[] = new int[9];
        data[0] = 1;
        data[1] = 8;
        data[2] = 6;
        data[3] = 2;
        data[4] = 5;
        data[5] = 4;
        data[6] = 8;
        data[7] = 3;
        data[8] = 7;

        System.out.println(new MaxArea().maxArea2(data));

    }
}
