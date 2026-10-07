package leetcode;



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

 class BSTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        return inorderTraversalInner(root,list);
    }

    private List<Integer> inorderTraversalInner(TreeNode node, List<Integer> list){
        if (node == null) return list;

        inorderTraversalInner(node.left,list);
        if (Integer.valueOf(node.val) != null) list.add(node.val);
        inorderTraversalInner(node.right,list);

        return list;
    }

    private List<Integer> inorderTraversalInnerIterative(TreeNode node, List<Integer> list){
        if (node == null) return list;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = node;

        while (current != null || !stack.isEmpty()){
             if (current != null){
                 stack.push(current);
                 current = current.left;
             }
             else {
                 current = stack.pop();
                 if (Integer.valueOf(current.val) != null) list.add(current.val );
                 current = current.right;
             }
        }

        return list;

    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
