package com.sendytest.mycalcapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class CalcService extends Service {
    String TAG = "Calcs";
    public CalcService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new ICalcService.Stub() {
            /**
             * Implementation of the add() method
             */
            public double add(double value1, double value2) throws RemoteException {
                Log.d(TAG, String.format("CalcService.add(%d, %d)",value1, value2));
                return value1 + value2;
            }

            @Override
            public double subtract(double value1, double value2) throws RemoteException {
                return value1 - value2;
            }

            @Override
            public double divide(double value1, double value2) throws RemoteException {
                return value1/value2;
            }

            @Override
            public double mutliply(double value1, double value2) throws RemoteException {
                return value1*value2;
            }

        };
    }
}