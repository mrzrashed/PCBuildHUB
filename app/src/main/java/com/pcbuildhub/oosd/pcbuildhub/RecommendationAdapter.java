package com.pcbuildhub.oosd.pcbuildhub;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


//Adapter class for initializing values in the ListView
public class RecommendationAdapter extends ArrayAdapter<Configurations> {

    private Context context;
    List<Configurations>configurations;

    public RecommendationAdapter(@NonNull Context context, List<Configurations>configurations) {
        super(context, R.layout.recommendations_row,configurations);
        this.context = context;
        this.configurations = configurations;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.recommendations_row,parent,false);

        TextView monitorN = convertView.findViewById(R.id.monitor_name_TV);
        TextView monitorP = convertView.findViewById(R.id.monitor_price_TV);
        TextView processorN = convertView.findViewById(R.id.processor_name_TV);
        TextView processorP = convertView.findViewById(R.id.processor_price_TV);
        TextView motherboardN = convertView.findViewById(R.id.motherboard_name_TV);
        TextView motherboardP = convertView.findViewById(R.id.motherboard_price_TV);
        TextView gpuN = convertView.findViewById(R.id.gpu_name_TV);
        TextView gpuP = convertView.findViewById(R.id.gpu_price_TV);
        TextView hddN = convertView.findViewById(R.id.hdd_name_TV);
        TextView hddP = convertView.findViewById(R.id.hdd_price_TV);
        TextView ramN = convertView.findViewById(R.id.ram_name_TV);
        TextView ramP = convertView.findViewById(R.id.ram_price_TV);
        TextView totalP = convertView.findViewById(R.id.total_price_TV);


        //Initializing the values in the Textview
        monitorN.setText(configurations.get(position).getMonitorName());
        monitorP.setText(String.valueOf(configurations.get(position).getMonitorPrice()));
        processorN.setText(configurations.get(position).getProcessorName());
        processorP.setText(String.valueOf(configurations.get(position).getProcessorPrice()));
        motherboardN.setText(configurations.get(position).getMotherboardName());
        motherboardP.setText(String.valueOf(configurations.get(position).getMotherboardPrice()));
        gpuN.setText(configurations.get(position).getGpuName());
        gpuP.setText(String.valueOf(configurations.get(position).getGpuPrice()));
        hddN.setText(configurations.get(position).getHddName());
        hddP.setText(String.valueOf(configurations.get(position).getHddPrice()));
        ramN.setText(configurations.get(position).getRamName());
        ramP.setText(String.valueOf(configurations.get(position).getRamPrice()));
        totalP.setText(String.valueOf(configurations.get(position).getTotalPrice()));

        return convertView;
    }
}
