package com.emerap.library.AppHelper.settings;

/**
 * Storage provider
 * Created by karbunkul on 31.12.16.
 */

import android.content.Context;

/**
 * Base class for storage provider
 */
abstract class StorageProvider implements StorageProviderInterface {

    final static int TYPE_INT = 0;
    final static int TYPE_BOOL = 1;
    final static int TYPE_STRING = 2;
    final static int TYPE_FLOAT = 3;

    private Context mContext;

    StorageProvider(Context context) {
    }

    protected Context getContext() {
        return mContext;
    }

    protected void setContext(Context context) {
        mContext = context;
    }
}
