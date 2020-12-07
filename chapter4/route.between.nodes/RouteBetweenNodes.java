import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class RouteBetweenNodes {
	public static void main(String a[])
	{
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[2];
		Node end = n[5];
		System.out.println("Route " + ( doesRouteExist(g, start, end) ? "exists" : "does not exist") + " between start and end.");
	}
	
	public static boolean doesRouteExist(Graph g, Node start, Node end) {
		Queue<Node> queue = new LinkedBlockingQueue<>();
		
		start.queued = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			System.out.println("Polled " + current.getVertex() + " from the queue.");

			Node[] neighbours = current.getAdjacent();
			for(Node neighbour : neighbours) {
				if(neighbour == end)
					return true;
				if(neighbour.queued == false) {
					neighbour.queued = true;
					queue.add(neighbour);
				}
			}
			
		}
		
		return false;
	}
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}
}

class Graph {
	public static int MAX_VERTICES = 6;
	private Node vertices[];
	public int count;
	public Graph() {
		vertices = new Node[MAX_VERTICES];
		count = 0;
    }
	
    public void addNode(Node x) {
		if (count < vertices.length) {
			vertices[count] = x;
			count++;
		} else {
			System.out.print("Graph full");
		}
    }
    
    public Node[] getNodes() {
        return vertices;
    }
}

class Node {
    private Node adjacent[];
    public int adjacentCount;
    private String vertex;
	public boolean queued;
	
    public Node(String vertex, int adjacentLength) {
        this.vertex = vertex;                
        adjacentCount = 0;        
        adjacent = new Node[adjacentLength];
		queued = false;
    }
    
    public void addAdjacent(Node x) {
        if (adjacentCount < adjacent.length) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.print("No more adjacent can be added");
        }
    }
    public Node[] getAdjacent() {
        return adjacent;
    }
    public String getVertex() {
        return vertex;
    }
}