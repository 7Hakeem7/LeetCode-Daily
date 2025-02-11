class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder currStr = new StringBuilder(s);
        int index  = currStr.indexOf(part);
        while(index != -1){
            currStr.delete(index, index + part.length());
            index = currStr.indexOf(part);
        }
        return currStr.toString();
    }
}