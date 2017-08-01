package com.rg.gabrielguedes.moeexample.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


import com.example.models.RandomUser;
import com.rg.gabrielguedes.moeexample.R;
import com.rg.gabrielguedes.moeexample.databinding.ActivityRandomUserDetailBinding;

import static com.example.Constants.RANDOM_USER;
import static com.example.Constants.TOOLBAR_TITLE;

public class RandomUserDetailActivity extends AppCompatActivity {

    private RandomUser mRandomUser;
    private boolean hasNewData = false;
    private ActivityRandomUserDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_random_user_detail);
        final Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        mRandomUser = (RandomUser) bundle.getSerializable(RANDOM_USER);
        binding.setRandomuser(mRandomUser);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(intent.getStringExtra(TOOLBAR_TITLE));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.random_user_detail_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
