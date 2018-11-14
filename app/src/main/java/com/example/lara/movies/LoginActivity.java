package com.example.lara.movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView textView_register;

    private EditText editText_email;
    private EditText editText_password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        setupViews();
    }

    private void setupViews() {
        Button button_login = (Button) findViewById(R.id.button_login);
        TextView textView_register = (TextView) findViewById(R.id.textView_register);


        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noErrorMessageShown()) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            }
        });

        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_password = (EditText) findViewById(R.id.editText_password);

        textView_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private boolean noErrorMessageShown() {
        boolean noErrorMessageShown = true;
        if (getEmail().isEmpty()) {
            editText_email.setError("You should write your email");
            noErrorMessageShown = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            editText_email.setError("Your Email is not valid!");
            noErrorMessageShown = false;
        } else {
            editText_email.setError(null);
        }
        if (getPassword().isEmpty()) {
            editText_password.setError("You should write the password");
            noErrorMessageShown = false;
        } else if (getPassword().length() < 8) {
            editText_password.setError("your password is too short!");
            noErrorMessageShown = false;
        } else {
            editText_password.setError(null);
        }
        return noErrorMessageShown;
    }

    private String getEmail() {
        return editText_email.getText().toString().trim();
    }

    private String getPassword() {
        return editText_password.getText().toString().trim();
    }
}
