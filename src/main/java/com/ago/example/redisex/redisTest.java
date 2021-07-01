package com.ago.example.redisex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author ：Ago
 * @date ：Created in 2021/4/19 11:37
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class redisTest implements CommandLineRunner {


    private final StringRedisTemplate redisTemplate;

    public redisTest(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void run(String... args) throws InterruptedException {

        String alreadyUser = "alreadyUser";

        String user = "sns_wechat_123";

        String user_ = "sns_wechat_1234";

        redisTemplate.opsForHash().put(alreadyUser, user, "1");

        redisTemplate.opsForHash().put(alreadyUser, user_, "1");

        System.out.println("user result:" + redisTemplate.opsForHash().get(alreadyUser, user));

        System.out.println("put result：" + redisTemplate.opsForHash().putIfAbsent(alreadyUser, user, "1"));

        Thread.sleep(2000);

        System.out.println("delete size:" + redisTemplate.delete(alreadyUser));

        final Map<Object, Object> entries = redisTemplate.opsForHash().entries(alreadyUser);

        redisTemplate.opsForHash().put(alreadyUser, user, "1");


        System.out.println(redisTemplate.opsForHash().putIfAbsent(alreadyUser, user, "1"));



    }


    public static void main(String[] args) {

        final List<Integer> list = Arrays.asList(1, 2, 3, 3);


        final HashSet<Integer> integers = new HashSet<>(list);

        integers.stream().forEach(System.out::print);
    }
}
