package com.atguigu.gmall.index.service;

import com.alibaba.fastjson.JSON;
import com.atguigu.core.bean.Resp;
import com.atguigu.gmall.index.annotation.GmallCache;
import com.atguigu.gmall.index.feign.GmallPmsClient;
import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.atguigu.gmall.pms.vo.CategoryVO;
import org.aopalliance.intercept.Joinpoint;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class IndexService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX = "index:cates:";

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private GmallPmsClient gmallPmsClient;

    public List<CategoryEntity> queryLvl1Categories() {

        Resp<List<CategoryEntity>> listResp = this.gmallPmsClient.queryCategoriesByPidOrLevel(1, null);

        return listResp.getData();
    }

    @GmallCache(prefix = "index:cates:", timeout = 7200, random = 100)
    public List<CategoryVO> querySubCategories(Long pid) {
        // 1. 判断缓存中有没有
//        String cateJson = this.redisTemplate.opsForValue().get(KEY_PREFIX + pid);
        // 2. 有，直接返回
//        if (!StringUtils.isEmpty(cateJson)) {
//            return JSON.parseArray(cateJson, CategoryVO.class);
//        }

//        RLock lock = this.redissonClient.getLock("lock" + pid);
//        lock.lock();

        // 1. 判断缓存中有没有
//        String cateJson2 = this.redisTemplate.opsForValue().get(KEY_PREFIX + pid);
        // 2. 有，直接返回
//        if (!StringUtils.isEmpty(cateJson2)) {
//            lock.unlock();
//            return JSON.parseArray(cateJson2, CategoryVO.class);
//        }

        // 查询数据库
        Resp<List<CategoryVO>> listResp = gmallPmsClient.querySubCategories(pid);
        List<CategoryVO> categoryVOS = listResp.getData();
        // 3. 查询完成后放入缓存
//        this.redisTemplate.opsForValue().set(KEY_PREFIX + pid, JSON.toJSONString(categoryVOS), 7 + new Random().nextInt(5), TimeUnit.DAYS);

//        lock.unlock();

        return listResp.getData();
    }

    public static void main(String[] args) {
        System.out.println(new Random().nextInt(50));
    }

    /**
     * 锁
     * 1. 互斥性
     * 2. 获取锁并设置过期时间防止死锁，要具备原子性。释放锁也要具备原子性
     * 3. 解铃还须系铃人
     */
    public void testLock() {

        RLock lock = this.redissonClient.getLock("lock");
        lock.lock();

        String numString = this.redisTemplate.opsForValue().get("num");
        if (StringUtils.isEmpty(numString)) {
            return;
        }
        int num = Integer.parseInt(numString);
        this.redisTemplate.opsForValue().set("num", String.valueOf(++num));

        lock.unlock();
    }

    /**
     * 锁
     * 1. 互斥性
     * 2. 获取锁并设置过期时间防止死锁，要具备原子性。释放锁也要具备原子性
     * 3. 解铃还须系铃人
     */
    public void testLock1() {

        // 给自己的锁生成一个唯一标志
        String uuid = UUID.randomUUID().toString();
        // 执行redis的setnx命令
        Boolean lock = this.redisTemplate.opsForValue().setIfAbsent("lock", uuid, 5, TimeUnit.SECONDS);

        // 判断是否拿到锁
        if (lock) {

            String numString = this.redisTemplate.opsForValue().get("num");
            if (StringUtils.isEmpty(numString)) {
                return;
            }
            int num = Integer.parseInt(numString);
            this.redisTemplate.opsForValue().set("num", String.valueOf(++num));

            // 释放锁资源，其他请求才能执行（LUA）
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            this.redisTemplate.execute(new DefaultRedisScript<>(script), Arrays.asList("lock"), uuid);
//            if(StringUtils.equals(this.redisTemplate.opsForValue().get("lock"), uuid)) {
//                this.redisTemplate.delete("lock");
//            }
        } else {
            // 其他请求重试获取锁
            testLock();
        }
    }

    public String testRead() {
        RReadWriteLock rwLock = this.redissonClient.getReadWriteLock("rwLock");
        rwLock.readLock().lock(10l, TimeUnit.SECONDS);

        String test = this.redisTemplate.opsForValue().get("test");

//        rwLock.readLock().unlock();
        return test;
    }

    public String testWrite() {
        RReadWriteLock rwLock = this.redissonClient.getReadWriteLock("rwLock");
        rwLock.writeLock().lock(10l, TimeUnit.SECONDS);

        this.redisTemplate.opsForValue().set("test", UUID.randomUUID().toString());

//        rwLock.writeLock().unlock();

        return "写入了数据";
    }

    public String testLatch() throws InterruptedException {
        RCountDownLatch latch = this.redissonClient.getCountDownLatch("latch");
        latch.trySetCount(5);

        latch.await();
        return "主业务开始执行。。。。。";
    }

    public String testCountdown() {
        RCountDownLatch latch = this.redissonClient.getCountDownLatch("latch");
        latch.countDown();

        return "分支业务执行了一次";
    }
}
