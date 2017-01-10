package com.example;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;


@SupportedAnnotationTypes(value = {SettingsItemProcessor.ANNOTATION_TYPE})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
//@SupportedOptions({SettingsItemProcessor.ENABLE_OPTIONS_NAME})

public class SettingsItemProcessor extends AbstractProcessor {

    public static final String ANNOTATION_TYPE = "com.example.SettingsItem";

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        System.out.println("Hello world from annotation");
        for (final Element field : set) {
            SettingsItem item = field.getAnnotation(SettingsItem.class);

        }
        return false;
    }
}
