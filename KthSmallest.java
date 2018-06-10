package basic09;
import java.util.*;
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k ){
        if(root == null){
            return -1;
        }
        int size = count(root.left);
        if(k < size+1){
            return kthSmallest(root.left, k);
        }else if(k == size +1){
            return root.value;
        }else {
            return kthSmallest(root.right, k-size-1);
        }
    }
    private int count(TreeNode root){
        if(root== null) return 0;
        return 1+count(root.left) + count(root.right);
    }
}
class TreeNode{
    TreeNode left,right;
    int value;
}
