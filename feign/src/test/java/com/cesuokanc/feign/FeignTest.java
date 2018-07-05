package com.cesuokanc.feign;


import com.alibaba.fastjson.JSON;
import feign.*;
import feign.codec.Decoder;
import org.junit.Test;

import java.io.BufferedReader;
import java.lang.reflect.Type;

/**
 * @author liruibo
 * @date 2018/7/5
 */
public class FeignTest {
    private static String DEMO_URL = "http://localhost:9091";


    /**
     * 未设置超时
     */
    @Test
    public void test1() {
        IHttpDemoService httpDemoService = Feign.builder().decoder(new MyDecoder() {
            @Override
            public Object parseBody(String content) {
                //泛型部分必须重新进行反序列化 -- fastjson
                RestResult<User> restResult = JSON.parseObject(content, RestResult.class);
                return JSON.parseObject(JSON.toJSONString(restResult.getData()), User.class);
            }
        }).target(IHttpDemoService.class, DEMO_URL);
        System.out.println(httpDemoService.getUserById(1));
    }


    /**
     * 设置超时
     * 1. 连接超时1s
     * 2. 读取超时2s
     */
    @Test
    public void test2() {
        IHttpDemoService httpDemoService = Feign.builder()
                .options(new Request.Options(1, 2))
                .decoder(new MyDecoder() {
                    @Override
                    public Object parseBody(String content) {
                        //泛型部分必须重新进行反序列化 -- fastjson
                        RestResult<User> restResult = JSON.parseObject(content, RestResult.class);
                        return JSON.parseObject(JSON.toJSONString(restResult.getData()), User.class);
                    }
                }).target(IHttpDemoService.class, DEMO_URL);
        System.out.println(httpDemoService.getUserById(1));
    }


    public interface IHttpDemoService {
        @RequestLine("GET /busy/user/{id}")
        User getUserById(@Param("id") Integer id);
    }

    /**
     * 可对一般接口进行扩展，使之支持函数式
     *
     * @param <T>
     */
    @FunctionalInterface
    interface MyDecoder<T> extends Decoder {

        T parseBody(String res);

        @Override
        default T decode(Response response, Type type) {
            String content;
            try (BufferedReader bufferedReader = new BufferedReader(response.body().asReader())) {
                content = bufferedReader.lines().reduce(String::concat).orElse("");
            } catch (Exception e) {
                return null;
            }
            return parseBody(content);
        }
    }


}
