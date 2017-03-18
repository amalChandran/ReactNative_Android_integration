package com.amalbit.testandroidapp.callback;

import android.os.Handler;
import android.widget.Toast;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amal.chandran on 16/03/17.
 */
public class CallbackModule extends ReactContextBaseJavaModule {

  /**
   * Wait time before returning the callback.
   * **/
  private static final String DURATION_WAIT_TIME = "WAIT_TIME";


  public CallbackModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  /**
   * The purpose of this method is to return the string name of the NativeModule which
   * represents this class in JavaScript. So here we will call this ToastAndroid so that we can
   * access it through React.NativeModules.ToastAndroid in JavaScript.
   * **/
  @Override public String getName() {
    return "CallbackAndroid";
  }



  /**
   * To expose a method to JavaScript a Java method must be annotated using @ReactMethod.
   * The return type of bridge methods is always void. React Native bridge is asynchronous,
   * so the only way to pass a result to JavaScript is by using callbacks or emitting events
   *
   * Supported Argument types:
   * Boolean -> Bool
   * Integer -> Number
   * Double -> Number
   * Float -> Number
   * String -> String
   * Callback -> function
   * ReadableMap -> Object
   * ReadableArray -> Array
   *
   *
   *
   * **/
  @ReactMethod
  public void waitOnAndroidAndCallback(final int duration, final Callback callback) {

    if (callback == null) return;

    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        callback.invoke("You just waited on android for " + duration + " seconds.");
      }
    }, duration);
  }
}
