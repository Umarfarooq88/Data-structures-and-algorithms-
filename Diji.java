import java.util.Scanner;

public class Diji {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number of Vertices");
        int n = scan.nextInt();
        int[][] adj = new int[n][n];
        System.out.println("Enter Adjacency Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = scan.nextInt();
            }
        }
        System.out.println("Enter Source vertex");
        int src = scan.nextInt();
        int[] dist = dijkstra(adj, src);
        for (int i = 0; i < n; i++) {
            if ((src - 1) == i) {
                break;
            }
            System.out.println("Shortest Distance from " + src + " to " + (i + 1) + " is " + dist[i]);
        }
        scan.close();
    }
    static int[] dijkstra(int[][] adj, int src) {
        int n = adj.length;
        int[] dist = new int[n];

        boolean[] visited = new boolean[n];
        int min_dist, unvis = -1;
/*1*/   for (int i = 0; i < n; i++)//Initializing the graph
        {
            dist[i] = adj[src - 1][i];//Assigning all the distance of edges from source to distance array.
            visited[i] = false;
        }

        visited[src - 1] = true;//Source is visited

        for (int i = 1; i < n; i++)//Actual calculation of the shortest path.
        {
            min_dist = Integer.MAX_VALUE;
/*2*/       for (int j = 0; j < n; j++)//Updating the smallest value to each node
            {
                if (!visited[j] && dist[j] < min_dist){//Node is not visited and distance is less than current node distance
                    unvis = j;  //Assign the smallest distance node as Unvisited
                    min_dist = dist[j];//Updating the latest smallest value
                }
            }
            visited[unvis] = true;//Mark the unvisited node as visited
/*3*/       for (int v = 0; v < n; v++)//Finding the shortest path value (Relaxation)
            {
                if (!visited[v] && dist[unvis] + adj[unvis][v] < dist[v]) {//Applying relaxation formula
                    //if(dist[u] + cost or adj[u][v] < dist[v]) then dist[v] = dist[u] + cost or adj[u][v]
                    dist[v] = dist[unvis] + adj[unvis][v];//If (currentNode + edge)Value < nextNodeValue
                }
            }
        }
        return dist;
    }
}