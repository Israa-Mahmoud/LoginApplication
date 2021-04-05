package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /* Define the UI elements */
     private EditText eName;
   private EditText ePassword;
    private TextView eAttemptsInfo;
    private Button eLogin;
   private int counter = 5;
   private final String UserName = "Admin";
  private  final String Password = "12345678";
boolean isValid =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Bind the XML views to Java Code Elements */
        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);
        eAttemptsInfo = findViewById(R.id.tvAttemptsInfo);
        eLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                String inputName =eName.getText().toString();
                String inputPassword =ePassword.getText().toString();
                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"please enter all the details correctly! ",Toast.LENGTH_SHORT).show();
                }else {

                isValid = validate(inputName,inputPassword);
                if(!isValid){
                       counter--;
                    Toast.makeText(MainActivity.this,"Incorrect credentials entered! ",Toast.LENGTH_SHORT).show();


                    eAttemptsInfo.setText(" No. of attemps remaining: 5" + counter);
                       if(counter==0)
                       {
                           eLogin.setEnabled(false);
                       }

                } else{

                    Toast.makeText(MainActivity.this,"Login successful ",Toast.LENGTH_SHORT).show();
                    //add code to open new activity

                    Intent intent = new Intent(MainActivity.this,HomePageActivity.class);
                    startActivity(intent);
                }

                }
            }
        });
    }
    private boolean validate(String name,String passsword){
        if(name.equals(UserName) && passsword.equals(Password)){
           return true;
        }
        return false;
    }}