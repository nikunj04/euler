package com.raval.euler.problems;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by nikunj on 27/08/17.
 */
public class Solution18 {
    public static void main(String[] args) throws Exception {
        Solution18 solution = new Solution18();
        List<List<Integer>> grid = solution.getGrid("Solution18");
        System.out.println(solution.longPathSum(grid));
    }

    List<List<Integer>> getGrid(String resource) throws Exception {
        Function<String, List<Integer>> parseLine = line -> {
            List<Integer> returnList =
                    Arrays.asList(StringUtils.split(line))
                            .stream()
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
            return returnList;
        };
        return Utility.readFile(resource, parseLine);
    }

    void reduce(List<List<Integer>> list) {
        if (list.size() == 1)
            return;

        List<Integer> penultimate = list.get(list.size() - 2);
        List<Integer> ultimate = list.get(list.size() - 1);
        List<Integer> newPenultimate = new ArrayList<>();
        for (int i = 0; i < penultimate.size(); i++) {
            Integer oldValue = penultimate.get(i);
            Integer offset1 = ultimate.get(i);
            Integer offset2 = ultimate.get(i + 1);
            newPenultimate.add(Integer.max(oldValue + offset1, oldValue + offset2));
        }
        list.set(list.size() - 2, newPenultimate);
        list.remove(list.size() - 1);
        return;
    }

    int longPathSum(List<List<Integer>> orgList) {
        int numberOfIterations = orgList.size();
        for (int i = 0; i < numberOfIterations; i++) {
            reduce(orgList);
        }
        return orgList.get(0).get(0);
    }

}
