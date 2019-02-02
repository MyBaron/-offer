package JianzhiOffer66;

public class No_9 {


    /**
     *
     * 题目：
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
     * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
     * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
     * */


    /**
     * 思路：
     * 1. 回溯法
     * 回溯流程：
     * 1. 找到一个字符匹配，就顺着这个字符附近寻找继续下一个字符
     * 2. 如果这个字符上，下，左，右都没有匹配的，那么就退回上一格去找
     * 注意的点：
     * 1. 入口是随意的，意思是需要遍历完整个数组，每个符合的入口都需要进去，知道找到匹配的路径才停止
     * 2. 需要考虑字符边界
     * 3. 是一个矩阵，也就是有行和列
     *
     * */
    //标识每个位置是否已使用
    private boolean[] has;
    //匹配字符长度
    private int length;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //遍历整个二维数组
        has = new boolean[matrix.length];
        for (int row = 0;row<rows;row++) {
            for (int col = 0;col<cols;col++) {
                //比对入口
                length = 0;
                if (hasPathCode(matrix,rows,cols,row,col,str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCode(char[] matrix,int rows, int cols,int row,int col, char[] str) {
        // 判断不越界
        // 判断当前位置的字符是否符合
        if (row >= 0 && col >= 0 && row < rows && col < cols
                && length < str.length
                && matrix[row * cols + col] == str[length]
                && !has[row * cols + col]) {
            boolean haspath;
            length++;
            //标记当前位置已被访问
            has[row * cols + col] = true;
            //上下左右四个位置
            haspath = (hasPathCode(matrix, rows, cols, row - 1, col, str)
                    || hasPathCode(matrix, rows, cols, row + 1, col, str)
                    || hasPathCode(matrix, rows, cols, row, col - 1, str)
                    || hasPathCode(matrix, rows, cols, row, col + 1, str)
            );
            //找到路劲
            if (length == str.length) {
                return true;
            }
            //回退一次
            if (!haspath) {
                has[row * cols + col] = false;
                length--;
            }

        }

        return false;

    }

    public static void main(String[] args) {
        No_9 n = new No_9();
        //"ABCESFCSADEE",3,4,"SEE"
        char[] matrix = new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] matrix1 = new char[]{'A','B','C','E','S','F','C','S','A','D','E','E'};
        char[] str = new char[]{'b', 'c', 'c', 'e', 'd'};
        //abcb
        char[] str1 = new char[]{'a', 'b', 'c', 'd'};
        char[] str2= new char[]{'S', 'E', 'E'};
        System.out.println(n.hasPath(matrix1, 3, 4, str2));
    }
}
