package com.example.sobotilnic_online.ui.materials;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sobotilnic_online.For_materials;
import com.example.sobotilnic_online.R;
import com.example.sobotilnic_online.ui.my_olimps.Class_for_list;

import java.util.ArrayList;

public class adapter_for_materials extends RecyclerView.Adapter<adapter_for_materials.MyAdapter> {

    public class MyAdapter extends RecyclerView.ViewHolder {

        TextView textView_name_of_olimps;


        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            textView_name_of_olimps = itemView.findViewById(R.id.textView_name_of_olimps);
        }
    }

    ArrayList<Class_for_list> subjects_for_materials;

    public adapter_for_materials(ArrayList<Class_for_list> searching_results) {
        this.subjects_for_materials = searching_results;
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_for_olimps, parent, false);
        adapter_for_materials.MyAdapter myAdapter = new MyAdapter(v);
        return myAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter holder, int position) {
        holder.textView_name_of_olimps.setText(subjects_for_materials.get(position).name_of_olimp);
        holder.textView_name_of_olimps.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                holder.textView_name_of_olimps.setText("intent will be there!!!");
                Intent i;
                i = new Intent(v.getContext(), For_materials.class);
                v.getContext().startActivity(i);
            }

        });
    }

    @Override
    public int getItemCount() {
        return subjects_for_materials.size();
    }

}
