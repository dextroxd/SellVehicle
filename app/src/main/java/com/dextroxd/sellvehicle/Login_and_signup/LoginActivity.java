package com.dextroxd.sellvehicle.login_and_signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dextroxd.sellvehicle.activities.MainActivity;
import com.dextroxd.sellvehicle.R;

public class LoginActivity extends AppCompatActivity {
    TextView link_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView link_signup=(TextView)findViewById(R.id.link_signup);
        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    public void onLogin(View v)
    {
        if(v.getId()==R.id.btn_login);
        {
            EditText email_login=(EditText)findViewById(R.id.input_email_login);
            EditText password_login=(EditText)findViewById(R.id.input_password_login);
            String email_attr_login=email_login.getText().toString();
            String password_attr_login=password_login.getText().toString();
            if(email_attr_login.matches("")||password_attr_login.matches(""))
            {
                Toast toast=Toast.makeText(LoginActivity.this,"Please Enter Details",Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                Toast toast=Toast.makeText(LoginActivity.this,"Successful Log In",Toast.LENGTH_SHORT);
                toast.show();
                Intent in = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(in);
            }
        }
    }
}
