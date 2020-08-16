import java.util.Arrays;

public class Day2_plusOne {
//    day2
//    数组+1
//    https://leetcode-cn.com/problems/plus-one/
    public int[] plusOne(int[] digits) {
        int j = 0;
        if (digits[digits.length - 1] + 1 == 10) {
            digits[digits.length - 1] = 0;
            j = 1;
        } else {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            j = 0;
        }
        for (int i = digits.length - 2; i >= 0; i--) {
            if (j == 1) {
                if (digits[i] + 1 == 10) {
                    digits[i] = 0;
                    j = 1;
                } else {
                    digits[i] = digits[i] + 1;
                    j = 0;
                }
            }
        }
        if (j == 0) {
            return digits;
        } else {
            int[] arr = Arrays.copyOf(digits, digits.length + 1);
            //循环将数字后移
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            //将指定数字放到指定下标上
            arr[0] = 1;
            return arr;
        }

    }

    public int[] plusOne2(int[] digits) {
        int j = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 == 10) {
                digits[i] = 0;
                j = 1;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String args[]) {
        int data[] = new int[3];
        data[0] = 1;
        data[1] = 8;
        data[2] = 8;
        int data1[] = new Day2_plusOne().plusOne(data);
        System.out.println(data1[2]);
    }
}
