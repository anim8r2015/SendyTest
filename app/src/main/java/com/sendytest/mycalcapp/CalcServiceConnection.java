package com.sendytest.mycalcapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class CalcServiceConnection implements ServiceConnection {
    ICalcService service;
    CalcServiceConnection connection;
    Context currContext;
    public CalcServiceConnection(Context ctx){
        this.currContext = ctx;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        service = (IBinder) ICalcService.Stub.asInterface((IBinder) service);
        Log.d("TEst", "onServiceConnected() connected");
        Toast.makeText(currContext, "Service connected", Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        service = null;
        Log.d("TEst", "onServiceDisconnected() disconnected");
        Toast.makeText(currContext, "Service connected", Toast.LENGTH_LONG)
                .show();
    }


}
