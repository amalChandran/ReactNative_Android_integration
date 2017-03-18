package com.amalbit.testandroidapp;

import android.os.Bundle;
import com.amalbit.testandroidapp.callback.CallbackPackage;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;

public class ReactCallBackActivity extends BaseReactActivity {

  private ReactRootView mReactRootView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_react_call_back);

    mReactInstanceManager = ReactInstanceManager.builder()
        .setApplication(getApplication())
        .setBundleAssetName("index.android.bundle")
        .setJSMainModuleName("index.android")
        .addPackage(new MainReactPackage())
        .addPackage(new CallbackPackage())
        .setUseDeveloperSupport(BuildConfig.DEBUG)
        .setInitialLifecycleState(LifecycleState.RESUMED)
        .build();

    mReactRootView = (ReactRootView) findViewById(R.id.root_react);
    mReactRootView.startReactApplication(mReactInstanceManager, "CallbackUI", null);
  }
}
