package io.lim.keeps.elementprocessor;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

import io.lim.keeps.Attribute;
import io.lim.keeps.Extend;

/**
 * @author linmin1 on 2018/2/8.
 */

public class ClassElementProcessor extends AbsElementProcessor {

    public ClassElementProcessor(TypeElement element, Attribute attribute, Extend extend, Elements elementUtils){
        super(element, attribute, extend, elementUtils);
    }

    @Override
    protected String processOnlyName(TypeElement element){
        StringBuilder builder = new StringBuilder();
        builder.append("-keep class ")
                .append(mElementName)
                .append("\n");
        return builder.toString();
    }

    @Deprecated
    protected String processFields(TypeElement element){
        StringBuilder builder = new StringBuilder();
        builder.append("-keepclassmembers class ")
                .append(mElementName)
                .append(" {\n")
                .append("   <fields>;\n")
                .append("}\n");
        return builder.toString();
    }

    @Override
    protected String processMethods(TypeElement element) {
        StringBuilder builder = new StringBuilder();
        builder.append("-keepclassmembers class ")
                .append(mElementName)
                .append(" {\n")
                .append("   <methods>;\n")
                .append("}\n");
        return builder.toString();
    }

    @Override
    protected String processAll(TypeElement element){
        StringBuilder builder = new StringBuilder();
        builder.append("-keep class ")
                .append(mElementName)
                .append(" {\n")
                .append("   *;\n")
                .append("}\n");
        return builder.toString();
    }


    @Override
    protected String processSubClassName(TypeElement element){
        StringBuilder builder = new StringBuilder();
        builder.append("-keep class * extends ")
                .append(mElementName)
                .append("\n");
        return builder.toString();
    }

    @Override
    protected String processSubClassFields(TypeElement element){
        StringBuilder builder = new StringBuilder();
        builder.append("-keepclassmembers class * extends")
                .append(mElementName)
                .append(" {\n")
                .append("   <fields>;\n")
                .append("}\n");
        return builder.toString();
    }

    @Override
    protected String processSubClassMethods(TypeElement element){
        StringBuilder builder = new StringBuilder();
        builder.append("-keepclassmembers class * extends")
                .append(mElementName)
                .append(" {\n")
                .append("   <methods>;\n")
                .append("}\n");
        return builder.toString();
    }

    @Override
    protected String processSubClassAll(TypeElement element){
        StringBuilder builder = new StringBuilder();
        builder.append("-keep class * extends")
                .append(mElementName)
                .append(" {\n")
                .append("   *;\n")
                .append("}\n");
        return builder.toString();
    }
}
