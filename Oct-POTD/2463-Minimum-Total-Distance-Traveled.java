class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
         //have all factory based on it's frequency
        List<Integer> factories = new ArrayList<>();
        for(int i = 0 ; i < factory.length ; i++){
            for(int j = 0; j < factory[i][1] ; j++){
                factories.add(factory[i][0]);
            }
        }

        Collections.sort(robot);
        Collections.sort(factories);

        int m = robot.size() ;
        int n = factories.size();

        long[][] memoization = new long[m+1][n+1];
        Arrays.stream(memoization).forEach(a -> Arrays.fill(a, -1));
        
        return count(robot , factories , 0 , 0 , memoization);
    }

     private long count(List<Integer> robot, List<Integer> factories, int robotInd, int factoryIndex, long[][] dp) {

        if(robotInd == robot.size()) return 0; //all robot are fixed

        if(factoryIndex == factories.size()) return (long) 1e18; // there is no factory

        //if already calculated this subproblem
        if (dp[robotInd][factoryIndex]!=-1) return dp[robotInd][factoryIndex];

        long cost = Math.abs(robot.get(robotInd)-factories.get(factoryIndex));

        long fixHere=cost + count(robot ,factories,robotInd+1,factoryIndex+1,dp); //fix robot in this factory
        long notFixHere = count(robot , factories , robotInd,factoryIndex+1,dp); // do not fix here

        return dp[robotInd][factoryIndex]=Math.min(fixHere,notFixHere);

    }
}