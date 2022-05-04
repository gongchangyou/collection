package com.mouse.collection;

import com.mouse.spi.SPIImplement1;
import com.mouse.spi.SPIInterface;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.ServiceLoader.load;
import static java.util.stream.StreamSupport.stream;

@Slf4j
@SpringBootTest
class SPITests {

    @Test
    void contextLoads() {
        //根据配置文件 获取interface的所有实现类
        val list = stream(load(SPIInterface.class).spliterator(), false)
                .toArray(SPIInterface[]::new);

        for (val i : list) {
            try {
                val instance = i.getClass().getDeclaredConstructor().newInstance();
                if (instance instanceof SPIImplement1) {
                    ((SPIImplement1)instance).str = "sss";
                }

                log.info("i={} instance={}", i, instance);
                log.info("i.a={} instance.a={}", i.a, instance.a);
                log.info("i.str={} instance.str={}", i.str, instance.getStr());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

}
