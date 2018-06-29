package com.cesuokanc.log.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/20
*/
@Slf4j
public final class Tools {


    public static void doIt(){
        log.info("tools...");
        log.debug("tools...");
        log.warn("tools...");
        log.error("tools...");
    }
}
