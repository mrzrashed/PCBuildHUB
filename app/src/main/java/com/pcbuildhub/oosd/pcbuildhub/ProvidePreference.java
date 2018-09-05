package com.pcbuildhub.oosd.pcbuildhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProvidePreference extends AppCompatActivity {

    private Button buildPc;
    private EditText budgetInput;
    private Spinner spinner;
    TextView preferenceMessage,userwelcomeMessage,welcomeAdminMessage;

    private String userName1;
    DbConnector dbConnector;

    final String[] select_priority = {
            "Select Priority", "RAM", "Hard Disk", "Motherboard", "GPU",
            "Monitor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_preference);

        //get username from the last activity of login
        userName1=getIntent().getExtras().getString("email");
        //init the attrivutes
        init();

        ArrayList<SpinnerComponenets> listVOs = new ArrayList<>();

        //adding the items into arraylist from string array slect_priority
        for (int i = 0; i < select_priority.length; i++) {
            SpinnerComponenets spinnerComponenets = new SpinnerComponenets();
            spinnerComponenets.setTitle(select_priority[i]);
            spinnerComponenets.setSelected(false);
            listVOs.add(spinnerComponenets);
        }
        //creating an instance of adapter class and passing four parameters in it
        //1.Context,2.Resouce id,3.List of utems,4.String array
        SpinnerWithCheckboxAdapter spinnerWithCheckboxAdapter = new SpinnerWithCheckboxAdapter(ProvidePreference.this, 0,
                listVOs,select_priority);

        //selecting the adapter for spinner
        spinner.setAdapter(spinnerWithCheckboxAdapter);

        //button click listner for build now
        buildPc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int budget=0;
                    try{
                        String getBudget=budgetInput.getText().toString().trim();
                        budget=Integer.parseInt(getBudget);
                    }catch(Exception e){
                        budgetInput.setError("Errror the budget field is empty.");
                    }
                    if (budget<20000){
                        Toast.makeText(getApplicationContext(),"Yor budget is too low",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        startActivity(new Intent(ProvidePreference.this,System_recommendation.class));
                    }
                }
        });

    }

    //method for initializing the attributes
    public void init(){
        spinner = findViewById(R.id.spinner);
        budgetInput=findViewById(R.id.budgetXml);
        dbConnector=new DbConnector(this);
        buildPc=findViewById(R.id.buildNowButton);
        preferenceMessage=findViewById(R.id.preferenceMessage);
        userwelcomeMessage=findViewById(R.id.welcomeMessageForUser);
        welcomeAdminMessage=findViewById(R.id.welcomeMessageForAdmin);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        if (!userName1.equals("admin")){
            budgetInput.setVisibility(View.VISIBLE);
            spinner.setVisibility(View.VISIBLE);
            buildPc.setVisibility(View.VISIBLE);
            preferenceMessage.setVisibility(View.VISIBLE);
            userwelcomeMessage.setVisibility(View.VISIBLE);
            welcomeAdminMessage.setVisibility(View.INVISIBLE);
            return  false;
        }
        else if(userName1.equals("admin")){
            inflater.inflate(R.menu.main_menu,menu);
            welcomeAdminMessage.setVisibility(View.VISIBLE);
            budgetInput.setVisibility(View.INVISIBLE);
            spinner.setVisibility(View.INVISIBLE);
            buildPc.setVisibility(View.INVISIBLE);
            preferenceMessage.setVisibility(View.INVISIBLE);
            userwelcomeMessage.setVisibility(View.INVISIBLE);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_add_configuration:
                startActivity(new Intent(this,AddConfiguration.class));
                break;
            case R.id.menu_update_configuration:
                startActivity(new Intent(this,UpdateConfiguration.class));
                break;
            case R.id.menu_delete_configuration:
                startActivity(new Intent(this,DeleteConfiguration.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
