package com.sendytest.mycalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ICalcService service;
    CalcServiceConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initService();

        Button buttonAdd = (Button) findViewById(R.id.btnAdd);
        Button buttonSubtract = (Button) findViewById(R.id.btnSubtract);
        Button buttonDivide = (Button) findViewById(R.id.btnDivide);
        Button buttonMultiply = (Button) findViewById(R.id.btnMultiply);

        //add
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            EditText value1 = (EditText) findViewById(R.id.valueOne);
            EditText value2 = (EditText) findViewById(R.id.valueTwo);
            EditText result = (EditText) findViewById(R.id.valueResult);

            public void onClick(View v) {
                double v1, v2, res = -1;
                v1 = Double.parseDouble(value1.getText().toString());
                v2 = Double.parseDouble(value2.getText().toString());

                try {
                    res = service.add(v1, v2);
                } catch (RemoteException e) {

                    e.printStackTrace();
                }
                result.setText(new Double(res).toString());
            }
        });

        //subtract
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            EditText value1 = (EditText) findViewById(R.id.valueOne);
            EditText value2 = (EditText) findViewById(R.id.valueTwo);
            EditText result = (EditText) findViewById(R.id.valueResult);

            public void onClick(View v) {
                double v1, v2, res = -1;
                v1 = Double.parseDouble(value1.getText().toString());
                v2 = Double.parseDouble(value2.getText().toString());

                try {
                    res = service.subtract(v1, v2);
                } catch (RemoteException e) {

                    e.printStackTrace();
                }
                result.setText(new Double(res).toString());
            }
        });

        //multiply
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            EditText value1 = (EditText) findViewById(R.id.valueOne);
            EditText value2 = (EditText) findViewById(R.id.valueTwo);
            EditText result = (EditText) findViewById(R.id.valueResult);

            public void onClick(View v) {
                double v1, v2, res = -1;
                v1 = Double.parseDouble(value1.getText().toString());
                v2 = Double.parseDouble(value2.getText().toString());

                try {
                    res = service.mutliply(v1, v2);
                } catch (RemoteException e) {

                    e.printStackTrace();
                }
                result.setText(new Double(res).toString());
            }
        });

        //divide
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            EditText value1 = (EditText) findViewById(R.id.valueOne);
            EditText value2 = (EditText) findViewById(R.id.valueTwo);
            EditText result = (EditText) findViewById(R.id.valueResult);

            public void onClick(View v) {
                double v1=0, v2 =0, res = -1;
                if (v2 == 0){
                    Toast.makeText(getApplicationContext(),"Value 2 cannot be zero!",Toast.LENGTH_SHORT).show();
                    return;
                }
                v1 = Double.parseDouble(value1.getText().toString());
                v2 = Double.parseDouble(value2.getText().toString());

                try {
                    res = service.divide(v1, v2);
                } catch (RemoteException e) {

                    e.printStackTrace();
                }
                result.setText(new Double(res).toString());
            }
        });
    }



    @Override
    protected void onDestroy() {
        releaseService();
        super.onDestroy();
    }

    private void initService() {
        connection = new CalcServiceConnection(this);
        Intent i = new Intent();
        i.setClassName("com.sendytest.mycalcapp", com.sendytest.mycalcapp.CalcService.class.getName());
        boolean ret = bindService(i, connection, Context.BIND_AUTO_CREATE);
        Log.d("INIT", "initService() bound with " + ret);
    }

    private void releaseService() {
        unbindService(connection);
        connection = null;
        Log.d("INIT", "releaseService() unbound.");
    }
}