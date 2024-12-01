class Solution {
    public boolean checkIfExist(int[] arr) {
        //so the thing is we stand on one element
        //and check if there exists a 2 x the curr element in the array?
        //We can use a HashMap for that.
        //also we may not use it twice since i != j (0 case)
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(hm.containsValue(arr[i]*2) || hm.containsKey(arr[i])) {
                return true;
            }
            hm.put(arr[i]*2,arr[i]);
            
        }
        return false;
    }
}