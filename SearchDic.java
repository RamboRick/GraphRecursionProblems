package basic09;

import java.util.Dictionary;
//区别在于先找个有边界
//还要判断是否为null
//time complexity： O(n)
//space complexity: O(1)

public class SearchDic {
    public int search(Dictionary dictionary, int target){
        int left = 0;
        int right =1;
        Integer r = (Integer) dictionary.get(right);
        while(r != null && r < target){
            right *= 2;
        // right is a right boundary
        }
        //binary search
        while(left <= right){
            int mid = left + (right - left) /2;
            Integer x =(Integer) dictionary.get(mid);
            if(x == null || target < x){
                right = mid -1;
            }else if (target == x){
                return mid;
            }else {
                left = mid +1;
            }
        }
        return -1;
    }
}
