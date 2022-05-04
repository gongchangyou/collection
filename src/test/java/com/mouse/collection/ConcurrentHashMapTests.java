package com.mouse.collection;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TestTask implements Runnable {
    private ConcurrentHashMap<Integer, Integer> map;

    public TestTask(ConcurrentHashMap<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            map.put(1, this.map.get(1)+1);
        }
    }
}

@Slf4j
@SpringBootTest
class ConcurrentHashMapTests {
    @Test
    void contextLoads() {
        val threadNumber = 5;
        System.out.println("多线程运行结果：");
        for(int i = 0; i < 5; i++) {
            System.out.println("第" + (i+1) + "次运行结果：" + testAdd(5));
        }
    }

    private static int testAdd(int threadNumber){
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
        map.put(1, 0);
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < threadNumber; i++) {
            pool.execute(new TestTask(map));
        }

        pool.shutdown();

        try {
            pool.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return map.get(1);

    }


}
