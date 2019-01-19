package JianzhiOffer66;

public class P03 {

    /**
     * 题目描述:将字符串的空格替换成%20
     *
     *
     *
     */


    /**
     * 方法一
     */
    public static String replaceSpace(StringBuffer str) {
        for(int i=0;i<str.length();i++) {
            if (str.charAt(i)==' ') {
                str.replace(i, i + 1, "%20");
            }
        }
        return str.toString();

    }

    /**
     * 方法二
     * 思路：
     * 1. 消耗时间的操作是数组的值的移位，如果移位能减少到一次，那么效率就会提高
     * 2. 先预计新的字符串空间大小，然后再组合字符串
     * 3. 已经知道新字符串需要的空间，只需要从后面开始移动，就可以了
     *
     */
    public static String replaceSpace0(StringBuffer str) {
        if (null == str || str.length() == 0) {
            return "";
        }

        int number = 0;
        //找到有多少个空格
        for(int i=0;i<str.length();i++) {
            if (str.charAt(i)==' ') {
                number++;
            }
        }
        int newLength = str.length() + (number * 2);
        int oldLength = str.length()-1;

        //为了减少创建的空间
        if (newLength > oldLength + 15) {
            str.setLength(newLength);
        }else {
            //todo 这里可以优化成 只需要开辟length个字符空间就好
            int length = number * 2;
            str.insert(oldLength+1, new char[length]);
        }

        //开始移动字符串,从后面开始移动
        for (int i=oldLength;i>=0;i--) {
            //需要用%20替换
            if (str.charAt(i) == ' ') {
//                str.replace(newLength-3,newLength, "%20");
//                newLength -= 3;
                str.setCharAt(--newLength,'0');
                str.setCharAt(--newLength,'2');
                str.setCharAt(--newLength,'%');
            }else {
                str.setCharAt(--newLength,str.charAt(i));
            }
        }
        return str.toString();
    }


        public static void main(String[] ages) {
//        String we_kkk_lo = replaceSpace0(new StringBuffer("wo ai ni ya "));
        String we_kkk_lo = replaceSpace0(new StringBuffer("   "));
        System.out.println(we_kkk_lo);
    }

}
