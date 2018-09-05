package com.pcbuildhub.oosd.pcbuildhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddConfiguration extends AppCompatActivity {

    EditText monitorName,monitorPrice,processorName,processorPrice,motherboardName,motherboardPrice,gpuName,gpuPrice,hddName,hddPrice,ramName,ramPrice;
    Button add;
    DbConnector dbConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_configuration);

        //call the init() method to initialize the attributes
        init();

        add.setOnClickListener(new View.OnClickListener() {
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

                if (dbConnector.addNewConfiguration(monitorN,monitorP,processorN,processorP,motherboardN,motherboardP,gpuN,gpuP,hddN,hddP,ramN,ramP,totalPrice) == true) {
                    Toast.makeText(AddConfiguration.this, "Added Succesfully!!!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddConfiguration.this,AddConfiguration.class));
                }
            }
        });

    }

    //this method will be using for initializing the atrtibutes
    public void init(){
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
        add = findViewById(R.id.addConfigButton);

        dbConnector = new DbConnector(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
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
