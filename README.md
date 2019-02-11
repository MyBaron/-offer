

## NO.1 
                              
### 题目 
> 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
  
### 思路

1. 从左上开始筛选，每一对比都可以去掉一行或者一 列
2. 如果大于目标数，就去掉一列
3. 如果小于目标数，就去掉一行


### 心得

1. 对数组的一定要有连续内存的概念
2. 如果对有规律排序的数，一定有规律可循
3. 一定要找出特殊条件，例如右上角，是一行中最大，一列最小



## NO.2

### 题目

> 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy

### 思路

1. 先预计新的字符串空间大小，然后再组合字符串
2. 已经知道新字符串需要的空间，只需要从后面开始移动，就可以了

### 心得

1. StringBuffer其实也是新建一个数组，并且初始化是16个字符，初始化有字符串，那么会预先多开辟16个字符的空间
2. 消耗时间的操作是数组的值的移位，如果移位能减少到一次，那么效率就会提高
3. 最重要是找出消耗时间的主要原因

## No.3

### 题目

> 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList（不改变原有的链表数据存储结构）


### 思路

> 思路一

1. 遍历链表，每个元素都从头部放入数组中
2. 缺点：每次都要移位，浪费时间
代码：
``` java
    public static ArrayList<Integer>  printListFromTailToHead(ListNode listNode) {
        ListNode l = listNode;
        ArrayList<Integer> list = new ArrayList();
        while (l != null) {
            list.add(0,l.val);
            l=l.next;
        }
        Iterator<Integer> iterator = list.iterator();
        return list;
    }
```

> 思路二

1. 利用递归，相当于数据先入后出
2. 缺点：栈很深，要考虑栈溢出的风险

``` java
static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<Integer>  printListFromTailToHead0(ListNode listNode) {
        if (listNode.next != null) {
            printListFromTailToHead0(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
```

### 心得

1. 对一个链表倒叙输出，无疑就是入栈和出栈操作，也就是典型的先入后出
2. 遍历链表，将读取到的数据压栈，怎么压栈是要考虑的
    1. 方法一：是用一个数组来存储，每次压栈都是在数组头部入栈，但是这样要移动数组中的元素（向后移动一位），这样浪费了时间
    2. 方法二：采用的是递归方式，将指令压栈，然后再讲指令出栈
        1. 风险: 因为Java的方法栈是固定大小的，如果栈太深，那么就会有栈溢出的问题
