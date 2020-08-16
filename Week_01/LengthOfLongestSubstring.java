public class LengthOfLongestSubstring {
    //    字符串的最长无重复字母长度
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        // 窗口起始位置
        int start = 0;
        for (int cur = 1; cur < s.length(); cur++) {
            System.out.println("第1个for，cur = [" + cur + "]");
            // 拿到每个当前指针元素来从窗口起始位置遍历来判断是否已存在该元素
            for (int i = start; i < cur; i++) {
                System.out.println("第2个for，cur = [" + cur + "]，i=[" + i + "]");
                if (s.charAt(i) == s.charAt(cur)) {

                    // 存在截取长度
                    len = Math.max(len, cur - start);
                    // 窗口起始点变成出现重复第一个元素的后面
                    start = i + 1;
                    System.out.println("第2个for，if，s.charAt(i) = [" + s.charAt(i) + "]，len = [" + len + "]");
                    // 跳出检查
                    break;
                }
            }
        }
        // 最后比较最大长度和遍历完窗口的长度
        return Math.max(s.length() - start, len);
    }

    public static void main(String args[]) {


        new LengthOfLongestSubstring().lengthOfLongestSubstring("asaasdasd");

    }
}
