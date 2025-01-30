// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int re = helper(coins, 0, amount);
//         if(re >= 9999) return -1;
//         return re;
//     }

//     private int helper(int[] coins,int idx, int amount){
//         // base case
//         if(amount == 0) return 0;
//         if(amount < 0 || idx == coins.length) return 9999;
//         // logc
//         // not choosing
//         int case1 = 0 + helper(coins,idx+1,amount);

//         // choosing
//         int case2 = 1 + helper(coins,idx, amount - coins[idx]);

//         return Math.min(case1, case2);
//     }
// }

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length; int n = amount;
        int [][] dp = new int [m+1][n+1];
        
        for(int j = 1;j<=n;j++){
            //dummy row
            dp[0][j] = 99999;
        }

        for(int i=1; i<=m ;i++){
            for(int j=1;j<=n;j++){
                if(coins[i-1] > j){
                    // 0 case
                    dp[i][j] = dp[i-1][j];
                }else{
                    // 0 and 1 case
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        int re = dp[m][n];
        if(re >= 99999) return -1;
        return re;

    }
}

