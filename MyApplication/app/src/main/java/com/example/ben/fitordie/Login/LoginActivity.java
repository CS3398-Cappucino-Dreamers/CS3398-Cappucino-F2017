package com.example.ben.fitordie.Login;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

        initializeListeners();

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


}
