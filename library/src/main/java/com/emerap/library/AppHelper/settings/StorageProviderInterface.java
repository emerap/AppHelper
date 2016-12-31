package com.emerap.library.AppHelper.settings;

/**
 * Created by karbunkul on 31.12.16.
 */

interface StorageProviderInterface {
    /**
     * Get value from storage provider
     *
     * @param name value name
     * @return object
     */
    Object getValue(String name, Object defaultValue, int type);

    void setValue(String param, Object object, int type);
}
