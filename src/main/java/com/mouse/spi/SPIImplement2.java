package com.mouse.spi;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/5/4 09:37
 */
@AllArgsConstructor
@NoArgsConstructor
public class SPIImplement2 implements SPIInterface {
    //a is field of instance
    //can not override
    public int a  = 4;

    @Override
    public String getStr() {
        return null;
    }
}
