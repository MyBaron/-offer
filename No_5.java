package JianzhiOffer66;

public class No_5 {

    /**
     * 题目：
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
     */
    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一：
     * 思路：
     * 1. 利用中序遍历的特点：先遍历完左子树的节点再到右子树的节点。
     * 2. 如果这个节点有右子树，那么下一个节点就是右子树最最最最最最左节点
     * 3. 如果没有右子树，那么就要往上找父节点。直到找到有一个节点是其父子树的左节点，那么这个父子树就是下一个节点。
     *    原因就是，没有右子树，这个节点就是作为根的这颗树范围内最后一个节点，
     *    因此要向上去找父节点，扩大树的范围，直到有一个节点是作为其父节点的左子树，那么，这个父节点就是下一位要输出的节点
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (null == pNode) {
            return null;
        }
        if (null!=pNode.right) {
            return GetLeft(pNode.right);
        }else if (null!=pNode.next){
            return judge(pNode);
        }
        return null;
    }

    //找到合适的父节点
    private TreeLinkNode judge(TreeLinkNode pNode) {
        TreeLinkNode father = pNode.next;
        if (father == null) {
            return null;
        }
        if (father.left == pNode) {
            return father;
        }else {
            return judge(father);
        }
    }

    //获取该节点的最左节点
    private TreeLinkNode GetLeft(TreeLinkNode pNode) {
        //如果没有左节点，那么就返回当前节点
        if (null == pNode.left) {
            return pNode;
        }
        return GetLeft(pNode.left);
    }


    public static void main(String[] args) {

    }
}
