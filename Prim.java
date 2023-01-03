import java.util.Scanner;
class Prim {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Reading Number of Vertices
        System.out.println("Enter Number of Vertices");
        int n = scan.nextInt();
        int[][] costMatrix = new int[n][n];
        boolean[] visited = new boolean[n];
        //Reading Cost Adjacency Matrix
        System.out.println("Enter Cost Adjacency Matrix");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                costMatrix[i][j] = scan.nextInt();
        //Initializing all nodes as unvisited
        for (int i = 0; i < n; i++)
            visited[i] = false;
        //Reading Source Vertex
        System.out.println("Enter Source Vertex");
        int srcVertex = scan.nextInt();
        scan.close();
        //Marking source vertex as visited
        visited[srcVertex - 1] = true;
        int source = 0, cost = 0, target = 0;
        System.out.print("Edges: ");
        //Actual Calculation starts
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE; //Giving infinite value
            for (int j = 0; j < n; j++) {
                if (visited[j]) { //If the node is visited (In 1st iteration starts from source node)
                    for (int k = 0; k < n; k++) {
                        if (!visited[k] && min > costMatrix[j][k]) { //If a node is not visited and the minimum cost of visiting that node is greater than the actual cost
                            min = costMatrix[j][k];// Then update the minimum cost to actual cost
                            source = j;//Now source is the visited vertex
                            target = k;//And target is the vertex to which we found the cost
                        }
                    }
                }
            }
            visited[target] = true;//Mark the target node also as visited
            System.out.print("(" + (source + 1) + "," + (target + 1) + ")");//Printing the nodes or path
            cost += min;//Calculating the cost
        }
        System.out.println("\nMinimum cost of Spanning Tree: " + cost);
    }
}