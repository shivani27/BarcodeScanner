package com.google.android.gms.samples.vision.barcodereader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import java.net.URI;

import org.apache.http.client.utils.URIBuilder;

/**
 * Created by resfeber on 5/19/16.
 */
public class LoginActivity extends Activity {
    public static final String scheme = "https";
    public static final String HOST = BuildConfig.DEBUG ? "127.0.0.1:3000" : "theporter.in";
    public static final String LOGIN_URL = "/administrators/login_home.json";
    // User name
    private EditText email;
    // Password
    private EditText password;
    // Sign In
    private Button sign_in;
    // Message
    private TextView tv_Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialization
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        sign_in = (Button) findViewById(R.id.sign_in);
        tv_Message = (TextView) findViewById(R.id.tv_Message);

        sign_in.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                // Stores User name
                String username = String.valueOf(email.getText());
                // Stores Password
                String password = String.valueOf(LoginActivity.this.password.getText());
                // Validates the User name and Password for admin, admin
                if (password.equals("resfeber123")) {
                    Intent data = new Intent();
                    data.putExtra("email", username);
                    data.putExtra("status", "success");
                    tv_Message.setText("Login Successful!");
                    setResult(RESULT_OK, data);
                    finish();
                } else {
                    tv_Message.setText("Login Unsuccessful!");
                }
            }
        });
    }
}
