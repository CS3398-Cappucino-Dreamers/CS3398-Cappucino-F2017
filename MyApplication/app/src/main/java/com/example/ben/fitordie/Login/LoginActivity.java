package com.example.ben.fitordie.Login;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.nfc.Tag;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ben.fitordie.Login.SwipeViews.LoginFragmentPagerAdapter;
import com.example.ben.fitordie.R;

/**
 * Allows users to login to the app or go to a sign-up activity. The top half of the activity
 * is scrollable pages that allows users to discover more about our app. (info about it)
 */
public class LoginActivity extends AppCompatActivity {

    private ViewPager mPager; // For swiping between fragments
    private LoginFragmentPagerAdapter mAdapter; // represents each page as a Fragment
    private TextView signUpText; // Sign Up Text that will be clickable



    private LevelListDrawable layerDrawable; // contains all the dots Images
    private ImageView dotsImg; // ImageView whose src is the levelListDrawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_or_die);

        signUpText = (TextView) findViewById(R.id.signUp);

        // Custom FragmentPagerAdapter is set to ViewPager to manage fragment instances
        mAdapter = new LoginFragmentPagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager)findViewById(R.id.viewPager);
        mPager.setAdapter(mAdapter);

        setPageListener(); // sets the page scroll listener for the ViewPager
        initializeListeners(); // For views on the page

        // dots that show you what page you are on
        dotsImg = (ImageView)findViewById(R.id.dots);
        layerDrawable = (LevelListDrawable) dotsImg.getDrawable();

    }


    /**
     * This method will send a user to the sign up activity if the sign up button is clicked
     *
     */
    public void goToSignUpActivity(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    /**
     * Initializes button and textview listeners
     */
    public void initializeListeners(){
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignUpActivity();
            }
        });

    }

    public void setPageListener(){
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("TAG", "onPageSelected: " + position);
                mPager.setCurrentItem(position); // change fragment
                layerDrawable.setLevel(position); // change dots image
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
