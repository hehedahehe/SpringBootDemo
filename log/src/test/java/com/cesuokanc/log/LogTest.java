package com.cesuokanc.log;

import com.cesuokanc.log.demo.OtherTools;
import com.cesuokanc.log.demo.Tools;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/20
*/
@Slf4j
public class LogTest {
    /**
     * error>warn>info>debug>trace
     */
    @Test
    public  void testLog1(){
        Tools.doIt();
        OtherTools.doIt();
    }
}
