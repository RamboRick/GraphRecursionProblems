package basic09;
import java.util.*;
public class isBipartite {
    public boolean isBipartite(List<GraphNode> graph){
        Map<GraphNode, Boolean> visited = new HashMap<>();
        //记录的三个状态，红色，蓝色，没色 用boolean来区分！！
        for(GraphNode start : graph){
            if(!visited.containsKey(start)){
                Queue<GraphNode> queue = new LinkedList<>();
                queue.offer(start);
                visited.put(start,true);
                while(!queue.isEmpty()){
                    GraphNode cur = queue.poll();
                    boolean color = visited.get(cur);
                    for(GraphNode nei : cur.nei){
                        if(visited.containsKey(nei) && color == visited.get(nei)){
                            return false;
                        }
                        if(!visited.containsKey(nei)){
                            queue.offer(nei);
                            visited.put(nei,!color);
                        }
                    }
                }
            }
        }
        return true;
    }
}

class GraphNode{
    public int value;
    public int set;
    public List<GraphNode> nei;

}
