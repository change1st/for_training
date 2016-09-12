package com.th.Algorithm;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by mr_change on 16-6-13.
 */
public class BeautifulHome {

    public static void main(String[] args) {
        Integer[][] grids = {{0, 0, 1, 1, 1},
                             {1, 0, 0, 0, 1},
                             {1, 1, 1, 1, 1}};
        countHomes(grids);
    }

    private static void countHomes(Integer[][] grids) {

        Map<Integer, List<Integer>> map = Maps.newHashMap();
        int homes = 0;
        for (int rCount = 0; rCount < grids.length; rCount++) {
            for (int cCount = 0; cCount < grids[rCount].length; cCount++) {
                Position position = new Position(rCount, cCount);
                if (grids[rCount][cCount] != 1) {
                    continue;
                }

                int count = 0;
                if(loopSearch(position, grids, map, count) > 0) {
                    homes++;
                }
            }

        }

        System.out.println(homes);
    }

    private static int loopSearch(Position position, Integer[][] grids, Map<Integer, List<Integer>> map, int count) {
        if(position.xCoordinate < 0 || position.xCoordinate >= grids.length ||
                position.yCoordinate < 0 || position.yCoordinate >= grids[position.xCoordinate].length ||
                grids[position.xCoordinate][position.yCoordinate] == 0) {
            return count;
        }

        if(checkRepetition(position, map)) {
            return count;
        }

        count++;
        loopSearch(new Position(position.xCoordinate, position.yCoordinate-1), grids, map, count);
        loopSearch(new Position(position.xCoordinate, position.yCoordinate+1), grids, map, count);
        loopSearch(new Position(position.xCoordinate-1, position.yCoordinate), grids, map, count);
        loopSearch(new Position(position.xCoordinate+1, position.yCoordinate), grids, map, count);

        return count;
    }

    private static boolean checkRepetition(Position position, Map<Integer, List<Integer>> map) {
        List<Integer> list = map.get(position.xCoordinate);
        if(CollectionUtils.isEmpty(list)) {
            map.put(position.xCoordinate, Lists.newArrayList(position.yCoordinate));
            return false;
        }

        if(!list.contains(position.yCoordinate)) {
            list.add(position.yCoordinate);
            map.put(position.xCoordinate, list);
            return false;
        }

        return true;
    }

    private static class Position {
        private int xCoordinate;
        private int yCoordinate;

        public Position() {
        }

        public Position(int xCoordinate, int yCoordinate) {
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
        }

        public int getXCoordinate() {
            return xCoordinate;
        }

        public void setXCoordinate(int xCoordinate) {
            this.xCoordinate = xCoordinate;
        }

        public int getYCoordinate() {
            return yCoordinate;
        }

        public void setYCoordinate(int yCoordinate) {
            this.yCoordinate = yCoordinate;
        }
    }
}
