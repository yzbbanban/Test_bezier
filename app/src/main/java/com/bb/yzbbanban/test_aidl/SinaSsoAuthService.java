package com.bb.yzbbanban.test_aidl;

import android.app.*;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by YZBbanban on 2017/7/10.
 */

public class SinaSsoAuthService extends Service {
    private static final String TAG = "SinaSsoAuthService";
    private SinaSsoImpl sso = new SinaSsoImpl();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return sso;
    }

    class SinaSsoImpl extends SsoAuth.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void ssoAuth(String name, String password) throws RemoteException {
            Log.i(TAG, "ssoAuth: name: " + name + " pwd: " + password);
        }
    }
}
