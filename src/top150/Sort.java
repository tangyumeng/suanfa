package top150;

public class Sort {

//    https://mp.weixin.qq.com/s/7hKcwiJlo-VKO3K9V9WY7w
    public void maopaosort(int[] a) {
        for (int i =a.length - 1; i>=0 ;i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public void testMaopao() {

        int []nums = new int[] { 100, 2, 8, 6, 11, 89,3, 85,10, 32 };
        maopaosort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println("--------2");
    }

    public void quicksort(int []a, int left, int right) {
        int low = left;
        int high = right;
        if (low >high) {
            return;
        }
        int k=a[low];//额外空间k，取最左侧的一个作为衡量，最后要求左侧都比它小，右侧都比它大。
        //这一轮要求把左侧小于a[low],右侧大于a[low]。
        while(low<high) {
            //右侧找到第一个小于k的停止
            while(low<high&&a[high]>=k){
                high--;
            }
            //这样就找到第一个比它小的了
            a[low]=a[high];//放到low位置
            while(low<high&&a[low]<=k)//在low往右找到第一个大于k的，放到右侧a[high]位置
            {
                low++;
            }
            a[high]=a[low];
        }
        a[low]=k;//赋值然后左右递归分治求之
        quicksort(a, left, low-1);
        quicksort(a, low+1, right);
    }

    public static void main(String[] args) {
        Sort s = new Sort();
        s.testMaopao();
    }
}
