package com.example.sobotilnic_online.ui.materials;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sobotilnic_online.R;
import com.example.sobotilnic_online.ui.my_olimps.Class_for_list;
import com.example.sobotilnic_online.ui.search_olimps.adapter_for_search_olimps;

import java.util.ArrayList;

public class MaterialsFragment extends Fragment {

    ArrayList<Class_for_list> subjects_for_materials = new ArrayList<>();
    LinearLayoutManager layoutManager;
    RecyclerView materials_list;

    private MaterialsViewModel materialsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        materialsViewModel =
                ViewModelProviders.of(this).get(MaterialsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_materials, container, false);
        final TextView textView = root.findViewById(R.id.text_materials);
        materialsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });



        materials_list = root.findViewById(R.id.materials_list);


        for (int i = 0; i < 10; i++){
            subjects_for_materials.add(new Class_for_list(i,"subject" + String.valueOf(i)));
        }


        adapter_for_materials adapter_for_materials = new adapter_for_materials(subjects_for_materials);

        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        materials_list.setLayoutManager(layoutManager);
        materials_list.setAdapter(adapter_for_materials);






        return root;
    }
}