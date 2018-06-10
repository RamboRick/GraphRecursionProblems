package basic09;
import java.util.*;
public class PathSum {
    public boolean hasPath(TreeNode root, int sum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right==null && root.value == sum){
            return true;
        }
        boolean flag = false;
        if(root.left !==null){
            flag = hasPath(root.left,sum - root.value);
        }
        if(root.right !=null){
            flag = flag || hasPath(root.right, sum- root.value);
        }
        return flag;
    }
}
