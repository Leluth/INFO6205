/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: TreeNode
 * @date 2021/12/12 10:43
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(){}

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
