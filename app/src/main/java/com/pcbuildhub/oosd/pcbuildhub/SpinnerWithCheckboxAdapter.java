package com.pcbuildhub.oosd.pcbuildhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerWithCheckboxAdapter extends ArrayAdapter<SpinnerComponenets> {
    //for context
    private Context mContext;
    //for list of items
    private ArrayList<SpinnerComponenets> listState;
    //for items in string
    private String[] item;
    //creating the instance of own class
    private SpinnerWithCheckboxAdapter spinnerWithCheckboxAdapter;
    private boolean isFromView = false;

    public SpinnerWithCheckboxAdapter(Context context, int resource, List<SpinnerComponenets> objects,String[] items) {
        super(context, resource, objects);
        this.mContext = context;
        this.listState = (ArrayList<SpinnerComponenets>) objects;
        this.spinnerWithCheckboxAdapter = this;
        this.item=items;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    //creating the view for spinner with checkbox
    public View getCustomView(final int position, View convertView,
                              ViewGroup parent) {

        //viewholder instance
        final ViewHolder holder;
        if (convertView == null) {
            //getting layoutinflater from conext activity
            LayoutInflater layoutInflator = LayoutInflater.from(mContext);
            //inflating the layout with spinner_item layout
            convertView = layoutInflator.inflate(R.layout.spinner_item, null);
            holder = new ViewHolder();
            holder.mTextView = (TextView) convertView
                    .findViewById(R.id.text);
            holder.mCheckBox = (CheckBox) convertView
                    .findViewById(R.id.checkbox);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.mTextView.setText(listState.get(position).getTitle());

        // To check weather checked event fire from getview() or user input
        isFromView = true;
        holder.mCheckBox.setChecked(listState.get(position).isSelected());
        isFromView = false;

        if ((position == 0)) {
            holder.mCheckBox.setVisibility(View.INVISIBLE);
        } else {
            holder.mCheckBox.setVisibility(View.VISIBLE);
        }
        holder.mCheckBox.setTag(position);
        //on checked listener for item slection
        holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int getPosition = (Integer) buttonView.getTag();

                if (!isFromView) {
                    listState.get(position).setSelected(isChecked);
                }
                Toast.makeText(mContext,"Selected item:"+item[position],Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    private class ViewHolder {
        private TextView mTextView;
        private CheckBox mCheckBox;
    }
}
