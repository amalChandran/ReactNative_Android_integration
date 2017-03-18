package com.amalbit.testandroidapp.module.package1;

import android.widget.Toast;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amal.chandran on 16/03/17.
 * As per react doc.
 */

public class MessageFromReactToAndroidModule extends ReactContextBaseJavaModule {

  private static final String DURATION_SHORT_KEY = "SHORT";
  private static final String DURATION_LONG_KEY = "LONG";

  private ReactEmmiter reactEmmiter;

  public MessageFromReactToAndroidModule(ReactApplicationContext reactContext, ReactEmmiter reactEmmiter) {
    super(reactContext);
    this.reactEmmiter = reactEmmiter;
  }

  /**
   * The purpose of this method is to return the string name of the NativeModule which
   * represents this class in JavaScript. So here we will call this ToastAndroid so that we can
   * access it through React.NativeModules.ToastAndroid in JavaScript.
   * **/
  @Override public String getName() {
    return "MessageFromReact";
  }

  /**
   * An optional method called getConstants returns the constant values exposed to JavaScript.
   * Its implementation is not required but is very useful to key pre-defined values that need to
   * be communicated from JavaScript to Java in sync
   * **/
  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();
    constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
    constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
    return constants;
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
   * **/
  @ReactMethod
  public void send(String message) {
    reactEmmiter.onReceive(message);
  }

  public interface ReactEmmiter {
    void onReceive(String msg);
  }
}
