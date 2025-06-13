package LowLevelDesign.DesignSplitwise_Simplify_Algo;

import java.util.*;

public class Code {

    static int simplifyAlgo(int transactions[][]){

        Map<Integer, Integer> userVsBalance = new HashMap<>();
        List<Integer> balanceList = new ArrayList<>();

        for(int[] txn : transactions){   // convert trax to user balance.

            int from = txn[0];
            int to = txn[1];
            int amount = txn[2];

            userVsBalance.put(from, userVsBalance.getOrDefault(from, 0) - amount);  // deduct from FROM USER
            userVsBalance.put(to, userVsBalance.getOrDefault(to, 0) + amount);  // ADD to TO USER
        }

        for(int values : userVsBalance.values()){  // skip all 0, and create a List.

            if(values != 0){
                balanceList.add(values);
            }
        }

        int minTxn = dfs(balanceList, 0);  // try all possible ways

        return minTxn;
    }

    static int dfs(List<Integer> balanceList, int currInd){

        while(currInd < balanceList.size() && balanceList.get(currInd) == 0){  // skip all 0, and go to next index.
            currInd++;
        }
        // There is no need to make txn from 0, because it is already 0 skip it. Or else we may return mintxn = max value.

        if(currInd >= balanceList.size()){  // if we finish all, return 0 traxn
            return 0;
        }

        int minTxn = Integer.MAX_VALUE;
        int currAmount = balanceList.get(currInd);

        for(int ind = currInd+1; ind < balanceList.size(); ind++){

            int nextAmount = balanceList.get(ind);

            if(currAmount * nextAmount < 0){   // if we get + and -ve then we make 1 txn.

                balanceList.set(ind, currAmount + nextAmount);  // update the next amount with curr amount.

                int txn = 1 + dfs(balanceList, ind);  //  Call DFS

                balanceList.set(ind, currAmount);  // backtrack the amount.

                minTxn = Math.min(minTxn, txn);  // get the min txn.

                if(currAmount + nextAmount == 0){  // if we reached 0, -4 -> +4, stop here, dont go further to avoid TC.
                    break;
                }
            }
        }

        return minTxn;
    }

    public static void main(String[] args) {

        int transactions[][] = {
                {0, 1, 10},
                {2, 0, 5},
                {1, 2, 5}
        };

        System.out.println(simplifyAlgo(transactions));
        // 1. 0 -> 1 = 10
        // 2 -> 0 = 5
        // 1 -> 2 = 5.

        // So, we can do a single transaction of 5 from 0 to 2. So, the answer is 1.

        // Time Complexity: O(N!)
        //Space Complexity: O(N)
    }
}
