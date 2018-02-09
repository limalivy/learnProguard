package io.lim.keeps;

import com.google.auto.service.AutoService;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

import io.lim.keeps.elementprocessor.IElementProcessor;

import static javax.tools.StandardLocation.SOURCE_OUTPUT;

@AutoService(Processor.class)
public class NotProguardProcessor extends AbstractProcessor{

    // 元素操作的辅助类
    Elements elementUtils;
    Filer elementFiler;

    ProguardFileOuter outer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        elementUtils = processingEnv.getElementUtils();
        elementFiler = processingEnvironment.getFiler();
        String filePath = getOutFilePath();
        System.out.println("apt generate pro file path :"+filePath);
        if(null != filePath &&  !"".equals(filePath)) {
            outer = ProguardFileOuter.build(filePath);
            outer.println(getKeepSelfString());
            outer.println(getKeepCommonString());
        }
    }

    private String getKeepSelfString(){
        return String.format("-keep @interface %s {*;}\n" +
                "-keep enum %s {*;}\n" +
                "-keep enum %s {*;}\n",
                Keeps.class.getCanonicalName(),
                Attribute.class.getCanonicalName(),
                Extend.class.getCanonicalName());
    }

    private String getKeepCommonString(){
        String keepName  = Keeps.class.getCanonicalName();
        return String.format(
                "-keepclassmembers class *{\n" +
                "   @%s *;\n" +
                "}\n" +
                "-keepclassmembers interface *{\n" +
                "   @%s *;\n" +
                "}\n" +
                "-keepclassmembers enum *{\n" +
                "   @%s *;\n" +
                "}\n",
                keepName,keepName,
                keepName,keepName,
                keepName,keepName);
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        System.out.println("------------------------------------");
        Set<? extends Element> elememts = roundEnvironment.getElementsAnnotatedWith(Keeps.class);
        for(Element ele : elememts){
            ElementKind kind = ele.getKind();
            switch (kind){
                case CLASS:
                case INTERFACE:
                case ENUM:
                    processTypeElement((TypeElement) ele);
                default:
                    break;
            }
        }
        System.out.println("------------------------------------");
        return true;
    }

    private String getOutFilePath(){
        try {
            return elementFiler.createResource(SOURCE_OUTPUT, "","keeps-rules.pro").getName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void processTypeElement(TypeElement element){
        Attribute attribute = element.getAnnotation(Keeps.class).attribute();
        Extend extend = element.getAnnotation(Keeps.class).extend();
        IElementProcessor processor = EPFactory.create(element,attribute,extend,elementUtils);
        outer.println(processor.process());
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(Keeps.class.getCanonicalName());
        return types;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

}
