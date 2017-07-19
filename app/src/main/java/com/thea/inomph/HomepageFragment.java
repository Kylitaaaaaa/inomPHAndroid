package com.thea.inomph;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class HomepageFragment extends Fragment {

    private View currView;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;


    int currItem = 0;



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Inom PH");

        viewPager = (ViewPager) currView.findViewById( R.id.homeViewPager);

        viewPagerAdapter = new ViewPagerAdapter(currView.getContext());

        viewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
    }

    public class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(currItem == 0)
                        currItem = 1;
                    else if(currItem == viewPagerAdapter.getCount()-1)
                        currItem = 0;
                    else
                        currItem++;
                    viewPager.setCurrentItem(currItem);

                }
            });
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currView =inflater.inflate(R.layout.activity_homepage_fragment, container, false);

        return currView;
    }

    @Override
    public void onStart() {
        super.onStart();




    }


}
