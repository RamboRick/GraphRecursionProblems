package basic09;
import java.util.*;
//BFS and visited!

public class KSmall {
    public int kthSmallest(int[][] matrix, int k ) {
        int m = matrix.length, n = matrix[0].length;
        Queue<Cell> pq = new PriorityQueue<>(10, new CellComparator())
        pq.offer(new Cell(0,0,matrix[0][0]));
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        while(!pq.isEmpty()){
            Cell cur = pq.poll();
            count++;
            if(count == k){
                return cur.value;
            }
            if(cur.row < m -1 && !visited[cur.row+1][cur.col]){
                visited[cur.row+1][cur.col] = true;
                pq.offer(new Cell(cur.row+1,cur.col,matrix[cur.row+1][cur.col]));
            }
            if(cur.col < n-1 && !visited[cur.row][cur.col+1]){
                visited[cur.row][cur.col+1] =true;
                pq.offer(new Cell(cur.row,cur.col+1,matrix[cur.row][cur.col+1]));
            }
        }
        return 0;
    }
}

class Cell{
    int row, col, value;
    public Cell(int r, int c, int v){
        row =r;
        col =c;
        value = v;
    }
}


class CellComparator implements java.util.Comparator<Cell> {
    @Override
    public int compare(Cell a, Cell b) {
        if (a.value < b.value) {
            return -1;
        } else if (a.value == b.value) {
            return 0;
        } else {
            return 1;
        }
    }
}