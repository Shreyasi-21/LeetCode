class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[] curr;
        
        int x, y, moves = 0;
        
        q.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        
        while (!q.isEmpty()) {
            int sz = q.size();
            moves++;
            
            for (int i=0; i<sz; i++) {
                curr = q.poll();
                
                for (int[] dir: dirs) {
                    x = dir[0]+curr[0];                    
                    y = dir[1]+curr[1];
                    
                    if (x<0||x>=rows||y<0||y>=cols) continue;
                    
                    if (visited[x][y] || maze[x][y] == '+') continue;
                    
          
                    if (x==0||x==rows-1||y==0||y==cols-1) return moves;
                    
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        
        return -1;
    }
}