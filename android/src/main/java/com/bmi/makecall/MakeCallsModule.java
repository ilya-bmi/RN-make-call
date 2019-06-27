package com.bmi.makecall;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.MapBuilder;

/**
 * {@link NativeModule} that allows JS to open the default browser
 *  for an url.
 */
public class MakeCallsModule extends ReactContextBaseJavaModule {

  ReactApplicationContext reactContext;

  public MakeCallsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "MakeCalls";
  }

  @ReactMethod
  public void call(String phoneNumber) {
    String uri = "tel:" + Uri.encode(phoneNumber);
    Intent intent = new Intent(Intent.ACTION_CALL);
    intent.setData(Uri.parse(uri));
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    this.reactContext.startActivity(intent);
  }

  @ReactMethod
  public void doublePhoneCall(String number, String secondNumber, int delay) {
  final  String  Znumber = number;
  final  String  ZsecondNumber = secondNumber;
   final  int Zdelay = delay;  
       Handler handler = new Handler(); 


    handler.postDelayed(new Runnable() {
     //    @Override 
         public void run() { 
              String uri = "tel:" + Uri.encode(ZsecondNumber);
              Intent intent = new Intent(Intent.ACTION_CALL);
              intent.setData(Uri.parse(uri));
              intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              MakeCallsModule.this.reactContext.startActivity(intent);
    //    RNImmediatePhoneCallModule.this.reactContext.startActivity(intent);
         } 
    }, Zdelay); 
 
     
      String uri = "tel:" + Uri.encode(Znumber);
      Intent intent = new Intent(Intent.ACTION_CALL);
      intent.setData(Uri.parse(uri));
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      this.reactContext.startActivity(intent);
  }

 
}