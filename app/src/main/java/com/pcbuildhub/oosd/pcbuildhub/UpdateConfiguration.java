package com.pcbuildhub.oosd.pcbuildhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UpdateConfiguration extends AppCompatActivity {
    private ListView recommendations;

    //creating object of Array list where type is Configurations pojo class
    private List<Configurations> configurations = new ArrayList<>();
    //The adapter for List view
    private RecommendationAdapter adapter;
    private DbConnector dbConnector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_configuration);

        recommendations = findViewById(R.id.recommendation_LV);

        dbConnector = new DbConnector(this);
        //setting the data in the Array list from sqlite database for configs
        configurations = dbConnector.recommendation();
        //passing the array in the adapter
        adapter = new RecommendationAdapter(this,configurations);
        //setting the adapter in the list view of the activity
        recommendations.setAdapter(adapter);

        recommendations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mntrName = configurations.get(position).getMonitorName();
                int mntrPrice = configurations.get(position).getMonitorPrice();
                String procrname = configurations.get(position).getProcessorName();
                int procrPrice = configurations.get(position).getProcessorPrice();
                String mthrname = configurations.get(position).getMotherboardName();
                int mthrPrice = configurations.get(position).getMotherboardPrice();
                String gpuname = configurations.get(position).getGpuName();
                int gpuprice = configurations.get(position).getGpuPrice();
                String hddname = configurations.get(position).getHddName();
                int hddprice = configurations.get(position).getHddPrice();
                String ramname = configurations.get(position).getRamName();
                int ramprice = configurations.get(position).getRamPrice();
                int totalprice = configurations.get(position).getTotalPrice();
                startActivity(new Intent(UpdateConfiguration.this,UpdateSingleConfiguration.class)
                        .putExtra("itemid",configurations.get(position).getItemId())
                        .putExtra("monitorN",mntrName)
                        .putExtra("monitorP",mntrPrice)
                        .putExtra("processorN",procrname)
                        .putExtra("processorP",procrPrice)
                        .putExtra("motherboardN",mthrname)
                        .putExtra("motherboardP",mthrPrice)
                        .putExtra("gpuN",gpuname)
                        .putExtra("gpuP",gpuprice)
                        .putExtra("hddN",hddname)
                        .putExtra("hddP",hddprice)
                        .putExtra("ramN",ramname)
                        .putExtra("ramP",ramprice)
                        .putExtra("totalP",totalprice));
            }
        });
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
