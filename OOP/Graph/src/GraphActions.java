import java.util.*;

public class GraphActions {

    public static boolean BFS(Graph graph, int source, int destination){

        List<Integer> sourceAsList = Arrays.asList(source);

        Queue<Integer> toVisit = new LinkedList<>(sourceAsList);
        Set<Integer> visited = new HashSet<>(sourceAsList);

        while (!toVisit.isEmpty()){
            int current = toVisit.poll();
            if(current == destination)
                return true;
            else{
                ArrayList<Integer> neighbors = graph.getVertex(current);
                for (int i = 0; i < neighbors.size(); i++) {
                    if(!visited.contains(neighbors.get(i))){
                        toVisit.add(neighbors.get(i));
                        visited.add(neighbors.get(i));
                    }
                }

            }
        }

        return false;

    }


}
