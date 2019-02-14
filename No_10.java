package JianzhiOffer66;

public class No_10 {

    /*
    * 题目：
    * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
    * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
    * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
    * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
    *
    * */


    /**
     * 思路：
     * 1. 从0.0开始
     * 2. 回溯法：4条路，上下左右，无非就是+1
     * 3. 终止条件是 加起来不能大于k
     * 4. 走过的位置不能再次进入
     */
    private boolean[][] tabs;

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 1) {
            return 0;
        }
        tabs = new boolean[rows][cols];
        return moving(threshold,rows,0,cols,0);

    }

    private int moving(int threshold,int rows,int row,int cols,int col) {
        //判断条件
        // 1. 未超出格子大小
        // 2. 加起来不大于k
        if (row >= 0 && col >= 0 && row < rows && col < cols && judge(row, col, threshold)&&!tabs[row][col]) {
            tabs[row][col] = true;
            //进行回溯
                     //上
            return 1 + moving(threshold, rows, row - 1, cols, col)
                    //左
                    + moving(threshold, rows, row, cols, col - 1)
                    //下
                    + moving(threshold, rows, row + 1, cols, col)
                    //右
                    + moving(threshold, rows, row, cols, col + 1);

        }
        return 0;
    }

    private boolean judge(int row,int col,int threshold) {
        //分离row的每一位数
        int reRow = row;
        int numberRow;
        int countRow = 0;
        do {
            numberRow = reRow % 10;
            reRow = reRow / 10;
            countRow += numberRow;
        } while (reRow != 0);


        //分离col的每一位数
        int reCol = col;
        int numberCol;
        do {
            numberCol = reCol % 10;
            reCol = reCol / 10;
            countRow += numberCol;
        } while (reCol != 0);
        return countRow <= threshold;
    }


    public static void main(String[] args) {
        No_10 n = new No_10();
        System.out.println(n.movingCount(5, 10, 10));
    }


}
