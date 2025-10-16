package top150.arrayandstr;

public class Solution {
//    https://leetcode.cn/problems/merge-sorted-array/solutions/666608/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/?envType=study-plan-v2&envId=top-interview-150
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1, p2 = n - 1;
    int tail = m + n - 1;
    int cur;
    while (p1 >= 0 || p2 >= 0) {
        if (p1 == -1) {
            cur = nums2[p2--];
        } else if (p2 == -1) {
            cur = nums1[p1--];
        } else if (nums1[p1] > nums2[p2]) {
            cur = nums1[p1--];
        } else {
            cur = nums2[p2--];
        }
        nums1[tail--] = cur;
    }
}

//    public void merge2(int[] nums1, int m, int[] nums2, int n) {
//        int p1 = m -1, p2 = n - 1;
//        int tail = m + n - 1;
//        int cur;
//        while (p1 >= 0|| p2>= 0) {
//            if (p1 == -1) {
//                cur = nums2[p2];
//                p2 --;
//            } else if (p2 == -1) {
//                cur = nums1[p1];
//                p1--;
//            } else if (nums1[p1] > nums2[p2]) {
//                cur = nums1[p1];
//                p1 --;
//            } else {
//                cur = nums2[p2];
//                p2--;
//            }
//            nums1[tail--] = cur;
//        }
//    }

    private void printIntArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("index: " + i + " value is: " + arr[i]);
        }
    }

//    链接：https://leetcode.cn/problems/remove-element/solutions/730203/yi-chu-yuan-su-by-leetcode-solution-svxi/
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

//    https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1 , slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast-1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    private void testRemoveDuplicates() {
        int[] nums = new int[]{1, 2, 3, 3, 4, 4, 5, 10};
        System.out.println("remove duplicates result is: " + removeDuplicates(nums));
    }

//    https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int fast = 2, slow = 2;
        while (fast < n) {
            if (nums[fast] != nums[slow -2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    private void testRemoveDuplicates2() {
        int[] nums = new int[]{1, 2, 3,3, 3, 4, 4, 5, 10};
        System.out.println("testRemoveDuplicates2 result is: " + removeDuplicates2(nums));
    }

//    https://www.cnblogs.com/Enid/p/17763681.html
//    https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
    public int majorityElement(int[] nums) {
        int x = nums[0], count = 1;
        for (int i = 1; i < nums.length;i++) {
            if (x == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    x = nums[i];
                    count = 1;
                }
            }
        }
        return x;
    }

    public void testMajorityElement() {
        int[] nums = new int[]{1, 2, 3,3, 3, 3, 3, 5, 10};
        System.out.println("testMajorityElement result is: " + majorityElement(nums));
    }

//    买卖股票的最佳时机
//    https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solutions/136684/121-mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode-/?envType=study-plan-v2&envId=top-interview-150
    public int maxProfit(int []prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i< prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }

        return maxprofit;
    }

    // 多次买卖股票版本
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public void testMaxProfit2() {
        int [] prices = new int[]{7,1,5,3,6,7};
        System.out.println("多次买卖股票版本结果： " + maxProfit2(prices));
    }

//    https://leetcode.cn/problems/rotate-array/solutions/551039/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/?envType=study-plan-v2&envId=top-interview-150
//    向右旋转数组
    public void rotate1(int[]nums, int k) {
        int n = nums.length;
        int []newArr = new int[n];

        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

//    https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
//    跳跃游戏
    

    public static void main(String[] args) {
        Solution s  = new Solution();
        s.testRemoveDuplicates();
        s.testRemoveDuplicates2();
        s.testMajorityElement();
        s.testMaxProfit2();

//
//        int[] num1 = new int[8];
//        int[] num2 = new int[3];
//
//        num1[0] = 1;
//        num1[1] = 2;
//        num1[2] = 3;
//        num1[3] = 3;
//        num1[4] = 6;
//        num1[5] = 0;
//        num1[6] = 0;
//        num1[7] = 0;
//
//        num2[0] = 4;
//        num2[1] = 5;
//        num2[2] = 6;
//
//        s.merge(num1, 5, num2, 3);
//        s.printIntArray(num1);


    }
}
