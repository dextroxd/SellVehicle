package com.dextroxd.sellvehicle.login_and_signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dextroxd.sellvehicle.activities.MainActivity;
import com.dextroxd.sellvehicle.R;
import com.dextroxd.sellvehicle.login_and_signup.network.ApiInterface;
import com.dextroxd.sellvehicle.login_and_signup.network.ApiUtils;
import com.dextroxd.sellvehicle.login_and_signup.network.model.Response;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;

public class SignUpActivity extends AppCompatActivity {
    Button signup_button;
    EditText name_text;
    EditText password_text;
    EditText city_text;
    EditText email_text;
    ImageView fb_button;
    ImageView google_button;
    private ApiInterface mApiInterface;
    TextView login_link;
    private SharedPreferences preferences;
    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        preferences = getApplicationContext().getSharedPreferences("Litstays",0);
        if(!TextUtils.equals(preferences.getString("auth_Token","hell"),"hell")){
            startActivity(new Intent(SignUpActivity.this,MainActivity.class));
            finish();
        }
        callbackManager = CallbackManager.Factory.create();

        login_link = findViewById(R.id.link_login);
        login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                finish();
            }
        });
        mApiInterface = ApiUtils.getAPIService();
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

            EditText name_text=findViewById(R.id.input_name);
            EditText password_text=findViewById(R.id.input_password);
            EditText phone_text=findViewById(R.id.input_phone);
            EditText email_text=findViewById(R.id.input_email);


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
                onSignUp(nameattr,emailattr,passatr,passatr);
            }


   }

   public void onSignUp(String name, String email, String password, String password2)
   {
       Response response = new Response();
       response.setName(name);
       response.setEmail(email);
       response.setPassword(password);
       response.setPassword2(password2);
        mApiInterface.saveUser(response).enqueue(new Callback<Response>() {

            @Override
            public void onResponse(Call call, retrofit2.Response response) {
            if(response.code()==200)
            {
                Toast.makeText(SignUpActivity.this,"Success",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                finish();
            }
            else {
                Toast.makeText(SignUpActivity.this,"Please try again",Toast.LENGTH_SHORT).show();
            }

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
   }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}

