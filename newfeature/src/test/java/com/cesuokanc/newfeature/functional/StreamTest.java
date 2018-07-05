package com.cesuokanc.newfeature.functional;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liruibo
 * @date 2018/7/5
 */
public class StreamTest {

    private static List<Integer> data = Lists.newArrayList(1231, 32131, 31231, 31312, 312312);

    @Test
    public void testFilter() {
        List<Integer> res = data.stream().filter(x -> x > 1300).collect(Collectors.toList());
        Assert.assertTrue(res.size() == 4);
    }

    @Test
    public void testMap() {
        List<Integer> res = data.stream()
                .filter(x -> x > 1300)
                .map(x -> x + 1000)
                .collect(Collectors.toList());
        System.out.println(res);
    }

    @Test
    public void testMap2() {
        List<String> res = data.stream()
                .filter(x -> x > 1300)
                .map(x -> x + 1000+"")
                .collect(Collectors.toList());
        System.out.println(res);
    }

    @Test
    public void testFinalValue(){
        Integer v = 1000;
        data.stream().forEach(x->{
//            v = v + 1000; //error final properties
        });
    }

    @Test
    public void testParallel(){
        List<Integer>  res = data.stream().parallel().filter(x->x>1000).collect(Collectors.toList());
        System.out.println(res);
    }


}
