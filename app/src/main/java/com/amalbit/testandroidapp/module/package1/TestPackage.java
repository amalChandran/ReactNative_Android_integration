package com.amalbit.testandroidapp.module.package1;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by amal.chandran on 16/03/17.
 */

public class TestPackage implements ReactPackage {

  private MessageFromReactToAndroidModule.ReactEmmiter mReactEmmiter;

  public TestPackage(MessageFromReactToAndroidModule.ReactEmmiter reactEmmiter){
    mReactEmmiter = reactEmmiter;
  }

  @Override
  public List<Class<? extends JavaScriptModule>> createJSModules() {
    return Collections.emptyList();
  }

  @Override
  public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
    return Collections.emptyList();
  }

  @Override
  public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
    List<NativeModule> modules = new ArrayList<>();

    modules.add(new ToastOneModule(reactContext));
    modules.add(new MessageFromReactToAndroidModule(reactContext, mReactEmmiter));

    return modules;
  }

}
