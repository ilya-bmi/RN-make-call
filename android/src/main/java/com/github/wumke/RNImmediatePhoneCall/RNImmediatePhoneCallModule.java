package com.github.wumke.RNImmediatePhoneCall;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import android.os.Handler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RNImmediatePhoneCallModule extends ReactContextBaseJavaModule {

    ReactApplicationContext reactContext;
    AlarmManager alarmManager;

    public RNImmediatePhoneCallModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        alarmManager = (AlarmManager) reactContext.getSystemService(Context.ALARM_SERVICE);
    }

    @Override
    public String getName() {
        return "RNImmediatePhoneCall";
    }

    @ReactMethod
    public void doublePhoneCall(String number, String secondNumber) {
 final String num = secondNumber;
 Handler handler = new Handler(); 


    handler.postDelayed(new Runnable() {
         @Override 
         public void run() { 
        String uriNum = Uri.encode(num);
        String url = "tel:" + uriNum;
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        RNImmediatePhoneCallModule.this.reactContext.startActivity(intent);
         } 
    }, 6000); 
String uriNum = Uri.encode("12345");
        String url = "tel:" + uriNum;
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        RNImmediatePhoneCallModule.this.reactContext.startActivity(intent);
        

    }

        @ReactMethod
    public void immediatePhoneCall(String number) {
        number = Uri.encode(number);
        String url = "tel:" + number;
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.reactContext.startActivity(intent);
    }
}
