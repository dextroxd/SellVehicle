package com.dextroxd.sellvehicle.Login_and_signup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dextroxd.sellvehicle.activities.MainActivity;
import com.dextroxd.sellvehicle.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

public class SignUpActivity extends AppCompatActivity {
    Button signup_button;
    EditText name_text;
    EditText password_text;
    EditText city_text;
    private FirebaseAuth mAuth;
   private GoogleSignInClient googleSignInClient;
    EditText email_text;
    ImageView fb_button;
    Button google_login;
    ImageView google_button;
    TextView login_link;
    CallbackManager callbackManager;
    private static final int RC_SIGN_IN = 007;
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
        login_link = findViewById(R.id.link_login);
        google_button=findViewById(R.id.btn_google);
        google_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .build();
                googleSignInClient = GoogleSignIn.getClient(SignUpActivity.this, gso);
                signIn();
            }
        });

        login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                finish();
            }
        });
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
    private void signIn() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case 007:
                    try {
                        // The Task returned from this call is always completed, no need to attach
                        // a listener.
                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                        GoogleSignInAccount account = task.getResult(ApiException.class);
                        updateUI(account);
                    } catch (ApiException e) {
                        // The ApiException status code indicates the detailed failure reason.
                        Log.w("status", "signInResult:failed code=" + e.getStatusCode());
                    }
                    break;
            }

            callbackManager.onActivityResult(requestCode, resultCode, data);


    }
    @Override
    public void onStart() {
        super.onStart();
        GoogleSignInAccount alreadyloggedAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (alreadyloggedAccount != null) {
            Toast.makeText(this, "Already Logged In", Toast.LENGTH_SHORT).show();
            updateUI(alreadyloggedAccount);
        } else {
            Log.d("status", "Not logged in");
        }
    }
    private void updateUI(GoogleSignInAccount googleSignInAccount) {
        Intent in=new Intent(SignUpActivity.this, MainActivity.class);
//        email=inputEmail.getText().toString();
//        in.putExtra("data",email);
//        flag=true;
//        in.putExtra("flag",flag);
        startActivity(in);
        finish();
    }
}

