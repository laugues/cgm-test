package com.laugues.cgm.language;

import java.util.Iterator;
import java.util.concurrent.Callable;

/**
 * Created by SOLO on 20/09/2017.
 */

public class HelloCallable implements Callable<Integer>
{
    private Integer number;

    @Override
    public Integer call() throws Exception {

        if (number < 0) {
            throw new Exception("Number has to be positive");
        }

        return 0;
    }
}
