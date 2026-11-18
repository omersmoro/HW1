public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        // We will use the BFS algorithm for this assignement

        // A vertex has a shortest path of length 0 to itself
        if (i == j) {
            return 0;
        }

        int n = m.length;

        // Keep track of visited vertices
        boolean[] visited = new boolean[n];

        // Queue for BFS
        int[] queue = new int[n];

        int front = 0;
        int rear = 0;

        // Start BFS from vertex i
        queue[rear++] = i;
        visited[i] = true;

        int distance = 0;

        while (front < rear) {

            int size = rear - front;
            distance++;

            // Process all vertices at the current distance
            for (int k = 0; k < size; k++) {

                int current = queue[front++];

                // Check all possible neighbors
                for (int neighbor = 0; neighbor < n; neighbor++) {

                    if (m[current][neighbor] == 1 &&
                        !visited[neighbor]) {

                        // We found the destination
                        if (neighbor == j) {
                            return distance;
                        }

                        visited[neighbor] = true;
                        queue[rear++] = neighbor;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}