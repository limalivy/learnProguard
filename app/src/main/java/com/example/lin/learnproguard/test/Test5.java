package com.example.lin.learnproguard.test;

import io.lim.keeps.Keeps;

/**
 * @author linmin1 on 2018/2/9.
 */

public class Test5 {
    @Keeps
    int test1;

    int test2;

    @Keeps
    public void test3(){

    }

    public void test4(){

    }
}
