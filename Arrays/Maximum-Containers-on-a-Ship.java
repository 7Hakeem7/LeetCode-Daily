class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int totalCells = n * n;
        if(totalCells * w <= maxWeight){
            return totalCells;
        }else{
            return maxWeight / w;
        }
    }
}