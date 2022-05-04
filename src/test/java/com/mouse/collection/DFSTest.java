package com.mouse.collection;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;

/**
 * DFS 深度搜索 国际象棋 跳马问题
 * 给定 a,b两个点， 求马走日，最短的次数
 * @author gongchangyou
 * @version 1.0
 * @date 2022/5/4 14:49
 */
@Slf4j
public class DFSTest {
    @Test
    void contextLoads() {
        find(10, 1,1, 9, 5);

    }

    int[][] step = {{1, 2}, {-1, 2},{1, -2}, {-1, -2},{2, 1}, {2, -1},{-2, 1}, {-2, -1}};
    int result = 1<<28;
    private void find(int n, int sx, int sy, int ex, int ey) {
        int[][] arr = new int[n][n];


        //init
        for(var i =0; i<n;i++) {
            for(var j =0; j<n;j++) {
                arr[i][j] = 1<<28;
            }
        }
        //这个点走过的话就没必要走了
        boolean isVisit[][] =new boolean[n][n];
        isVisit[sx][sy] = true;

        int dp[][] =new int[n][n];
        //init
        for(var i =0; i<n;i++) {
            for(var j =0; j<n;j++) {
                dp[i][j] = -1;
            }
        }
        dp[sx][sy] = 0;

        val res = dfs(sx, sy, arr, n, ex, ey, dp);
        log.info("res={}", res);

    }

    private int dfs(int x,int y, int map[][], int n,int ex,int ey, int[][] dp) {
        System.out.println("访问"+(x)+"  " + y);
        if (x == ex && y == ey) {//跳到了
            return 0;
        }

        for(int i=0;i<8;i++)//查找联通节点
        {
            val targetX = step[i][0] + x;
            val targetY = step[i][1] + y;
            log.info("x={} y ={} i={} ",targetX, targetY, i);

            //check border
            if (targetX >=0 && targetX < n && targetY>=0 && targetY <n && dp[targetX][targetY] < 0) {

                if (dp[targetX][targetY] > 0) { //这里进不来
                    dp[targetX][targetY]=Math.min(dp[targetX][targetY], dp[x][y] + 1);
                } else {
                    dp[targetX][targetY] = dp[x][y] + 1;
                }

                if (dp[x][y] >= result) {
                    log.info("x={} y={} continue result={}", x, y,result);
                    continue;
                }
                result = Math.min(result, dfs(targetX, targetY, map, n, ex, ey, dp) + 1);
            }
        }
        log.info("x={} y={} complete result={}", x, y,result);

        return result;
    }

}
