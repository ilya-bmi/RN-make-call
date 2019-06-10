
package com.github.wumke.RNImmediatePhoneCall;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNImmediatePhoneCallModule extends ReactContextBaseJavaModule {

    private static RNImmediatePhoneCallModule rnImmediatePhoneCallModule;

    private ReactApplicationContext reactContext;
    private static String number = "";
      private static String secondNumber = "";
      private static int delay = 5000;
    private static final int PERMISSIONS_REQUEST_ACCESS_CALL = 101;

    public RNImmediatePhoneCallModule(ReactApplicationContext reactContext) {
        super(reactContext);
        if (rnImmediatePhoneCallModule == null) {
            rnImmediatePhoneCallModule = this;
        }
        rnImmediatePhoneCallModule.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNImmediatePhoneCall";
    }

	//@SuppressLint("MissingPermission")
    public void call() {
        String url = "tel:" + RNImmediatePhoneCallModule.number;
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        rnImmediatePhoneCallModule.reactContext.startActivity(intent);
    }


 @ReactMethod
    public void doubleCall() {

 Handler handler = new Handler(); 


    handler.postDelayed(new Runnable() {
         @Override 
         public void run() { 
        String url = "tel:" + RNImmediatePhoneCallModule.secondNumber;
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        RNImmediatePhoneCallModule.this.reactContext.startActivity(intent);
         } 
    }, RNImmediatePhoneCallModule.delay); 

        String url = "tel:" + RNImmediatePhoneCallModule.number;
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        RNImmediatePhoneCallModule.this.reactContext.startActivity(intent);
        

    }

   @ReactMethod
    public void doublePhoneCall(String number, String secondNumber, int delay) {
    //public void doublePhoneCall(String number, String secondNumber) {
        RNImmediatePhoneCallModule.number =  Uri.encode(number);
        RNImmediatePhoneCallModule.secondNumber = Uri.encode(secondNumber);
        RNImmediatePhoneCallModule.delay = delay;
            doubleCall();
    
    }
	


    @ReactMethod
    public void immediatePhoneCall(String number) {
  //  public void immediatePhoneCall(String number) {
       // RNImmediatePhoneCallModule.number = Uri.encode(number);
        String url = "tel:" + Uri.encode(number);
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        rnImmediatePhoneCallModule.reactContext.startActivity(intent);
    }
	


    public static void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_CALL: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                 //   call();
                }
            }
        }
    }
}