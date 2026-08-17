class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        // code here
        int total = n * n;

        // jump[i] = destination if there is a ladder/snake starting at i
        int[] jump = new int[total + 1];

        for (int i = 1; i <= total; i++) {
            jump[i] = i;
        }

        // Store ladders
        for (int i = 0; i < lad.length; i += 2) {
            jump[lad[i]] = lad[i + 1];
        }

        // Store snakes
        for (int i = 0; i < sn.length; i += 2) {
            jump[sn[i]] = sn[i + 1];
        }

        // BFS
        boolean[] visited = new boolean[total + 1];

        int[] queue = new int[total + 1];
        int[] distance = new int[total + 1];

        int front = 0;
        int rear = 0;

        queue[rear++] = 1;
        visited[1] = true;
        distance[1] = 0;

        while (front < rear) {
            int current = queue[front++];

            // Reached destination
            if (current == total) {
                return distance[current];
            }

            // Try dice values 1 to 6
            for (int dice = 1; dice <= 6; dice++) {
                int next = current + dice;

                if (next > total) {
                    continue;
                }

                // Automatically take snake/ladder
                next = jump[next];

                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue[rear++] = next;
                }
            }
        }

        // Destination cannot be reached
        return -1;
    }
}