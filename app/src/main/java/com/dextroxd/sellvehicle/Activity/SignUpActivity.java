package com.dextroxd.sellvehicle.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.dextroxd.sellvehicle.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignUpActivity extends AppCompatActivity {
    Button signup_button;
    EditText name_text;
    EditText password_text;
    EditText city_text;
    EditText email_text;
    Button fb_button;
    Button google_button;
    TextView login_link;

    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
//        final TextView login_link=(TextView)findViewById(R.id.link_login);
        callbackManager = CallbackManager.Factory.create();

//        login_link.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent in =new Intent(SignUpActivity.this,LoginActivity.class);
//                startActivity(in);
//            }
//        });
        fb_button = findViewById(R.id.btn_fb);
        fb_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LoginManager.getInstance().logInWithReadPermissions(SignUpActivity.this, Arrays.asList("public_profile"));
                LoginManager.getInstance().registerCallback(callbackManager,
                        new FacebookCallback<LoginResult>() {
                            @Override
                            public void onSuccess(LoginResult loginResult) {
                                // App code
                                Toast.makeText(SignUpActivity.this,loginResult.getAccessToken().getUserId().toString(),Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }

                            @Override
                            public void onCancel() {
                                // App code
                                Toast.makeText(SignUpActivity.this,"Cancel",Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onError(FacebookException exception) {
                                // App code
                                Toast.makeText(SignUpActivity.this,"Error",Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
   public void onSignup(View v){
        if(v.getId()==R.id.btn_signup)
        {
            EditText name_text=(EditText)findViewById(R.id.input_name);
            EditText password_text=(EditText)findViewById(R.id.input_password);
            EditText phone_text=(EditText)findViewById(R.id.input_phone);
            EditText email_text=(EditText)findViewById(R.id.input_email);


            String nameattr=name_text.getText().toString();
            String emailattr=email_text.getText().toString();
            String phoneattr=phone_text.getText().toString();
            String passatr=password_text.getText().toString();

            if(nameattr.matches("") || emailattr.matches("")|| phoneattr.matches("")||passatr.matches(""))
            {
                Toast toast=Toast.makeText(SignUpActivity.this,"Please Enter Details",Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                Toast toast=Toast.makeText(SignUpActivity.this,"Successful Sign Up",Toast.LENGTH_SHORT);
                toast.show();
                Intent in = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(in);
            }

        }


   }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}

