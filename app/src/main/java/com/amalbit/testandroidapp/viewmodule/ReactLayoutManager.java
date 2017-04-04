package com.amalbit.testandroidapp.viewmodule;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

/**
 * Created by amal.chandran on 21/03/17.
 */

public class ReactLayoutManager extends SimpleViewManager<ViewGroup> {
    public static final String REACT_CLASS = "RCTCustomView";

    private final @Nullable Context mCallerContext;

    public ReactLayoutManager( Context callerContext) {
        mCallerContext = callerContext;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public ViewGroup createViewInstance(ThemedReactContext context) {
        return new CustomLayout(mCallerContext);
    }
}
