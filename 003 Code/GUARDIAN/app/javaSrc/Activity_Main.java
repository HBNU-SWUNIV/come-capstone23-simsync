package com.mcuhq.simplebluetooth2;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Activity_Main extends AppCompatActivity {

    SharedViewModel viewModel;

    BottomNavigationView bottomNav;
    com.mcuhq.simplebluetooth2.HomeFragment homeFragment = new com.mcuhq.simplebluetooth2.HomeFragment();

    private Fragment home, summary, arrF, workout, profile;
    FragmentManager fragmentManager;

    @SuppressLint("BatteryLife")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 화면 자동 꺼짐 방지
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        bottomNav = findViewById(R.id.bottom_navigation);
        fragmentManager = getSupportFragmentManager();

        // Start Fragment
        home = new HomeFragment();
        fragmentManager.beginTransaction().replace(R.id.main_frame, home).commit(); //FrameLayout에 fragment.xml 띄우기

        // 바텀 네비게이션 버튼 클릭 시 프래그먼트 전환
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.bottom_home:
                        if(home == null) {
                            home = new HomeFragment();
                            fragmentManager.beginTransaction().add(R.id.main_frame, home).commit();
                        }

                        if(home != null) fragmentManager.beginTransaction().show(home).commit();
                        if(summary != null) fragmentManager.beginTransaction().hide(summary).commit();
                        if(arrF != null) fragmentManager.beginTransaction().hide(arrF).commit();
                        if(workout != null) fragmentManager.beginTransaction().hide(workout).commit();
                        if(profile != null) fragmentManager.beginTransaction().hide(profile).commit();

                        break;

                    case R.id.bottom_summary:
                        if(summary == null) {
                            summary = new SummaryFragment();
                            fragmentManager.beginTransaction().add(R.id.main_frame, summary).commit();
                        }

                        if(home != null) fragmentManager.beginTransaction().hide(home).commit();
                        if(summary != null) fragmentManager.beginTransaction().show(summary).commit();
                        if(arrF != null) fragmentManager.beginTransaction().hide(arrF).commit();
                        if(workout != null) fragmentManager.beginTransaction().hide(workout).commit();
                        if(profile != null) fragmentManager.beginTransaction().hide(profile).commit();


                        viewModel = new ViewModelProvider(Activity_Main.this).get(SharedViewModel.class);
                        viewModel.setSummaryRefreshCheck(true);

                        break;
                    case R.id.bottom_arr:
                        if(arrF == null) {
                            arrF = new ArrFragment();
                            fragmentManager.beginTransaction().add(R.id.main_frame, arrF).commit();
                        }

                        if(home != null) fragmentManager.beginTransaction().hide(home).commit();
                        if(summary != null) fragmentManager.beginTransaction().hide(summary).commit();
                        if(arrF != null) fragmentManager.beginTransaction().show(arrF).commit();
                        if(workout != null) fragmentManager.beginTransaction().hide(workout).commit();
                        if(profile != null) fragmentManager.beginTransaction().hide(profile).commit();

                        break;

                    case R.id.bottom_profile:
                        if(profile == null) {
                            profile = new ProfileFragment();
                            fragmentManager.beginTransaction().add(R.id.main_frame, profile).commit();
                        }

                        if(home != null) fragmentManager.beginTransaction().hide(home).commit();
                        if(summary != null) fragmentManager.beginTransaction().hide(summary).commit();
                        if(arrF != null) fragmentManager.beginTransaction().hide(arrF).commit();
                        if(workout != null) fragmentManager.beginTransaction().hide(workout).commit();
                        if(profile != null) fragmentManager.beginTransaction().show(profile).commit();

                        break;
                }
                return true;
            }
        });

//        setNoti();
    }

//    private void setNoti(){
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel(
//                    getString(R.string.default_notification_channel_id),
//                    "Channel human readable title",
//                    NotificationManager.IMPORTANCE_DEFAULT);
//
//            NotificationManager notificationManager = getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(channel);
//        }
//    }

}