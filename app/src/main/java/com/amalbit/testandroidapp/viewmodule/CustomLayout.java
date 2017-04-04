package com.amalbit.testandroidapp.viewmodule;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.amalbit.testandroidapp.R;

/**
 * Created by amal.chandran on 21/03/17.
 */

public class CustomLayout extends ViewGroup {
    public CustomLayout(Context context) {
        super(context);
        initView();
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
    }

    private void initView() {
        View view = inflate(getContext(), R.layout.my_view_layout, null);
        addView(view);
    }
}
