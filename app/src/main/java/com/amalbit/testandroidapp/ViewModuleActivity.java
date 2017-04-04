package com.amalbit.testandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.amalbit.testandroidapp.callback.CallbackPackage;
import com.amalbit.testandroidapp.viewmodule.CustomUIPackage;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;

public class ViewModuleActivity extends BaseReactActivity {

    private ReactRootView mReactRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_module);

        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .addPackage(new CustomUIPackage(this))
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();

        mReactRootView = (ReactRootView) findViewById(R.id.root_react);
        mReactRootView.startReactApplication(mReactInstanceManager, "NativeModuleUI", null);
    }
}
