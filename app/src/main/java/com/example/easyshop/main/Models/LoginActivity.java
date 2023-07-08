package com.example.easyshop.main.Models;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.easyshop.R;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Utilities.SignalGenerator;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText editTextEmail, editTextPassword;
    Button buttonLogin;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    TextView textView;
    public static String userEmail;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser != null){
            userEmail = currentUser.getEmail();
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        findViews();

        moveToRegister();
        clickToLogin();
    }

    private void moveToRegister() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void clickToLogin() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());

                if (TextUtils.isEmpty(email)) {
                    SignalGenerator.getInstance().toast("Enter email", Toast.LENGTH_SHORT);
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    SignalGenerator.getInstance().toast("Enter password", Toast.LENGTH_SHORT);
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    SignalGenerator.getInstance().toast("Login Successfull.", Toast.LENGTH_SHORT);
                                    userEmail = email;
                                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    SignalGenerator.getInstance().toast("Authentication failed.", Toast.LENGTH_SHORT);
                                }
                            }
                        });
            }
        });
    }

    private void findViews() {
        editTextEmail = findViewById(DataManager.getEditTextEmail());
        editTextPassword = findViewById(DataManager.getEditTextPassword());
        buttonLogin = findViewById(DataManager.getLoginBTN());
        progressBar = findViewById(DataManager.getRegProgressBar());
        textView = findViewById(DataManager.getTxtClickToLogin());
    }
}
