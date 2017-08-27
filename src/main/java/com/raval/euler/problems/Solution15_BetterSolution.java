package com.raval.euler.problems;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by nikunj on 27/08/17.
 */

/**
 * This actually seems like a better solution but the problem is that even Mac book pro hangs on this one ;-)
 */
public class Solution15_BetterSolution {

    public static void main(String[] args) throws Exception {
        Solution15_BetterSolution solution = new Solution15_BetterSolution();
        Node rootNode = solution.generateTree(solution.getGrid());
        //List<String> paths = new ArrayList<>();
        AtomicLong counter = new AtomicLong(0);
        solution.getPossiblePathCount(counter, rootNode);
        System.out.println(counter.get());
    }

    Node generateTree(List<List<Node>> grid) {
        for (int i = grid.size() - 1; i >= 0; i--) {
            for (int j = grid.get(i).size() - 1; j >= 0; j--) {
                if (j > 0) {
                    grid.get(j - 1).get(i).left = grid.get(j).get(i);
                }
                if (i > 0) {
                    grid.get(j).get(i - 1).right = grid.get(j).get(i);
                }
            }
        }
        return grid.get(0).get(0);
    }

    Node generateNode(List<List<String>> grid, int y, int x) {
        Node currentNode = new Node();
        currentNode.value = grid.get(y).get(x);
        currentNode.left = (y < grid.size()) && (x + 1 < grid.get(y).size()) ? generateNode(grid, y, x + 1) : null;
        currentNode.right = (y + 1 < grid.size()) ? generateNode(grid, y + 1, x) : null;
        return currentNode;
    }

    List<List<Node>> getGrid() throws Exception {
        Function<String, List<Node>> parseLine = line -> {
            List<Node> returnList =
                    Arrays.asList(StringUtils.split(line))
                            .stream()
                            .map(str -> new Node(str))
                            .collect(Collectors.toList());
            return returnList;
        };
        return Utility.readFile("Solution15", parseLine);
    }

    void getPossiblePaths(List<String> paths, Node node, String str) {
        if (node == null) return;

        if (node.left != null) getPossiblePaths(paths, node.left, str + node.value + " -> ");
        if (node.right != null) getPossiblePaths(paths, node.right, str + node.value + " -> ");
        if (node.left == null && node.right == null) paths.add(str + node.value);
    }

    void getPossiblePathCount(AtomicLong counter, Node node) {
        if (node == null) return;

        if (node.left != null) getPossiblePathCount(counter, node.left);
        if (node.right != null) getPossiblePathCount(counter, node.right);
        if (node.left == null && node.right == null) System.out.println(counter.incrementAndGet());
    }

    class Node {
        String value;
        Node left;
        Node right;

        public Node() {
        }

        public Node(String value) {
            this.value = value;
        }
    }

}

