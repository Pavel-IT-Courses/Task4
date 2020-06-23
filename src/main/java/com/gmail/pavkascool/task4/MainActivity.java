package com.gmail.pavkascool.task4;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gmail.pavkascool.task4.fragment.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentById(R.id.container) == null) {
            Fragment listFragment = new DogListFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, listFragment).commit();
        }
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment current = fragmentManager.findFragmentById(R.id.container);
                if (!(current instanceof AddDogFragment)) {
                    Fragment addFragment = new AddDogFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, addFragment).addToBackStack("").commit();

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment current = fragmentManager.findFragmentById(R.id.container);
            if (!(current instanceof SettingFragment)) {
                Fragment settingFragment = new SettingFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, settingFragment).addToBackStack("").commit();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
