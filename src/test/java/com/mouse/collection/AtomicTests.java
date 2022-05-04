package com.mouse.collection;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@SpringBootTest
class AtomicTests {

    @Test
    void contextLoads() {
      val a = new AtomicInteger(3);
      val c = a.getAndDecrement();

      log.info("a={}, c={}",a,c);
    }

}
