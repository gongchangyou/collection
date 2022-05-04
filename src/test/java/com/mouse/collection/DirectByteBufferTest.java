package com.mouse.collection;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/4/29 13:56
 */
public class DirectByteBufferTest {
    @Test
    void contextLoads() {
        val bb =ByteBuffer.allocateDirect(130);
        bb.reset();
    }
}
