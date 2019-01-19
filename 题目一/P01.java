package JianzhiOffer66;

public class P01 {
//    题目描述
//    在一个二维数组中，每一行都按照从左到右递增的顺序排序，
//    每一列都按照从上到下递增的顺序排序。
//    请完成一个函数，输入这样的一个二维数组和一个整数，
//    判断数组中是否含有该整数。
//    [[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]

    public boolean Find(int target, int [][] array) {

        //要判定一个整数是否在数组
        //首先知道一行的长度
        int hang = array[0].length;
        int lie = array.length-1;
        int find=lie;

        if(hang<1||lie<0||target<array[0][0])
            return false;

        if(array[lie][hang-1]<target){
            return false;
        }

        //从最后一行往上遍历
        for(int i=0;i<=lie;i++) {
            //先判断行的第一个，如果第一个都大于目标，那么就可以直接向上一行查找；
            if (array[find][0] > target) {
                find--;

            }
            int k=0;
            for(k=0;k<hang;k++){
                if(array[find][k]>target){
                    k=hang;
                    break;
                }
                if(array[find][k]==target)
                {
                    return true;
                }

            }
            if(k==hang&&find>0){
                find--;
            }
        }
        return false;
    }


    /**
     * 思路二：每一次比较都是缩小范围
     * 1. 从左上开始筛选，每一对比都可以去掉一行或者一列
     * 2. 如果大于目标数，就去掉一列
     * 3. 如果小于目标数，就去掉一行
     */
    public boolean Find0(int target,int [][] array){
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        //获取行数和列数
        int hangCount = array.length-1;
        int lieCount = array[0].length-1;

        if (target < array[0][0] || target > array[hangCount][lieCount]) {
            return false;
        }

        for (int lie=0;lie<=lieCount;lie++) {
            for (int hang=hangCount;hang>=0;hang--) {
                int number = array[lie][hang];
                if (target > number) {
                    //减少一行
                    break;
                } else if (target < number) {
                    //减少一列
                    //优化点
                    hangCount--;
                }else {
                    return true;
                }

            }
        }
        return false;
    }


    /**
     * 思路三：采用while循环代替双for循环
     * 1. 从左上开始筛选，每一对比都可以去掉一行或者一列
     * 2. 如果大于目标数，就去掉一列
     * 3. 如果小于目标数，就去掉一行
     */
    public boolean Find1(int target,int [][] array){
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        //获取行数和列数
        int hangCount = array.length-1;
        int lieCount = array[0].length-1;

        if (target < array[0][0] || target > array[hangCount][lieCount]) {
            return false;
        }
        int lie = 0;
        int hang = hangCount;
        while (lie <= lieCount && hang > 0) {
            int number = array[lie][hang];
            if (target > number) {
                lie++;
            } else if (target < number) {
                hang--;
            } else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] ages) {
        //建立一个二维数组
        int[][] array=new int[5][5];
        int[][] a=new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        for(int i=0;i<5;i++) {
            //多少行
            for(int k=0;k<5;k++) {
                //行数加列
                /*
                * 0 1 2 3 4
                * 1 2 3 4 5
                * */
                array[i][k]=i+k;
                System.out.print(array[i][k]);
            }
            System.out.println();
        }
        P01 p01 = new P01();
        boolean b=p01.Find1(1,a);
        System.out.println(b);

    }
}
