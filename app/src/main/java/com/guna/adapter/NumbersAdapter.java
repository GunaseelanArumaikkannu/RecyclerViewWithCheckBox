package com.guna.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.guna.entity.Number;
import com.guna.recyclerviewwithcheckbox.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gunaseelan on 11-12-2015.
 * Simple adapter class, used for show all numbers in list
 */
public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.ViewHolder> {

    ArrayList<Number> numbers;

    public NumbersAdapter(List<Number> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.client_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bindData(numbers.get(position));

        //in some cases, it will prevent unwanted situations
        holder.checkbox.setOnCheckedChangeListener(null);

        //if true, your checkbox will be selected, else unselected
        holder.checkbox.setChecked(numbers.get(position).isSelected());

        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                numbers.get(holder.getAdapterPosition()).setSelected(isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView ONEs;
        private TextView textONEs;
        private CheckBox checkbox;

        public ViewHolder(View v) {
            super(v);
            ONEs = (TextView) v.findViewById(R.id.ONEs);
            textONEs = (TextView) v.findViewById(R.id.textONEs);
            checkbox = (CheckBox) v.findViewById(R.id.checkbox);
        }

        public void bindData(Number number) {
            ONEs.setText(number.getONEs());
            textONEs.setText(number.getTextONEs());
        }
    }
}