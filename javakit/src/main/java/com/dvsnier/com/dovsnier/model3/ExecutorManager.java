package com.dvsnier.com.dovsnier.model3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * <pre>
 * the current executor manager is a fixed-size thread pool manager
 * </pre>
 *
 * @author dovsnier
 * @version 1.0.0
 * @since jdk 1.7
 */
public class ExecutorManager {

    public static final String TAG = "ExecutorManager";

    private static ExecutorManager executorManager = null;
    private static final int FIX_THREAD_POOL_NUMBER = 3;
    private static ThreadFactory defaultThreadFactory;
    private ExecutorService defaultExecutorService = null;

    private ExecutorManager() {
        instantiateThreadPool();
    }

    /**
     * instantiate thread pool
     *
     * @version 0.0.1
     */
    private synchronized void instantiateThreadPool() {
        // System.out.println("FIX_THREAD_POOL_NUMBER:" + FIX_THREAD_POOL_NUMBER);
        defaultThreadFactory = Executors.defaultThreadFactory();
        defaultExecutorService = Executors.newFixedThreadPool(FIX_THREAD_POOL_NUMBER, defaultThreadFactory);
    }

    /**
     * single executor manager instantiate
     *
     * @return the {@link ExecutorManager } object
     * @version 0.0.1
     */
    public static ExecutorManager getInstance() {
        synchronized (ExecutorManager.class) {
            if (null == executorManager) {
                executorManager = new ExecutorManager();
            }
        }
        return executorManager;
    }

    /**
     * @return the defaultExecutorService
     * @see ExecutorService
     */
    public ExecutorService getDefaultExecutorService() {
        return defaultExecutorService;
    }

    /**
     * @return the defaultThreadFactory
     * @see ThreadFactory
     */
    public synchronized ThreadFactory getDefaultThreadFactory() {
        return null == defaultThreadFactory ? defaultThreadFactory = Executors.defaultThreadFactory() : defaultThreadFactory;
    }

    /**
     * close the current thread pool
     *
     * @version 0.0.1
     */
    public synchronized void shutdown() {
        if (null != defaultExecutorService && !defaultExecutorService.isShutdown()) {
            defaultExecutorService.shutdown();
        }
    }
}
