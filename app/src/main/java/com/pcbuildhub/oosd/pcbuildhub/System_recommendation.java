package com.pcbuildhub.oosd.pcbuildhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class System_recommendation extends AppCompatActivity {

    private ListView recommendations;

    //creating object of Array list where type is Configurations pojo class
    private List<Configurations> configurations = new ArrayList<>();
    //The adapter for List view
    private RecommendationAdapter adapter;
    private DbConnector dbConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_recommendation);

        //call init() method to initialize all the attributes
        init();

        //setting the data in the Array list from sqlite database for configs
        configurations = dbConnector.recommendation();
        //passing the array in the adapter
        adapter = new RecommendationAdapter(this,configurations);
        //setting the adapter in the list view of the activity
        recommendations.setAdapter(adapter);



        //for now it's showing the demo configs i have input in the logic check activity

        //TODO Shakil you have to impliment onclick of the list view

        recommendations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(System_recommendation.this,Modify_recommendations.class);
                intent.putExtra("monitorname",configurations.get(i).getMonitorName());
                intent.putExtra("monitorprice",configurations.get(i).getMonitorPrice());
                intent.putExtra("processorname",configurations.get(i).getProcessorName());
                intent.putExtra("processorPrice",configurations.get(i).getProcessorPrice());
                intent.putExtra("motherboardname",configurations.get(i).getMotherboardName());
                intent.putExtra("motherboardprice",configurations.get(i).getMotherboardPrice());
                intent.putExtra("gpuname",configurations.get(i).getGpuName());
                intent.putExtra("gpuprice",configurations.get(i).getGpuPrice());
                intent.putExtra("hddname",configurations.get(i).getHddName());
                intent.putExtra("hddprice",configurations.get(i).getHddPrice());
                intent.putExtra("ramname",configurations.get(i).getRamName());
                intent.putExtra("ramprice",configurations.get(i).getRamPrice());
                intent.putExtra("totalprice",configurations.get(i).getTotalPrice());
                startActivity(intent);
            }
        });



        //TODO Also 2-3 queries in the DBconnector class and there will be logic like if 20000<budget<30000 then run this query for fecthing data of configurations
        //Check dbconnector class
    }
    //this method will be using for initializing the atrtibutes
    public void init(){
        recommendations = findViewById(R.id.recommendation_LV);
        dbConnector = new DbConnector(this);
    }
}
