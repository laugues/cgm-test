package com.laugues.cgm.language;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by SOLO on 20/09/2017.
 */
public class Test
{
    public void test(){


        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new HelloRunnable());

        executor = Executors.newSingleThreadExecutor();
        executor.submit(new HelloCallable());


        executor = Executors.newSingleThreadExecutor();
        executor.submit(new Thread());


    }


}
