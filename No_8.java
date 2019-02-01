package JianzhiOffer66;

public class No_8 {

    /**
     *
     * 题目：
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     *
     * */


    /*
    *  思路：
    *  1.非减排序，那就是递增或者相同元素的数组
    * 先考虑递增的数组：
    *   1. 递增是一个规律，也就是左边的数会比右边的数小
    *   2. 可以看成两个递增的子数组
    *   3. 只要找到两个子数组的分割位置，就知道哪个子数组小，而且最小值是什么
    *   4. 分割位置可以用二分查找
    *   5. 因为是最开始的若干个数移到后面，那就是开头是一个数组，最后面是另一个数组，接下来就是找分割位置
    *   6. 二分查找：先定义数组中间的分割位置，利用递增的关系，比较大小，
    *   7. 如果大于第一个数组，那属于第一个数组，这时候，第一个数组的界限就是这个分割位置
    *   8. 如果小于第一个数组，那么属于第二个数组，这时候，第二个数组的界限就是这个分割位置
    *   9. 接着再就行二分法，直到没有数进行划分，这就找到了分割位置
    *   10.这时候，比较第二数组的界限就是最小值
    *  然后考虑相同元素的
    *   1. 情况可能是部分递增和元素相同的数组，极端情况是所有元素相同
    *   2. 处理方式还是一样，利用二分查找法缩小范围
    *   3. 元素相同造成的影响是什么呢？ 二分法找到的中间值与两边比较是相等的，导致无法找到区域
    *   4. 如果遇到3这个种情况，就采用顺序比较的方法，找到最小值
    *
    * */

    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int mid ;
        int left = 0;
        int right = array.length - 1;
        mid = (left + right) / 2;
        while (mid < right && mid > left) {
            //处理相同元素的情况
            if (array[left] == array[mid] && array[mid] == array[right]) {
                return orderFind(array, left, right);
            }
            //比较mid是否大于left
            if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        return array[right];
    }

    //顺序查询
    private int orderFind(int [] array,int l,int r) {
        int min = array[l];
        for (int i=l; i<r;i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        No_8 n = new No_8();
        int[] a = new int[]{3, 4, 5, 1, 2};
        int[] a1 = new int[]{2, 2, 2, 2, 1};
        System.out.println(n.minNumberInRotateArray(a1));
    }
}
