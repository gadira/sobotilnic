package com.example.sobotilnic_online.ui.my_olimps;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sobotilnic_online.R;

import java.util.ArrayList;
import java.util.Random;

public class My_olimpsFragment extends Fragment {
    ArrayList<Class_for_list> arr = new ArrayList<>();
    RecyclerView my_olimps_list;
    private RecyclerView.LayoutManager layoutManager;

    private My_olimpsViewModel my_olimpsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        my_olimpsViewModel =
                ViewModelProviders.of(this).get(My_olimpsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_my_olimps, container, false);
        final TextView textView = root.findViewById(R.id.text_my_olimps);
        my_olimpsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        for (int i = 0; i < 10; i++){
            arr.add(new Class_for_list(i,String.valueOf(i)));
        }

        my_olimps_list = root.findViewById(R.id.my_olimps_list);

        adapter_for_my_olimps_list adapter = new adapter_for_my_olimps_list(arr);

        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        my_olimps_list.setLayoutManager(layoutManager);
        my_olimps_list.setAdapter(adapter);

        //String[] myArr = { "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь" };


        //  ArrayAdapter<String> monthAdapter =
        //        new ArrayAdapter<String>(this, android.R.layout., myArr);

        //setListAdapter(monthAdapter);




        return root;
    }
}