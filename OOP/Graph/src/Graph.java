import org.w3c.dom.Node;
import java.util.ArrayList;

public class Graph {

    private ArrayList<ArrayList<Integer>> adjacency;

    public Graph(){
        this.adjacency = new ArrayList<ArrayList<Integer>>();
    }

    public ArrayList<Integer> getVertexes(){
        ArrayList<Integer> vertexes = new ArrayList<>();

        this.adjacency.forEach(vertex -> vertexes.add(vertex.get(0)));

        return vertexes;
    }

    public ArrayList<Integer> getVertex(int vertexToFind){
        ArrayList<Integer> vertexFound;
        for(int i = 0; i<this.adjacency.size(); i++)
        {
            if(this.adjacency.get(i).get(0).equals(vertexToFind))
                return this.adjacency.get(i);
        }

        return null;
    }

    public void addVertex(int vertex){
        ArrayList<Integer> vertexes = this.getVertexes();
        ArrayList<Integer> newVertex = new ArrayList<Integer>();
        newVertex.add(vertex);

        if(!vertexes.isEmpty())
            this.adjacency.add(newVertex);
        else{
            ArrayList<Integer> existingVertex = getVertex(vertex);
            if(existingVertex == null){
                this.adjacency.add(newVertex);
            }else{
                System.out.println("Vertex already exists");
            }
        }
    }

    public void removeVertex(ArrayList<Integer> vertex){
        this.adjacency.removeIf(n -> n == vertex);
    }

    public void addEdge(int vertex, int edge){
        ArrayList<Integer> vertexToAddTo = this.getVertex(vertex);
        if(vertexToAddTo != null)
            vertexToAddTo.add(edge);
        else
            System.out.println("Vertex doesnt exist");
    }

    public void removeEdge(int vertex, int edge){
        ArrayList<Integer> vertexToRemoveFrom = this.getVertex(vertex);
        if(vertexToRemoveFrom != null)
            vertexToRemoveFrom.remove(edge);
        else
            System.out.println("Vertex doesnt exist");
    }

    public void printGraph(){
        for (int i = 0; i < this.adjacency.size(); i++) {
            System.out.print(this.adjacency.get(i).get(0) + " -> ");
            for (int j = 1; j < this.adjacency.get(i).size(); j++)
                System.out.print(this.adjacency.get(i).get(j) + ", ");
            System.out.println();
        }
    }




}
