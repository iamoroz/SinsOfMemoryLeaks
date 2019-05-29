package com.franktan.memoryleakexamples.viastaticreference;

import android.content.Context;

/**
 * Created by frank.tan on 2/11/17.
 */

public final class SomeSingletonManager {

    private static SomeSingletonManager someSingletonManagerSingleton;
    private Context context;

    private SomeSingletonManager(final Context context) {
        this.context = context;
    }

    static synchronized SomeSingletonManager getInstance(final Context context) {
        if (someSingletonManagerSingleton == null) {
            someSingletonManagerSingleton = new SomeSingletonManager(context);
        }
        return someSingletonManagerSingleton;
    }

    public void unregister(final Context context) {
        if (this.context == context) {
            this.context = null;
        }
    }
}
