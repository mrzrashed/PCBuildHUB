package com.pcbuildhub.oosd.pcbuildhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Modify_recommendations extends AppCompatActivity {

    Button updateconfiguration;
    EditText monitor_name,monitor_price,processor_name,processor_price,motherboard_name,motherboard_price,gpu_name,gpu_price,hdd_name,hdd_price,ram_name,ram_price,totalPriceConfig;

    String monitorName,motherboardName,processorName,gpuName,ramName,hddName;
    int monitorPrice,motherBoardPrice,processorPrice,gpuPrice,ramPrice,hddPrice,totalPrice;

    DbConnector dbConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_recommendations);

        //to initialize the object
        init();

        //get all the putextras by this method
        getPutExtras();

        //set all the editetexts fields by this method
        setAllTheEditetexsFields();

        updateconfiguration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monitorN = monitor_name.getText().toString();
                int monitorP = Integer.parseInt(monitor_price.getText().toString());
                String processorN = processor_name.getText().toString();
                int processorP = Integer.parseInt(processor_price.getText().toString());
                String motherboardN = motherboard_name.getText().toString();
                int motherboardP = Integer.parseInt(motherboard_price.getText().toString());
                String gpuN = gpu_name.getText().toString();
                int gpuP = Integer.parseInt(gpu_price.getText().toString());
                String hddN = hdd_name.getText().toString();
                int hddP = Integer.parseInt(hdd_price.getText().toString());
                String ramN = ram_name.getText().toString();
                int ramP = Integer.parseInt(ram_price.getText().toString());
                int totalPrice = (monitorP + processorP + motherboardP + gpuP + hddP + ramP);

                if (dbConnector.addaDataIntoUserlogTable(monitorN,monitorP,processorN,processorP,motherboardN,motherboardP,gpuN,gpuP,hddN,hddP,ramN,ramP,totalPrice) == true) {
                    Toast.makeText(Modify_recommendations.this, "Added Succesfully to your favorites!!!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Modify_recommendations.this,System_recommendation.class));
                }
                else{
                    Toast.makeText(Modify_recommendations.this, "Add Unsuccesfull!!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    //this method is for setting all the edittext fields
    public void setAllTheEditetexsFields(){
        monitor_name.setText(monitorName);
        monitor_price.setText(""+monitorPrice);
        motherboard_name.setText(motherboardName);
        motherboard_price.setText(""+motherBoardPrice);
        processor_name.setText(processorName);
        processor_price.setText(""+processorPrice);
        gpu_name.setText(gpuName);
        gpu_price.setText(""+gpuPrice);
        ram_name.setText(ramName);
        ram_price.setText(""+ramPrice);
        hdd_name.setText(hddName);
        hdd_price.setText(""+hddPrice);
        totalPriceConfig.setText(""+totalPrice);
    }

    //this method is for getting all the put extra from the previous activity
    public void getPutExtras(){
        monitorName=getIntent().getExtras().getString("monitorname");
        monitorPrice=getIntent().getExtras().getInt("monitorprice");
        processorName=getIntent().getExtras().getString("processorname");
        processorPrice=getIntent().getExtras().getInt("processorPrice");
        motherboardName=getIntent().getExtras().getString("motherboardname");
        motherBoardPrice=getIntent().getExtras().getInt("motherboardprice");
        gpuName=getIntent().getExtras().getString("gpuname");
        gpuPrice=getIntent().getExtras().getInt("gpuprice");
        hddName=getIntent().getExtras().getString("hddname");
        hddPrice=getIntent().getExtras().getInt("hddprice");
        ramName=getIntent().getExtras().getString("ramname");
        ramPrice=getIntent().getExtras().getInt("ramprice");
        totalPrice=getIntent().getExtras().getInt("totalprice");
    }

    //this method is for initialize all the attributes
    public void init(){
        //init the button
        updateconfiguration=findViewById(R.id.updateConfigButton);

        dbConnector=new DbConnector(this);

        //update the edittexts
        monitor_name=findViewById(R.id.configurationMonitorName);
        monitor_price=findViewById(R.id.configurationMonitorPrice);
        processor_name=findViewById(R.id.configurationProcessorName);
        processor_price=findViewById(R.id.configurationprocessorPrice);
        motherboard_name=findViewById(R.id.configurationMotherboardName);
        motherboard_price=findViewById(R.id.configurationMotherboardPrice);
        gpu_name=findViewById(R.id.configurationGpuName);
        gpu_price=findViewById(R.id.configurationGpuPrice);
        hdd_name=findViewById(R.id.configurationHddName);
        hdd_price=findViewById(R.id.configurationHddPrice);
        ram_name=findViewById(R.id.configurationRamName);
        ram_price=findViewById(R.id.configurationRamPrice);
        totalPriceConfig=findViewById(R.id.configurationtotalprice);
    }
}
