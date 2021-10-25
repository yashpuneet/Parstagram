package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    private EditText etSUsername;
    private EditText etSPassword;
    private Button btnSSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etSUsername = findViewById(R.id.etSUsername);
        etSPassword = findViewById(R.id.etSPassword);
        btnSSignup = findViewById(R.id.btnSSignup);

        btnSSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser user = new ParseUser();

                user.setUsername(String.valueOf(etSUsername.getText()));
                user.setPassword(String.valueOf(etSPassword.getText()));

                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            goLoginActivity();
                        } else {
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                        }
                    }
                });
            }
        });
    }

    private void goLoginActivity()
    {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}