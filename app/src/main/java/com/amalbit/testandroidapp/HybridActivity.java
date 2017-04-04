package com.amalbit.testandroidapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.amalbit.testandroidapp.helpers.ReactUtils;
import com.amalbit.testandroidapp.module.package1.MessageFromReactToAndroidModule;
import com.amalbit.testandroidapp.module.package1.TestPackage;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;

public class HybridActivity extends BaseReactActivity  implements MessageFromReactToAndroidModule.ReactEmmiter {

  private ReactRootView mReactRootView;

  private EditText edtMessageToReact;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mReactInstanceManager = ReactInstanceManager.builder()
        .setApplication(getApplication())
        .setBundleAssetName("index.android.bundle")
        .setJSMainModuleName("index.android")
        .addPackage(new MainReactPackage())
        .addPackage(new TestPackage(this))
        .setUseDeveloperSupport(BuildConfig.DEBUG)
        .setInitialLifecycleState(LifecycleState.RESUMED)
        .build();

    mReactRootView = (ReactRootView) findViewById(R.id.root_react);
    mReactRootView.startReactApplication(mReactInstanceManager, "HelloWorld", null);

    edtMessageToReact = (EditText) findViewById(R.id.edt_messenger);

    edtMessageToReact.addTextChangedListener(new TextWatcher() {

      @Override
      public void afterTextChanged(Editable s) {}

      @Override
      public void beforeTextChanged(CharSequence s, int start,
          int count, int after) {
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        WritableMap params = Arguments.createMap();
        params.putString("message", s.toString());
        ReactUtils.sendEvent(mReactInstanceManager.getCurrentReactContext(), "from_android", params);
      }
    });
  }

  public void onReceive(final String msg){
    new Handler(Looper.getMainLooper()).post(new Runnable() {
      @Override
      public void run() {
        edtMessageToReact.setText(msg);
      }
    });
  }

}
