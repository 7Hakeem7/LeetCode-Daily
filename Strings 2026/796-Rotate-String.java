class Solution {   
    public boolean rotateString(String s, String goal) {
        //your code goes here
        if(s.length() != goal.length())return false;
        //brute force one: keep shifting one char to left and keep checking if list equals goal
        //taking ArrayList of chars so shifting becomes easy
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> goalList = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
            goalList.add(goal.charAt(i));
        }

        //check and shift part
        int cnt = 0;
        while(cnt < s.length()){
            //check first, so zero shifts is also covered (s = goal case)
            if(list.equals(goalList)){
                return true;
            }
            char ch = list.get(0);//store the first val
            list.remove(0);//remove the first to shift the rest to left
            //then add it back to list
            list.add(ch);
            cnt++;
        }
        return false;
    }
}