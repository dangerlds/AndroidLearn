package com.dangerdasheng.broadcast_network2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AnotherBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"另一个接受广播",Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
