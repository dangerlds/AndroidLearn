package com.dangerdasheng.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    String tag = FirstActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this,"button1 click",
                        Toast.LENGTH_SHORT).show();
            }
        });
        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button button3 = (Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,
                        SecondActivity.class);

                startActivity(intent);

            }
        });
        Button button4 = (Button)findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.dangerdasheng.activitytest" +
                        ".ACTION_START");
                intent.addCategory("com.dangerdasheng.activitytest" +
                        ".MY_CATEGORY");
                startActivity(intent);

            }
        });
        Button button5 = (Button)findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        Button button6 = (Button)findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
        Button button7 = (Button)findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String data = "hello second";
                Intent intent = new Intent(FirstActivity.this,
                        SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });

        Button button8 = (Button)findViewById(R.id.button_8);
        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String data = "hello second";
                Intent intent = new Intent(FirstActivity.this,
                        SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivityForResult(intent,1);
            }
        });

        Log.d(tag,this.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"click add",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.rmeove_item:
                Toast.makeText(this,"click remove",
                        Toast.LENGTH_SHORT).show();
                break;
                default:

        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d(tag,returnedData);
                }
                break;
                default:
        }
    }
}
