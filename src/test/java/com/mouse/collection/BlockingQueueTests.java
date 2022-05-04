package com.mouse.collection;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
@SpringBootTest
class BlockingQueueTests {

    @Test
    void contextLoads() {
        val q = new LinkedBlockingQueue(2);
        try {
            q.put("1");
            q.put("2");
            log.info("2");
            q.put("3");
log.info("sss");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
