package com.example.lin.learnproguard.test;

import io.lim.keeps.Attribute;
import io.lim.keeps.Extend;
import io.lim.keeps.Keeps;

/**
 * @author linmin1 on 2018/2/8.
 */

@Keeps(attribute = Attribute.METHODS,extend = Extend.SUBCLASS)
public interface ITest {
    void test666();
    class Test2{

    }
}
