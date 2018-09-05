package com.pcbuildhub.oosd.pcbuildhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateSingleConfiguration extends AppCompatActivity {

    EditText monitorName,monitorPrice,processorName,processorPrice,motherboardName,motherboardPrice,gpuName,gpuPrice,hddName,hddPrice,ramName,ramPrice,totalPrice;
    Button Update;

    String posit;
    Configurations configs;

    DbConnector dbConnector;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_single_configuration);

        monitorName = findViewById(R.id.configurationMonitorName);
        monitorPrice = findViewById(R.id.configurationMonitorPrice);
        processorName = findViewById(R.id.configurationProcessorName);
        processorPrice = findViewById(R.id.configurationprocessorPrice);
        motherboardName = findViewById(R.id.configurationMotherboardName);
        motherboardPrice = findViewById(R.id.configurationMotherboardPrice);
        gpuName = findViewById(R.id.configurationGpuName);
        gpuPrice = findViewById(R.id.configurationGpuPrice);
        hddName = findViewById(R.id.configurationHddName);
        hddPrice = findViewById(R.id.configurationHddPrice);
        ramName = findViewById(R.id.configurationRamName);
        ramPrice = findViewById(R.id.configurationRamPrice);
        totalPrice = findViewById(R.id.configurationTotalPrice);
        Update = findViewById(R.id.updateConfigButton);


        Intent intent = getIntent();
        id = intent.getIntExtra("itemid",-1);
        monitorName.setText(intent.getStringExtra("monitorN"));
        monitorPrice.setText(String.valueOf(intent.getIntExtra("monitorP",0)));
        processorName.setText(intent.getStringExtra("processorN"));
        processorPrice.setText(String.valueOf(intent.getIntExtra("processorP",0)));
        motherboardName.setText(intent.getStringExtra("motherboardN"));
        motherboardPrice.setText(String.valueOf(intent.getIntExtra("motherboardP",0)));
        gpuName.setText(intent.getStringExtra("gpuN"));
        gpuPrice.setText(String.valueOf(intent.getIntExtra("gpuP",0)));
        hddName.setText(intent.getStringExtra("hddN"));
        hddPrice.setText(String.valueOf(intent.getIntExtra("hddP",0)));
        ramName.setText(intent.getStringExtra("ramN"));
        ramPrice.setText(String.valueOf(intent.getIntExtra("ramP",0)));
        totalPrice.setText(String.valueOf(intent.getIntExtra("totalP",0)));

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monitorN = monitorName.getText().toString();
                int monitorP = Integer.parseInt(monitorPrice.getText().toString());
                String processorN = processorName.getText().toString();
                int processorP = Integer.parseInt(processorPrice.getText().toString());
                String motherboardN = motherboardName.getText().toString();
                int motherboardP = Integer.parseInt(motherboardPrice.getText().toString());
                String gpuN = gpuName.getText().toString();
                int gpuP = Integer.parseInt(gpuPrice.getText().toString());
                String hddN = hddName.getText().toString();
                int hddP = Integer.parseInt(hddPrice.getText().toString());
                String ramN = ramName.getText().toString();
                int ramP = Integer.parseInt(ramPrice.getText().toString());
                int totalPrice = (monitorP + processorP + motherboardP + gpuP + hddP + ramP);

                if(id==-1)
                {
                    Toast.makeText(UpdateSingleConfiguration.this, "Not getting ID", Toast.LENGTH_SHORT).show();
                }
                else if (dbConnector.updateConfiguration(id,monitorN,monitorP,processorN,processorP,motherboardN,motherboardP,gpuN,gpuP,hddN,hddP,ramN,ramP,totalPrice) == true)
                {
                    Toast.makeText(UpdateSingleConfiguration.this, "Updated Succesfully!!!!", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(UpdateSingleConfiguration.this,UpdateConfiguration.class));
                }
                else
                {
                    Toast.makeText(UpdateSingleConfiguration.this, "What is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
