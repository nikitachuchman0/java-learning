package leetcode;

public class InsertBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

         insertIntoBSTinner(root,val);
         return root;

    }



    private void insertIntoBSTinner( TreeNode current,int val){

        if (current.val > val) {
            if (current.left == null) {
                current.left = new TreeNode(val);
                return ;
            }
             insertIntoBSTinner(current.left, val);
        } else {
            if (current.right == null){
                current.right = new TreeNode(val);
                return ;
            }
             insertIntoBSTinner(current.right, val);
        }
    }
}

