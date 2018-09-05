package com.pcbuildhub.oosd.pcbuildhub;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Ref;

public class RegistrationCheck extends AppCompatActivity {

    EditText username,email,password;
    TextView movetoNextPage;
    ScrollView scrollView;

    Button signUp;
    //creating the object or reference of DbcCOnnector class
    DbConnector dbConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_check);

        //init the attributes of xml with the java associators
        init();


        movetoNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationCheck.this,LoginCheck.class));
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //init the user class object
                User user=new User();
                //storing each values into single string variable from user
                String usernameStr=username.getText().toString();
                String emailStr=email.getText().toString();
                String passwordStr=password.getText().toString();

                if (!dbConnector.checkUser(emailStr)) {
                    user.setName(usernameStr);
                    user.setEmail(passwordStr);
                    user.setPassword(emailStr);
                    user.setUserType("Person");
                    //inserting the data into database for registration
                    dbConnector.insertData(user);
                    // Snack Bar to show success message that record saved successfully
                    Snackbar.make(scrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
                    startActivity(new Intent(RegistrationCheck.this,LoginCheck.class));
                }
                else{
                    Snackbar.make(scrollView, getString(R.string.unsuccessful_message), Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    //this method will be using for initializing the atrtibutes
    public void init(){
        email=findViewById(R.id.emailHereXml);
        password=findViewById(R.id.passwordHereXml);
        username=findViewById(R.id.usernameXml);
        movetoNextPage=findViewById(R.id.moveSignInPage);
        signUp=findViewById(R.id.signUpHere);
        scrollView=findViewById(R.id.scrollVIew);

        //init the dbconnetor object
        dbConnector=new DbConnector(RegistrationCheck.this);
    }
}
