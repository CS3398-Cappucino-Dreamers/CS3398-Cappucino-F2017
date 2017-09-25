package com.example.ben.fitordie.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.ben.fitordie.R;

public class LoginActivity extends AppCompatActivity {


    private TextView signUpText; // Sign Up Text that will be clickable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_or_die);

        signUpText = (TextView) findViewById(R.id.signUp);

    }


    /**
     * This method will send a user to the sign up activity if the sign up button is clicked
     *
     */
    public void goToSignUpActivity(){
        
    }


}
