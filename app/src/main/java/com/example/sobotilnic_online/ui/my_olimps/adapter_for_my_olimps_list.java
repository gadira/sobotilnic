package com.example.sobotilnic_online.ui.my_olimps;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sobotilnic_online.R;

import java.util.ArrayList;


public class adapter_for_my_olimps_list extends RecyclerView.Adapter<adapter_for_my_olimps_list.MyAdapter> {

    public class MyAdapter extends RecyclerView.ViewHolder {

        TextView textView_name_of_olimp;
        ImageButton imageButton_delete_olimp;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            textView_name_of_olimp = itemView.findViewById(R.id.textView_name_of_olimp);
            imageButton_delete_olimp = itemView.findViewById(R.id.imageButton_delete_olimp);
        }
    }

    ArrayList<Class_for_list> arr;

    public adapter_for_my_olimps_list(ArrayList<Class_for_list> arr) {
        this.arr = arr;
    }


    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        adapter_for_my_olimps_list.MyAdapter myAdapter = new MyAdapter(v);
        return myAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter holder, final int position) {
        holder.textView_name_of_olimp.setText(arr.get(position).name_of_olimp);
        holder.imageButton_delete_olimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //WHERE MUST BE DIALOG!!!!!!
                removeAt(position);

                holder.textView_name_of_olimp.setText("");


            }

        });
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }


    public void removeAt(int position) {
        arr.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, arr.size());
    }
}
