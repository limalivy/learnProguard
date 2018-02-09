package io.lim.keeps;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

import io.lim.keeps.elementprocessor.ClassElementProcessor;
import io.lim.keeps.elementprocessor.EnumElementProcessor;
import io.lim.keeps.elementprocessor.IElementProcessor;
import io.lim.keeps.elementprocessor.InterfaceElementProcessor;

/**
 * @author linmin1 on 2018/2/8.
 */

public class EPFactory {
    public static IElementProcessor create(TypeElement element, Attribute attribute, Extend extend, Elements elementUtils){
        switch (element.getKind()){
            case CLASS:
                return createClassProcessor(element, attribute, extend, elementUtils);
            case INTERFACE:
                return createInterfaceProcessor(element, attribute, extend, elementUtils);
            case ENUM:
                return createEnumProcessor(element, attribute, extend, elementUtils);
            default:
                return null;
        }
    }

    private static IElementProcessor createClassProcessor(TypeElement element, Attribute attribute, Extend extend, Elements elementUtils){
        return new ClassElementProcessor(element, attribute, extend, elementUtils);
    }

    private static IElementProcessor createInterfaceProcessor(TypeElement element, Attribute attribute, Extend extend, Elements elementUtils){
        return new InterfaceElementProcessor(element, attribute, extend, elementUtils);
    }

    private static IElementProcessor createEnumProcessor(TypeElement element, Attribute attribute, Extend extend, Elements elementUtils){
        return new EnumElementProcessor(element, attribute, extend, elementUtils);
    }
}
