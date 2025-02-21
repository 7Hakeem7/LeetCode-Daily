class MyHashMap {
    int[] arrMap;
    public MyHashMap() {
        arrMap = new int[1000001];
        // for(int i = 0; i < arrMap.length; i++){
        //     arrMap[i] = -1;
        // }
    }
    
    public void put(int key, int value) {
        arrMap[key] = value+1;
    }
    
    public int get(int key) {
        return arrMap[key]-1;
    }
    
    public void remove(int key) {
        arrMap[key] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */