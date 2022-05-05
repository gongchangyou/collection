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
public class DFSTest2 {

    boolean vst[][] =new boolean[10][10];
    int ans = 1<<28;
    int gx = 9;
    int gy = 5;
    int[][] d = {{1, 2}, {-1, 2},{1, -2}, {-1, -2},{2, 1}, {2, -1},{-2, 1}, {-2, -1}};

    boolean CheckEdge(int nx,int ny, int n){//检查边界条件
        if(nx>=0 && nx<n && ny>=0 && ny<n && !vst[nx][ny])
            return true;
        return false;
    }

    @Test
    void contextLoads() {
        val sx = 1;
        val sy = 1;
        vst[1][1]=true;
        dfs(sx, sy, 0, 10);
        log.info("result={}", ans);
    }

    void dfs(int x,int y,int step, int n){//DFS
        if(step>=ans)return;//最优性剪枝
        if(x==gx && y==gy){
            ans= step;
            return;
        }
        int nx,ny;
        for(var i=0;i<8; i++){
            nx=x+d[i][0];
            ny=y+d[i][1];
            if(CheckEdge(nx,ny, n)){
                vst[nx][ny]=true;//搜索
                dfs(nx,ny,step+1, n);
                vst[nx][ny]=false;//回溯
                log.info("false nx={} ny={}",nx, ny);
            }
        }
    }

}
