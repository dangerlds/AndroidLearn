package com.dangerdasheng.fragmenttest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RightFragment rightFragment;
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
//        if (rightFragment == null){
//            synchronized (RightFragment.class){
//                if (rightFragment == null){
//                    rightFragment = new RightFragment();
//                }
//            }
//        }
//        Bundle bundle = new Bundle();
//        rightFragment.setArguments(bundle);


//        replaceFragment(rightFragment);

    }



    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button:
//                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

//    private void replaceFragment(Fragment fragment){
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.right_layout,fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}
