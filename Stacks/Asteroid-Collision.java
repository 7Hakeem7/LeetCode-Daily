class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> arrList = new ArrayList<>();
        for(var asteroid: asteroids) {
            if(arrList.isEmpty() || arrList.get(arrList.size() - 1) > 0 && asteroid > 0) {
                arrList.add(asteroid);
                continue;
            }
            while(!arrList.isEmpty()) {
                var top = arrList.get(arrList.size() - 1);
                if(top > 0 && asteroid < 0) {
                    var abs2 = Math.abs(asteroid);
                    if(top <= abs2) {
                        arrList.remove(arrList.size() - 1);
                    }
                    if(top >= abs2) {
                        break;
                    }
                    if(arrList.isEmpty()) {
                        arrList.add(asteroid);
                        break;
                    }
                } else {
                    arrList.add(asteroid);
                    break;
                }
            }
        }
        var result = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); ++i) {
            result[i] =  arrList.get(i);
        }
        return result;
    }
}