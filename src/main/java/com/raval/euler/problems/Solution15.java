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

/**
 *
 https://projecteuler.net/problem=15

 In the writtern solution I could find that the series looks like this

 1,
 2,
 6,
 20,
 70,
 252,
 924,

 But I could not find the 21st term

 So googling the website https://oeis.org/A000984

 Gave me the 21st term is  137846528820

 the eqation it seems is Central binomial coefficients: binomial(2*n,n) = (2*n)!/(n!)^2
 
 */
public class Solution15 {

    class Node{
        String value;
        Node left;
        Node right;

    }

    Node generateTree(List<List<String>> grid){
        return generateNode(grid, 0, 0);
    }

    Node generateNode(List<List<String>> grid, int y, int x){
        Node currentNode = new Node();
        currentNode.value = grid.get(y).get(x);
        currentNode.left =  (y <  grid.size()) && (x+1 <  grid.get(y).size()) ? generateNode(grid, y, x+1) : null;
        currentNode.right = (y+1 <  grid.size()) ? generateNode(grid, y+1, x) : null;
        return currentNode;
    }

    List<List<String>> getGrid() throws Exception {
        Function<String, List<String>> parseLine = line -> {
            List<String> returnList =
                    Arrays.asList(StringUtils.split(line))
                            .stream()
                            .collect(Collectors.toList());
            return returnList;
        };
        return Utility.readFile("Solution15A", parseLine);
    }

    void getPossiblePaths(List<String> paths, Node node, String str){
        if(node == null) return;

        if(node.left != null) getPossiblePaths(paths, node.left, str + node.value + " -> ");
        if(node.right != null) getPossiblePaths(paths, node.right, str + node.value + " -> ");
        if(node.left == null && node.right == null) paths.add(str + node.value);
    }

    public static void main(String[] args) throws Exception{
        Solution15 solution15 = new Solution15();
        Node rootNode = solution15.generateTree(solution15.getGrid());
        List<String> paths = new ArrayList<>();
        solution15.getPossiblePaths(paths, rootNode, "");
        System.out.println(paths.size());
    }




}
