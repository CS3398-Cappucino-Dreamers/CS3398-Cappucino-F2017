package com.example.ben.fitordie.Login;

import android.content.Intent;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ben.fitordie.Login.swipeviews.LoginFragmentPagerAdapter;
import com.example.ben.fitordie.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Allows users to login to the app or go to a sign-up activity. The top half of the activity
 * is scrollable pages that allows users to discover more about our app. (info about it)
 */
public class LoginActivity extends AppCompatActivity {

    private ViewPager mPager; // For swiping between fragments
    private LoginFragmentPagerAdapter mAdapter; // represents each page as a Fragment
    private TextView signUpText; // Sign Up Text that will be clickable
    private Button loginButton; // Logs you in and takes you to the homepage
    private EditText emailField; // username field of the user
    private EditText passwordField;
    private static final int CODE_POST_REQUEST = 1025;


    private LevelListDrawable layerDrawable; // contains all the dots Images
    private ImageView dotsImg; // ImageView whose src is the levelListDrawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_or_die);

        loginButton = (Button)findViewById(R.id.loginBtn);
        emailField = (EditText)findViewById(R.id.email);
        passwordField = (EditText)findViewById(R.id.password);

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

    public void goToMainPageActivity(){
        Intent intent = new Intent(this, HomePage.class);
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

        // Simulates user logging in by fetching the name from the editText and sleeping the main
        // thread for a second. Then goes to the mainPage with an intent
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(!validate())
                    {
                        Toast.makeText(getBaseContext(), "Fill out each field", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        authUser("http://192.168.50.27:80/FitOrDieApi/v1/Api.php?apicall=authUser", emailField.getText().toString().trim(), passwordField.getText().toString().trim());
                    }

            }
        });

    }

    public void authUser(String urlString, String email, String password){


        HashMap<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);

        PerformNetworkRequest request = new PerformNetworkRequest(urlString, params, CODE_POST_REQUEST);
        request.execute();

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

    private boolean validate(){
        if(emailField.getText().toString().trim().equals(""))
            return false;
        else if(passwordField.getText().toString().trim().equals(""))
            return false;
        else
            return true;
    }

    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;
        int requestCode;

        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")) {
                    goToMainPageActivity();
                }
                Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST)
                return requestHandler.sendPostRequest(url, params);


            return null;
        }
    }



}
