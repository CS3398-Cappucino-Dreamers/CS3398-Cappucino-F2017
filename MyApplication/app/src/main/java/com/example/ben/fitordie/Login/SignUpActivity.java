package com.example.ben.fitordie.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONObject;
import android.os.AsyncTask;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;


import com.example.ben.fitordie.R;

public class SignUpActivity extends AppCompatActivity {
    private Button AccountButton;
    private EditText emailField;
    private EditText passwordField;
    private EditText usernameField;
    private EditText confirmField;
    private String test;
    private static final int CODE_POST_REQUEST = 1025;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Sets the toolbar as the app bar for the activity.
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        AccountButton = (Button)findViewById(R.id.createAccountBtn);
        emailField = (EditText)findViewById(R.id.emailAddress);
        passwordField = (EditText)findViewById(R.id.passwordOne);
        usernameField = (EditText)findViewById(R.id.newUsername);
        confirmField = (EditText)findViewById(R.id.passwordConfirm);

        AccountButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.createAccountBtn:
                        if (!validate())
                            Toast.makeText(getBaseContext(), "Fill out each field", Toast.LENGTH_LONG).show();
                            // call AsynTask to perform network operation on separate thread
                        else{
                            createUser("http://192.168.50.27:80/FitOrDieApi/v1/Api.php?apicall=addUser", emailField.getText().toString().trim(), passwordField.getText().toString().trim(), usernameField.getText().toString().trim());
                        }

                        break;
                }
            }
        });

    }
    public void goToMainPageActivity(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    private boolean validate(){
        if(emailField.getText().toString().trim().equals(""))
            return false;
        else if(passwordField.getText().toString().trim().equals("") || confirmField.getText().toString().trim().equals("")  || !confirmField.getText().toString().equals(passwordField.getText().toString()))
            return false;
        else if(usernameField.getText().toString().trim().equals(""))
            return false;
        else
            return true;
    }

    public void createUser(String urlString, String email, String password, String username){


        HashMap<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("email", email);
        params.put("password", password);

        PerformNetworkRequest request = new PerformNetworkRequest(urlString, params, CODE_POST_REQUEST);
        request.execute();

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


//            if (requestCode == CODE_GET_REQUEST)
//                return requestHandler.sendGetRequest(url);

            return null;
        }
    }

}
