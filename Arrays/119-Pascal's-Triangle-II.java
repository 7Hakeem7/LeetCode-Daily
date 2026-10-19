class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < rowIndex + 1; i++){
            result.add(nCr(rowIndex,i));
        }
        return result;
    }
    private int nCr(int R, int C){
        long res = 1;
        for(int i = 0; i < C; i++){
            res *= (R - i);
            res = res/(i + 1);
        }
        return (int)res;
    }
}