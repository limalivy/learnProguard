package io.lim.keeps.elementprocessor;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

import io.lim.keeps.Attribute;
import io.lim.keeps.Extend;

/**
 * @author linmin1 on 2018/2/8.
 */

public class InterfaceElementProcessor extends AbsElementProcessor {

    public InterfaceElementProcessor(TypeElement element, Attribute attribute, Extend extend, Elements elementUtils){
        super(element, attribute, extend, elementUtils);
    }

    /**
     *
     ###################接口############################
     #name
     -keep interface com.example.lin.learnproguard.test.ITest
     #feilds
     -keepclassmembers interface com.example.lin.learnproguard.test.ITest {
     <fields>;
     }
     #methods
     -keepclassmembers interface com.example.lin.learnproguard.test.ITest {
     <methods>;
     }

     #接口的继承关系
     -keep interface * extends com.example.lin.learnproguard.test.ITest
     -keep class * implements com.example.lin.learnproguard.test.ITest
     -keep enum * implements com.example.lin.learnproguard.test.ITest

     * @param element
     * @return
     */
    @Override
    protected String processOnlyName(TypeElement element) {
        StringBuilder builder = new StringBuilder();
        builder.append("-keep interface ")
                .append(mElementName)
                .append("\n");
        return builder.toString();
    }

    @Override
    protected String processFields(TypeElement element) {
        StringBuilder builder = new StringBuilder();
        builder.append("-keepclassmembers interface ")
                .append(mElementName)
                .append("{\n")
                .append("   <fields>;\n")
                .append("}\n");
        return builder.toString();
    }

    @Override
    protected String processMethods(TypeElement element) {
        StringBuilder builder = new StringBuilder();
        builder.append("-keepclassmembers interface ")
                .append(mElementName)
                .append("{\n")
                .append("   <methods>;\n")
                .append("}\n");
        return builder.toString();
    }

    @Override
    protected String processAll(TypeElement element) {
        StringBuilder builder = new StringBuilder();
        builder.append("-keep interface ")
                .append(mElementName)
                .append(" {\n")
                .append("   *;\n")
                .append("}\n");
        return builder.toString();
    }

    /**
     *
     *
     #接口的继承关系
     -keep interface * extends com.example.lin.learnproguard.test.ITest
     -keep class * implements com.example.lin.learnproguard.test.ITest
     -keep enum * implements com.example.lin.learnproguard.test.ITest
     * @param element
     * @return
     */
    @Override
    protected String processSubClassName(TypeElement element) {
        StringBuilder builder = new StringBuilder();
        builder.append("-keep interface * extends ")
                .append(mElementName)
                .append("\n")
                .append("-keep class * implements ")
                .append(mElementName)
                .append("\n")
                .append("-keep enum * implements ")
                .append(mElementName)
                .append("\n");
        return builder.toString();
    }

    /**
     *
     builder.append("-keepclassmembers class * extends")
     .append(mElementUtils.getBinaryName(element).toString())
     .append(" {\n")
     .append("   <fields>;\n")
     .append("}\n");
     #methods
     -keepclassmembers interface com.example.lin.learnproguard.test.ITest {
     <methods>;
     }
     * @param element
     * @return
     */
    @Override
    protected String processSubClassFields(TypeElement element) {
        StringBuilder builder = new StringBuilder();
        builder.append("-keepclassmembers interface * extends ")
                .append(mElementName)
                .append(" {\n")
                .append("   <fields>;\n")
                .append("}\n")
                .append("-keepclassmembers class * implements ")
                .append(mElementName)
                .append(" {\n")
                .append("   <fields>;\n")
                .append("}\n")
                .append("-keepclassmembers enum * implements ")
                .append(mElementName)
                .append(" {\n")
                .append("   <fields>;\n")
                .append("}\n");
        return builder.toString();
    }

    @Override
    protected String processSubClassMethods(TypeElement element) {
        StringBuilder builder = new StringBuilder();
        builder.append("-keepclassmembers interface * extends ")
                .append(mElementName)
                .append(" {\n")
                .append("   <methods>;\n")
                .append("}\n")
                .append("-keepclassmembers class * implements ")
                .append(mElementName)
                .append(" {\n")
                .append("   <methods>;\n")
                .append("}\n")
                .append("-keepclassmembers enum * implements ")
                .append(mElementName)
                .append(" {\n")
                .append("   <methods>;\n")
                .append("}\n");
        return builder.toString();
    }

    @Override
    protected String processSubClassAll(TypeElement element) {
        StringBuilder builder = new StringBuilder();
        builder.append("-keep interface * extends ")
                .append(mElementName)
                .append(" {\n")
                .append("   *;\n")
                .append("}\n")
                .append("-keep class * implements ")
                .append(mElementName)
                .append(" {\n")
                .append("   *;\n")
                .append("}\n")
                .append("-keep enum * implements ")
                .append(mElementName)
                .append(" {\n")
                .append("   *;\n")
                .append("}\n");
        return builder.toString();
    }

}
