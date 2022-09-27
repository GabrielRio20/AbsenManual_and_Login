package com.example.absenmanuallogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

public class SampleAdapter extends FragmentStateAdapter {


    public SampleAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0){
            LoginFragment1 fragment1 = new LoginFragment1();
            return fragment1;
        }

        else{
            LoginFragment2 fragment2 = new LoginFragment2();
            return fragment2;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}