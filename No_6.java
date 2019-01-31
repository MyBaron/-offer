package JianzhiOffer66;

import java.util.Stack;

public class No_6 {

    //题目描述
    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型


    /**
     * 思路：
     * 1. 将stack1作为入栈，stack2作为出栈
     * 2. 出栈时，只需要判断stack2是否有元素，如果有，就直接出，如果没有，就从stack1逐个移动到stack2（主要的耗时操作）
     * 3. 入栈时，只需要直接添加到stack1就可以
     */

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            //这里stack1.size() != 1 是为了减少一次移动栈的操作
            while (!stack1.empty() && stack1.size() != 1) {
                stack2.add(stack1.pop());
            }
            return stack1.pop();
        }
        return stack2.pop();
    }
}
