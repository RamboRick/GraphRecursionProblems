package basic09;
//有了假想pivot 所以不需要来回换
public class MoveZero {
    public int[] moveZero(int[] array){
        if(array == null && array.length ==0){
            return array;
        }
        int left = 0, right = array.length -1;
        while(left <= right){
            if(array[left] != 0){
                left++
            }else{
                swap(array,left,right);
                right --;
            }
        }
        return array;

    }

    private void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
