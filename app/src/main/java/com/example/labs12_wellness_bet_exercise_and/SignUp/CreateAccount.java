package com.example.labs12_wellness_bet_exercise_and.SignUp;

import android.content.Intent;


import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.labs12_wellness_bet_exercise_and.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class
CreateAccount extends AppCompatActivity {

    /**

    public static final String TAG = "CreateAccountTag";

    private EditText usernameText, emailText, passwordText, fullnameText;
    private String username, password, email;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mAuth = FirebaseAuth.getInstance();

        TextView login = findViewById(R.id.textView_logIn);
        TextView termOfS = findViewById(R.id.textView_terms);

        CardView signupButton = findViewById(R.id.cardView_signup);

        usernameText = findViewById(R.id.name_text_ca);
        fullnameText = findViewById(R.id.fullname_text_ca);
        passwordText = findViewById(R.id.password_text_ca);
        emailText = findViewById(R.id.email_text_ca);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainActivityIntent = new Intent
                        (CreateAccount.this, LogInActivity.class);
                startActivity(MainActivityIntent);

            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = usernameText.getText().toString();
                password = passwordText.getText().toString();
                email = emailText.getText().toString();


                CreateUser(email, password);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject userdata = new JSONObject();
                        try {
                            userdata.put("username",
                                    usernameText.getText().toString() + ",");
                            userdata.put("fullName",
                                    fullnameText.getText().toString() + ",");
                            userdata.put("password",
                                    passwordText.getText().toString() + ",");
                            userdata.put("email",
                                          emailText.getText().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String tokenRequest = null;
                        try {
                            tokenRequest = NetworkAdapter.httpRequest(
                                    "https://sleep-bet.herokuapp.com/api/users/register/",
                                    "POST", userdata, null);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Log.i(TAG, tokenRequest);
                    }
                }).start();
            }
        });

    }

    private void CreateUser(String emailFb, String passwordFb) {
        mAuth.createUserWithEmailAndPassword(emailFb, passwordFb).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent groupIntent = new Intent(CreateAccount.this, LogInActivity.class);
                    startActivity(groupIntent);
                } else {
                    Log.w(TAG, "createUser: failure", task.getException());
                    Toast.makeText(getApplicationContext(), "Login unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }  **/
}
