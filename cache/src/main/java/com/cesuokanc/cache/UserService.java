package com.cesuokanc.cache;

import com.cesuokanc.cache.aspect.TimeCostCheck;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/*
 * @desc
 * @author lirb
 * @datetime 2018/4/23,22:24
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "demoCache")
public class UserService {

    @Data
    public static class UserInfoVO{
        private Object id;
        private Object name;

        public UserInfoVO(Object id, Object name) {
            this.id = id;
            this.name = name;
        }
    }

    private static final Map<String, UserInfoVO> USERS_REPO = new HashMap<>();
    static {
        USERS_REPO.put("1", new UserInfoVO("1", "xiaoming"));
        USERS_REPO.put("2", new UserInfoVO("2", "xiaohong"));
        USERS_REPO.put("3", new UserInfoVO("2", "zhoujielun"));
    }

    @TimeCostCheck
    @Cacheable(value = "demoCache")
//    @Cacheable(condition = "#instrument.equals('trombone')")
    public UserInfoVO getUserById(Object id){
        log.info("==>getUserById Service Called, id:{}", id);
        return USERS_REPO.get(id);
    }


    @CacheEvict(allEntries = true)
    public void clearCache(){}
}
