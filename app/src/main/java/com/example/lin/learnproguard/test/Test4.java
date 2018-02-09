package com.example.lin.learnproguard.test;


import io.lim.keeps.Attribute;
import io.lim.keeps.Extend;
import io.lim.keeps.Keeps;

/**
 * @author linmin1 on 2018/2/8.
 */

@Keeps(attribute = Attribute.METHODS,extend = Extend.INNERCLASS)
public enum Test4 implements ITest {
    TEST1,
    TEST2;

    @Override
    public void test666() {

    }

    public void test444(){

    }

    public static class Test7{
        public void test55(){

        }
    }
}
