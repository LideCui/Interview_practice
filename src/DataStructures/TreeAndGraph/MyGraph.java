package DataStructures.TreeAndGraph;

public class MyGraph {
    /**
     * Determine if there is path between two nodes
     */
    public static boolean search(Graph g, Node start, Node end){
        if (start == end) return true;

        for(Node n: g.nodes){
            n.state = Node.State.Unvisited;
        }
        start.state = Node.State.Visited;
        for(Node n: start.children){
            if(n.state != Node.State.Visited){
                search(g, n, end);
            }
        }
        return false;
    }
}



class Graph{
    public Node[] nodes;
}

class Node {
    public String name;
    public Node[] children;

    enum State {Unvisited , Visited, Visiting}
    public State state;
}