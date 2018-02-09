package io.lim.keeps.elementprocessor;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

import io.lim.keeps.Attribute;
import io.lim.keeps.Extend;

/**
 * @author linmin1 on 2018/2/8.
 */

public class EnumElementProcessor extends AbsElementProcessor {

    public EnumElementProcessor(TypeElement element, Attribute attribute, Extend extend, Elements elementUtils) {
        super(element, attribute, extend, elementUtils);
    }

    @Override
    protected String processOnlyName(TypeElement element) {
        return String.format("-keep enum %s\n",mElementName);
    }

    @Override
    protected String processFields(TypeElement element) {
        return String.format("-keepclassmembers enum %s {\n" +
                "   <fields>;\n" +
                "}\n",mElementName);
    }

    @Override
    protected String processMethods(TypeElement element) {
        return String.format("-keepclassmembers enum %s {\n" +
                "   <methods>;\n" +
                "}\n",mElementName);
    }

    @Override
    protected String processAll(TypeElement element) {
        return String.format("-keep enum %s {\n" +
                "   *;\n" +
                "}\n",mElementName);
    }

    @Override
    protected String processSubClassName(TypeElement element) {
        return "";
    }

    @Override
    protected String processSubClassFields(TypeElement element) {
        return "";
    }

    @Override
    protected String processSubClassMethods(TypeElement element) {
        return "";
    }

    @Override
    protected String processSubClassAll(TypeElement element) {
        return "";
    }
}
