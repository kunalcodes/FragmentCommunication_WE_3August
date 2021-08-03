package com.example.fragment_communication_we;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.media.Ringtone;
import android.os.Bundle;

public class StudentDetailActivity extends AppCompatActivity implements CommunicationListener {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_main);
        launchStudentPersonalDetailsFragment();
    }

    private void launchStudentPersonalDetailsFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPersonalDetailsFragment fragment = new StudentPersonalDetailsFragment();
        fragmentTransaction.add(R.id.container, fragment, "Personal").commit();
    }

    @Override
    public void launchPerformanceFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPerformanceDetailsFragment performanceDetailsFragment = new StudentPerformanceDetailsFragment();
        performanceDetailsFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container, performanceDetailsFragment, "personalDetailsFragment").commit();
    }
}