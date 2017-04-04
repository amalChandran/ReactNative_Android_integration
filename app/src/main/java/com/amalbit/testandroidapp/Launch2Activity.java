package com.amalbit.testandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Launch2Activity extends AppCompatActivity implements View.OnClickListener{

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_launch2);

    ((Button)findViewById(R.id.btn_partial_screen)).setOnClickListener(this);
    ((Button)findViewById(R.id.btn_callbacks)).setOnClickListener(this);
    ((Button)findViewById(R.id.btn_module_view)).setOnClickListener(this);
  }

  @Override public void onClick(View view) {
     switch (view.getId()){
       case R.id.btn_callbacks:
         Intent intent1 = new Intent(Launch2Activity.this, ReactCallBackActivity.class);
         startActivity(intent1);
         break;
       case R.id.btn_partial_screen:
         Intent intent = new Intent(Launch2Activity.this, HybridActivity.class);
         startActivity(intent);
         break;
       case R.id.btn_module_view:
         Intent intent2 = new Intent(Launch2Activity.this, ViewModuleActivity.class);
         startActivity(intent2);
         break;
     }
  }
}
