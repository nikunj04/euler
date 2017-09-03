package com.raval.euler.problems;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by nikunj on 01/09/17.
 */
public class Solution15 {

    public static void main(String[] args) throws Exception {
        Solution15 solution = new Solution15();
        Node rootNode = solution.generateTree(solution.getGrid());
        AtomicInteger count = new AtomicInteger(0);
        solution.traversePath(rootNode, count);
        System.out.println(count);
    }


    void traversePath(Node node, AtomicInteger count) {
        if (node.left == null && node.right == null) {
            System.out.println(count.incrementAndGet());
        }
        if (node.left != null) {
            traversePath(node.left, count);
        }
        if (node.right != null) {
            traversePath(node.right, count);
        }
    }

    void traversePath(Node node, Set<Node> path) {
        path.add(node);
        if (node.left == null && node.right == null) {
            System.out.println(path);
        }
        if (node.left != null) {
            traversePath(node.left, path);
        }
        if (node.right != null) {
            traversePath(node.right, path);
        }
        path.remove(node);
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

    class Node implements Comparable<Node> {
        String value;
        Node left;
        Node right;
        Node previous = null;

        public Node() {
        }

        public Node(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return o.value.compareTo(this.value);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return value.equals(node.value);
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }
}
