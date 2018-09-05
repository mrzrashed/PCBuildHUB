package com.pcbuildhub.oosd.pcbuildhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginCheck extends AppCompatActivity {

    EditText email,password;
    TextView movetoNextPage;

    Button signIn;
    //creating the object or reference of DbcCOnnector class
    DbConnector dbConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init the attributes of xml with the java associators
        init();

        //inserting demo configuration........
        dbConnector.insertConfiguration();

        movetoNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginCheck.this,RegistrationCheck.class));
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailStr=email.getText().toString();
                String passwordStr=password.getText().toString();
                //check the data is matched or not
                //check login for the admin

                //if the data matched then the method will return true else false
                //check login for the user
                if (dbConnector.checkwithdatabase(emailStr,passwordStr)==true){
                    Toast.makeText(getApplicationContext(),"Sign in successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginCheck.this,ProvidePreference.class).putExtra("email",emailStr));
                }else if (emailStr.equals("admin")){
                    if (passwordStr.equals("12345")){
                        startActivity(new Intent(LoginCheck.this,ProvidePreference.class).putExtra("email",emailStr));
                    }
                    else{
                        password.setError("Password do not matych.");
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Sign in was unsuccessful",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //this method will be using for initializing all the attributes
    public void init(){
        email=findViewById(R.id.emailHereXmllogin);
        password=findViewById(R.id.passwordHereXmllogin);
        movetoNextPage=findViewById(R.id.moveSignUpPage);
        signIn=findViewById(R.id.signInHere);

        //init the dbconnetor object
        dbConnector=new DbConnector(LoginCheck.this);
    }
}
