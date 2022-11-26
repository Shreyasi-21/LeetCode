class Solution {
   
public int maxEvents(int[][] events) {
    
        Arrays.sort(events, (a,b) ->  {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
      
        int j = 0;
        int attended = 0;
        
        // by fefault, from small to big
        // PriorityQueue contains last day
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<100_001; i++) {
            //  remove from pq everything < currect day
            while(!pq.isEmpty() && pq.peek() < i)
                pq.poll();
            
            //  for all events started on day d, add the last day to queue
            for(; j<events.length && events[j][0] == i; j++) {
                pq.offer(events[j][1]);
            }
            
            if(!pq.isEmpty()) {
                pq.poll();
                attended++;
            }
        }
        
        return attended;
    }
    
}