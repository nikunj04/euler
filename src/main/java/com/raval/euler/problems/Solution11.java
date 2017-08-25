package com.raval.euler.problems;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nikunj on 25/08/17.
 */
public class Solution11 {
    Integer[][] grid;

    public Solution11() throws Exception{
        grid = getGrid();

    }

    public static void main(String[] args) throws Exception{
        System.out.println(new Solution11().getMaxProductForGrid());
    }

    Integer getMaxProductForGrid(){
        Integer max = Integer.MIN_VALUE;
        for(int y=0;y<grid.length;y++){
            for(int x=0;x<grid[y].length;x++){
                max = Integer.max(max, getMaxProductForAPoint(y, x));
            }
        }
        return max;
    }

    Integer getMaxProductForAPoint(int y, int x){
        Integer horizontal = Integer.max(getHorizontalLeftProduct(y,x),getHorizontalRightProduct(y,x));
        Integer vertical = Integer.max(getVerticalDownProduct(y,x),getVerticalUpProduct(y,x));
        Integer diagonal = getDiagonalProduct(y,x);
        System.out.println("("+y+","+x+") : "+horizontal + " , "+ vertical + " , "+diagonal);
        return NumberUtils.max(horizontal, vertical, diagonal);
    }

    Integer getHorizontalRightProduct(int y, int x){
        if(x+3 > 19){
            return Integer.MIN_VALUE;
        }else{
            return grid[y][x] * grid[y][x+1] * grid[y][x+2] * grid[y][x+3];
        }
    }

    Integer getHorizontalLeftProduct(int y, int x){
        if(x-3 < 0){
            return Integer.MIN_VALUE;
        }else{
            return grid[y][x] * grid[y][x-1] * grid[y][x-2] * grid[y][x-3];
        }
    }

    Integer getVerticalDownProduct(int y, int x){
        if(y+3 > 19){
            return Integer.MIN_VALUE;
        }else{
            return grid[y][x] * grid[y+1][x] * grid[y+2][x] * grid[y+3][x];
        }
    }

    Integer getVerticalUpProduct(int y, int x){
        if(y-3 < 0){
            return Integer.MIN_VALUE;
        }else{
            return grid[y][x] * grid[y-1][x] * grid[y-2][x] * grid[y-3][x];
        }
    }

    Integer getDiagonalProduct(int y, int x){
        return Integer.max(
                Integer.max(getDiagonalLeftDownProduct(y,x) , getDiagonalLeftUpProduct(y,x)),
                Integer.max(getDiagonalRightDownProduct(y,x), getDiagonalRightUpProduct(y,x)));

    }

    Integer getDiagonalRightDownProduct(int y, int x){
        if(y+3 > 19 || x+3>19){
            return Integer.MIN_VALUE;
        }else{
            return grid[y][x] * grid[y+1][x+1] * grid[y+2][x+2] * grid[y+3][x+3];
        }
    }

    Integer getDiagonalLeftDownProduct(int y, int x){
        if(y+3 > 19 || x-3<0){
            return Integer.MIN_VALUE;
        }else{
            return grid[y][x] * grid[y+1][x-1] * grid[y+2][x-2] * grid[y+3][x-3];
        }
    }

    Integer getDiagonalRightUpProduct(int y, int x){
        if(y-3 < 0 || x+3>19){
            return Integer.MIN_VALUE;
        }else{
            return grid[y][x] * grid[y-1][x+1] * grid[y-2][x+2] * grid[y-3][x+3];
        }
    }

    Integer getDiagonalLeftUpProduct(int y, int x){
        if(y-3 < 0 || x-3<0){
            return Integer.MIN_VALUE;
        }else{
            return grid[y][x] * grid[y-1][x-1] * grid[y-2][x-2] * grid[y-3][x-3];
        }
    }

    Integer[][] getGrid() throws Exception{
        Path resource = Paths.get(ClassLoader.getSystemResource("Solution11").toURI());
        try (Stream<String> lines = Files.lines(resource)) {
            List<Integer[]> parsedLines =
                    lines.map(this::getGridLine).collect(Collectors.toList());
            return parsedLines.toArray(new Integer[parsedLines.size()][]);
        }
    }

    Integer[] getGridLine(String line){
        List<Integer> returnList =
                Arrays.asList(StringUtils.split(line))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return returnList.toArray(new Integer[returnList.size()]);
    }
}
