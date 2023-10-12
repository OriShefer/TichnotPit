public class Main {
    public static void main(String[] args) {
        final int HAIFA = 1;
        final int HADERA = 2;
        final int HOLON = 3;
        final int RESHON = 4;
        final int HERZELIA = 5;
        final int NATANYA = 6;

        Graph cities = new Graph();

        //HAIFA
        cities.addVertex(HAIFA);

        cities.addEdge(HAIFA,HERZELIA);
        cities.addEdge(HAIFA,NATANYA);
        cities.addEdge(HAIFA,HADERA);

        //HADERA
        cities.addVertex(HADERA);

        cities.addEdge(HADERA,HAIFA);
        cities.addEdge(HADERA,HOLON);
        cities.addEdge(HADERA,RESHON);
        cities.addEdge(HADERA,HERZELIA);

        //HOLON
        cities.addVertex(HOLON);

        cities.addEdge(HOLON,HADERA);
        cities.addEdge(HOLON,RESHON);
        cities.addEdge(HOLON,NATANYA);
        cities.addEdge(HOLON,HAIFA);

        //RESHON
        cities.addVertex(RESHON);

        cities.addEdge(RESHON,HOLON);
        cities.addEdge(RESHON,HADERA);
        cities.addEdge(RESHON,NATANYA);
        cities.addEdge(RESHON,HERZELIA);

        //HERZELIA
        cities.addVertex(HERZELIA);

        cities.addEdge(HERZELIA,HAIFA);
        cities.addEdge(HERZELIA,HADERA);
        cities.addEdge(HERZELIA,NATANYA);
        cities.addEdge(HERZELIA,RESHON);

        //NATANYA
        cities.addVertex(NATANYA);

        cities.addEdge(NATANYA,HAIFA);
        cities.addEdge(NATANYA,HOLON);
        cities.addEdge(NATANYA,HERZELIA);

        cities.printGraph();

        // Here, a path exists.
        System.out.println(GraphActions.BFS(cities, RESHON, NATANYA));

        // Here, it does not.
        System.out.println(GraphActions.BFS(cities,HAIFA, 7));


    }
}