class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=pattern.length();i++){
            st.push(i+1);
            if(i==pattern.length() || pattern.charAt(i)=='I'){
                while(!st.isEmpty()){
                    sb.append(st.peek());
                    st.pop();
                }//IIIDI          1 2 3 5 4
            }
        }
        return sb.toString();
    }
}