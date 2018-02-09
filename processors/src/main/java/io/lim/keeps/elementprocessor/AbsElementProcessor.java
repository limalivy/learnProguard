package io.lim.keeps.elementprocessor;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

import io.lim.keeps.Attribute;
import io.lim.keeps.EPFactory;
import io.lim.keeps.Extend;

/**
 * @author linmin1 on 2018/2/8.
 */

public abstract class AbsElementProcessor implements IElementProcessor{
    protected TypeElement mElement;
    protected Attribute mAttribute;
    protected Extend mExtend;
    protected Elements mElementUtils;
    protected final String mElementName;

    public AbsElementProcessor(TypeElement element,Attribute attribute,Extend extend,Elements elementUtils){
        this.mElement = element;
        this.mAttribute = attribute;
        this.mExtend = extend;
        this.mElementUtils = elementUtils;
        mElementName = elementUtils.getBinaryName(element).toString();
    }

    @Override
    public final String process(){
        StringBuilder builder = new StringBuilder();
        switch (mExtend){
            case NONE:
                switch (mAttribute){
                    case NAME:
                        return processOnlyName(mElement);
                    case FIELDS:
                        builder.append(processOnlyName(mElement));
                        builder.append(processFields(mElement));
                        return builder.toString();
                    case METHODS:
                        builder.append(processOnlyName(mElement));
                        builder.append(processMethods(mElement));
                        return builder.toString();
                    case ALL:
                        builder.append(processOnlyName(mElement));
                        builder.append(processAll(mElement));
                        return builder.toString();
                    default:
                        break;
                }
                break;
            case INNERCLASS:
                switch (mAttribute) {
                    case NAME:
                        builder.append(processOnlyName(mElement));
                        break;
                    case FIELDS:
                        builder.append(processOnlyName(mElement));
                        builder.append(processFields(mElement));
                        break;
                    case METHODS:
                        builder.append(processOnlyName(mElement));
                        builder.append(processMethods(mElement));
                        break;
                    case ALL:
                        builder.append(processOnlyName(mElement));
                        builder.append(processAll(mElement));
                        break;
                }
                return builder.append(processInnerClass(mElement)).toString();
            case SUBCLASS:
                switch (mAttribute) {
                    case NAME:
                        builder.append(processOnlyName(mElement));
                        builder.append(processSubClassName(mElement));
                        break;
                    case FIELDS:
                        builder.append(processOnlyName(mElement));
                        builder.append(processSubClassName(mElement));
                        builder.append(processFields(mElement));
                        builder.append(processSubClassFields(mElement));
                        break;
                    case METHODS:
                        builder.append(processOnlyName(mElement));
                        builder.append(processSubClassName(mElement));
                        builder.append(processMethods(mElement));
                        builder.append(processSubClassMethods(mElement));
                        break;
                    case ALL:
                        builder.append(processOnlyName(mElement));
                        builder.append(processSubClassName(mElement));
                        builder.append(processAll(mElement));
                        builder.append(processSubClassAll(mElement));
                        break;
                }
                return builder.toString();
        }
        return "";
    }

    protected String processInnerClass(TypeElement element){
        StringBuilder builder = new StringBuilder();
        for(Element ele : element.getEnclosedElements()){
            if(ele.getKind() == ElementKind.CLASS
                    || ele.getKind() == ElementKind.INTERFACE
                    || ele.getKind() == ElementKind.ENUM){
                IElementProcessor processor =
                        EPFactory.create((TypeElement) ele,mAttribute,mExtend,mElementUtils);
                builder.append(processor.process());
            }
        }
        return builder.toString();
    }



    protected abstract String processOnlyName(TypeElement element);

    protected abstract String processFields(TypeElement element);

    protected abstract String processMethods(TypeElement element);

    protected abstract String processAll(TypeElement element);

    protected abstract String processSubClassName(TypeElement element);

    protected abstract String processSubClassFields(TypeElement element);

    protected abstract String processSubClassMethods(TypeElement element);

    protected abstract String processSubClassAll(TypeElement element);
}
