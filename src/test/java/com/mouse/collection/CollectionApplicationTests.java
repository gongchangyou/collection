package com.mouse.collection;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@SpringBootTest
class CollectionApplicationTests {

    @Test
    void contextLoads() {
        val set = new LinkedHashSet();
        set.add("b");
        set.add("a");
        set.add("c");
        set.add("d");
        set.add("e");
        set.add("f");
        set.add("g");
        set.add("h");

        for (val i : set) {
            log.info("i {}", i);
        }


        val list = new ArrayList<>();
        list.add(1);
        list.add("asdf");
        list.add(1);


        val chm = new ConcurrentHashMap();
        chm.put(null, "asdf");


    }

}
