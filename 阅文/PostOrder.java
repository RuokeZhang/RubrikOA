package 阅文;
/*给定一个二叉树的中序与后序遍历结果，请你根据两个序列构造符合这两个序列的二叉树。

数据范围：二叉树的节点数满足  ，节点上的值满足 ，保证节点的值各不相同

例如输入[2,1,4,3,5],[2,4,5,3,1]时，
根据中序遍历的结果[2,1,4,3,5]和后序遍历的结果[2,4,5,3,1]可构造出二叉树{1,2,3,#,#,4,5}，如下图所示： */
import 阅文.TreeNode;

 public class PostOrder {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param inorder int整型一维数组 中序遍历序列
     * @param postorder int整型一维数组 后序遍历序列
     * @return TreeNode类
     */
    public TreeNode buildTree (int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}