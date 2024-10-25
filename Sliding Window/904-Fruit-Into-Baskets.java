// class Solution {
//     public int totalFruit(int[] fruits) {
//         int k = 0;
//         int start = 0 , end = 0;
//         HashMap<Integer> map = new HashMap<>();
//         while(end < fruits.length){
//             if(!map.containsKey(fruits[end]) && k < 2){
//                 map.add(fruits[end] + 0 , 1);
//                 k++;
//                 end++;
//             }else{
//                 map.remove(fruits[start]);
//                 k--;
//                 start++;
//                 end++;
//             }
//             return end - start + 1;
//         }
//     }
// }

class Solution {
  public int totalFruit(int[] tree) {
    int ans = 0;
    Map<Integer, Integer> count = new HashMap<>();

    for (int l = 0, r = 0; r < tree.length; ++r) {
      count.put(tree[r], count.getOrDefault(tree[r], 0) + 1);
      while (count.size() > 2) {
        count.put(tree[l], count.get(tree[l]) - 1);
        count.remove(tree[l], 0);
        ++l;
      }
      ans = Math.max(ans, r - l + 1);
    }

    return ans;
  }
}