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
public class SPIImplement1 implements SPIInterface {
    //can not change variables
    public String str = "spi1";

    @Override
    public String getStr() {
        return str;
    }
}
