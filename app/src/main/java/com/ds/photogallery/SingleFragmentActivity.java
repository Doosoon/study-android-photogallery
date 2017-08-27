package com.ds.photogallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by doosoon on 2017-08-26.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    private static final String TAG = "SingleFramentActivity";

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate called before setContentView!!!");
        setContentView(R.layout.activity_single_fragment);
        Log.d(TAG, "onCreate called after setContentView!!!");

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            Log.d(TAG, "new CrimeFragment!!!");
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
            Log.d(TAG, "End of transaction of new Fragment!!!");
        }
    }

}
