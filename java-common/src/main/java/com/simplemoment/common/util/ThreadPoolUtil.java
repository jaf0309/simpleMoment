package com.simplemoment.common.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author: wushen
 * @date: 2021/4/21 上午8:49
 * @description:线程池工具类
 */
@Slf4j
public class ThreadPoolUtil {

    public static ThreadPoolExecutor threadPool =
            new ThreadPoolExecutor(
                    Runtime.getRuntime().availableProcessors(),
                    2 * Runtime.getRuntime().availableProcessors(),
                    5,
                    TimeUnit.MINUTES,
                    new LinkedBlockingQueue<>(100000),
                    new ThreadFactoryBuilder().setNameFormat("threadPoolUtil-%d").build(),
                    new ThreadPoolExecutor.CallerRunsPolicy());;

    /**
     * 无返回值直接执行
     *
     * @param runnable
     */
    public static void execute(Runnable runnable) {
        threadPool.execute(runnable);
    }

    /**
     * 返回值直接执行
     *
     * @param callable
     */
    public static <T> Future<T> submit(Callable<T> callable) {
        return threadPool.submit(callable);
    }

    /** 关闭线程池 */
    public static void shutdown() {
        threadPool.shutdown();
    }

    /** 打印线程池信息 */
    public static void printStats() {
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(
                        () -> {
                            log.info("=========================");
                            log.info("Pool Size: {}", threadPool.getPoolSize());
                            log.info("Active Threads: {}", threadPool.getActiveCount());
                            log.info(
                                    "Number of Tasks Completed: {}",
                                    threadPool.getCompletedTaskCount());
                            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
                        },
                        0,
                        1,
                        TimeUnit.SECONDS);
    }
}