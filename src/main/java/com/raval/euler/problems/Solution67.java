package com.raval.euler.problems;

import java.util.List;

/**
 * Created by nikunj on 28/08/17.
 */
public class Solution67 {
    public static void main(String[] args) throws Exception {
        Solution18 solution = new Solution18();
        List<List<Integer>> grid = solution.getGrid("Solution67");
        System.out.println(solution.longPathSum(grid));
    }
}
