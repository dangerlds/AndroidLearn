package com.dangerdasheng.broadcast_network;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "NetWorkInfo";
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        networkChangeReceiver = new NetworkChangeReceiver();
//        registerReceiver(networkChangeReceiver,intentFilter);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);


        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"发送广播",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("com.dangerdasheng" +
                        ".broadcast_network.MY_BROADCAST");
//                intent.setComponent(new ComponentName(MainActivity.this,
//                        MyBroadcastReceiver.class));
                intent.addFlags(0x01000000);
//                sendBroadcast(intent, null);
                sendOrderedBroadcast(intent,null);
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.dangerdasheng" +
                        ".broadcast_network.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.dangerdasheng.broadcast_network" +
                ".LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }


    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            try {


                ConnectivityManager mConnectivityManager =
                        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                if (Build.VERSION.SDK_INT >= 23) {
                    Log.i(TAG,"大于23");
                    //获取网络属性
                    NetworkCapabilities networkCapabilities = mConnectivityManager.getNetworkCapabilities(mConnectivityManager.getActiveNetwork());
                    if (networkCapabilities != null) {
                        Log.i(TAG,"000");
                        Log.i(TAG, String.valueOf(networkCapabilities));
                        if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
                            Log.i(TAG, "联网了!");
                            Log.i(TAG,"111");
                        } else {
                            Log.i(TAG, "断网了");
                            Log.i(TAG,"222");
                        }
                        Log.i(TAG,
                                String.valueOf(networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)));
                    }else{
                        Log.i(TAG,"333");
                        Log.i(TAG, String.valueOf(networkCapabilities));
                    }
                } else {
                    NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
                    if (mNetworkInfo != null) {
                        if (mNetworkInfo.isConnected()) {
                            Log.i(TAG, "联网了!");
                        } else {
                            Log.i(TAG, "断网了");
                        }
                    }
                }
            }catch (Exception e){

            }

        }
    }

    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"received local broadcast",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
