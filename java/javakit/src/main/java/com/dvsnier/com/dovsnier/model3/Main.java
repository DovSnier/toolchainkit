package com.dvsnier.com.dovsnier.model3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * <pre>
 * Main Class
 * </pre>
 *
 * @author dovsnier
 * @version 1.0.0
 * @since jdk 1.7
 */
public class Main {

    /**
     * two types of tests, a choice.
     *
     * @param args
     * @version 0.0.1
     */
    public static void main(String[] args) {
        // testOne();
        testTwo();
    }

    /**
     * <br>
     * 2015年4月2日
     *
     * @version 0.0.1
     */
    public static void testTwo() {
        ExecutorManager.getInstance().getDefaultExecutorService().execute(ExecutorManager.getInstance().getDefaultThreadFactory().newThread(new Runnable() {

            @Override
            public void run() {
                System.out.println("the test thread factory is completed.");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    ExecutorManager.getInstance().shutdown();
                }
            }
        }));
    }

    /**
     * <br>
     * 2015年4月2日
     *
     * @version 0.0.1
     */
    public static void testOne() {
        Future<String> future = ExecutorManager.getInstance().getDefaultExecutorService().submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "the test future is completed";
            }

        });
        try {
            System.out.println("future:" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            ExecutorManager.getInstance().shutdown();
        }
    }

}
