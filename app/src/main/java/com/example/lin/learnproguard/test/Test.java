package com.example.lin.learnproguard.test;


import io.lim.keeps.Attribute;
import io.lim.keeps.Extend;
import io.lim.keeps.Keeps;

/**
 * @author linmin1 on 2018/2/7.
 */
@Keeps(attribute = Attribute.METHODS,extend = Extend.INNERCLASS)
public class Test implements ITest{
    int test1;
    int test2;

    @Override
    public void test666() {

    }

    public static class Test3 {
        int test5;
        int test6;

        public void test3333() {

        }

        public static class Test5{
            public class Test6{
                public void test888(){

                }
            }
        }
    }

    interface Test4{
        public void test3333();

        public void test444();
    }

    public void test555(){

    }
}
