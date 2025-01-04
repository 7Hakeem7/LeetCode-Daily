class Solution {
    public int countPalindromicSubsequence(String s) {
        int count=0;
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length();i++){
            set.add(s.charAt(i));
        }
        Iterator it = set.iterator();
        while(it.hasNext()){
            char ch = (char)it.next();
            int start = s.indexOf(ch);
            int last = s.lastIndexOf(ch);
            if(start!=last){
                Set<Character> tempSet = new HashSet<>();
                for(int i=start+1;i<last;i++){
                    tempSet.add(s.charAt(i));
                }
                count+=tempSet.size();
            }
        }

        return count;
    }
}