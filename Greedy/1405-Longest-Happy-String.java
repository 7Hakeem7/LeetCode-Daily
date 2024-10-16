class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        if(a > 0) pq.offer(new Pair('a' , a));
        if(b > 0) pq.offer(new Pair('b' , b));
        if(c > 0) pq.offer(new Pair('c' , c));

        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int n = res.length();
            int ch = node.ch;
            int count = node.count;
            //check if the previous two chars are the same 
            if(n >= 2 && res.charAt(n-1) == ch && res.charAt(n-2) == ch){
                if(pq.isEmpty())break;
                Pair sec = pq.poll();
                res.append(sec.ch);
                sec.count--;
                if(sec.count > 0){
                    pq.offer(new Pair(sec.ch , sec.count));
                }
            }
            else{
                res.append(node.ch);
                node.count--;
            }
            if(node.count > 0){
                pq.offer(new Pair(node.ch , node.count));
            }
        }
        return res.toString();
        
    }
}

class Pair implements Comparable<Pair>{
    char ch;
    int count;
    Pair(char ch , int count){
        this.ch = ch;
        this.count = count;
    }
    public int compareTo(Pair that){
        return that.count - this.count; //sorts based on count value in decreasing order
    }
}