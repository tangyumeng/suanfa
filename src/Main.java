import top150.type1.MergeTwoArray;
import top150.type1.RemoveElem;

public class Main {
    public static void main(String[] args) {
//        testMergeTwoArray();
//        removeElem();
        removeDuplicate2();
    }

    static void testMergeTwoArray() {
        int[] num1 = new int[7];
        num1[0] = 1;
        num1[1] = 9;
        num1[2] = 11;
        num1[3] = 50;
        int[] num2 = {2, 7, 100};

        MergeTwoArray mergeTwoArray = new MergeTwoArray();
        mergeTwoArray.merge(num1, 4, num2, num2.length);

        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i]);
        }

    }

    static void removeElem() {
        int[] nums = {1,1,3,9, 8,9,9};
        RemoveElem re = new RemoveElem();
        int i = re.removeElement2(nums, 9);
        System.out.println("result is: " + i);
    }

    static void removeDuplicate2() {
        int[] nums = {1,1,3,9,9,9};
        RemoveElem re = new RemoveElem();
        int i = re.removeDuplicates2(nums);
        System.out.println("result is: " + i);
    }
}