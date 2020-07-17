package com.dvsnier.utils.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * general thread tool class(don't consider thread execution with return values)
 * Created by lizw on 2016/9/12.
 */
public class ThreadUtil {

    private final static int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private final static int MAXIMUM_POOL_SIZE = CORE_POOL_SIZE * 3;
    private final static int DEFAULT_DEQUE_CAPACITY = MAXIMUM_POOL_SIZE * 5;
    private static LinkedBlockingDeque workQueue = new LinkedBlockingDeque(DEFAULT_DEQUE_CAPACITY);
    private static ExecutorService executorService;

    static {
        //noinspection ConstantConditions
        if (null != executorService && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        newInstance();
    }

    public static void execute(Runnable runnable) {
        if (null == executorService) {
            synchronized (ThreadUtil.class) {
                newInstance();
            }
        }
        executorService.execute(runnable);
    }

    public static void shutdown() {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
            executorService = null;
        }
    }

    private static void newInstance() {
        //noinspection unchecked
        executorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 60, TimeUnit.SECONDS, workQueue, new ThreadPoolExecutor.DiscardPolicy());
    }
}
