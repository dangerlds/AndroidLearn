package com.dangerdasheng.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    String tag = SecondActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        if (data != null){
            Log.d(tag,data);
        }


        Button button = (Button)findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                returnData();
            }
        });

        Button button2 = (Button)findViewById(R.id.button_3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,
                        ThirdAcitivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {

        this.returnData();
    }
    void returnData(){
        Intent intent = new Intent();
        intent.putExtra("data_return","hello first");
        setResult(RESULT_OK,intent);
        finish();
    }
}
