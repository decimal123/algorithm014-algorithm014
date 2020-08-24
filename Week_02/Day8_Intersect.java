import java.util.*;

public class Day8_Solution {
    // https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
    // 350. 两个数组的交集 II
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int num : nums2) {
            int count = hashmap.getOrDefault(num, 0) + 1;
            hashmap.put(num, count);
        }
        List<Integer> list = new ArrayList();
        for (int num : nums1) {
            if (hashmap.containsKey(num)) {
                if (hashmap.get(num) > 0) {
                    list.add(num);
                    hashmap.put(num, hashmap.get(num) - 1);
                }
            }
        }
        int[] ints = list.stream().mapToInt(Integer::valueOf).toArray();
        return ints;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String args[]) {
        int data1[] = new int[4];
        data1[0] = 1;
        data1[1] = 2;
        data1[2] = 2;
        data1[3] = 1;
        int data2[] = new int[2];
        data2[0] = 1;
        data2[1] = 2;

        int data[] = new Day8_Solution().intersect2(data1,data2);
        System.out.println(data[2]);
    }
}
