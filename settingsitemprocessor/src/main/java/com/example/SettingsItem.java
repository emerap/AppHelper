package com.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by karbunkul on 10.01.2017.
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface SettingsItem {
    String name();
}
