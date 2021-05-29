package com.example.sobotilnic_online.ui.search_olimps;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sobotilnic_online.Login_or_sign_in;
import com.example.sobotilnic_online.R;
import com.example.sobotilnic_online.ui.my_olimps.Class_for_list;
import com.example.sobotilnic_online.ui.my_olimps.adapter_for_my_olimps_list;

import java.util.ArrayList;

public class Search_olimpsFragment extends Fragment {
    ArrayList<Class_for_list> search_olimps = new ArrayList<>();
    RecyclerView search_olimps_results_list;
    Button search_olimps_filter_button;
    TextView textView_results_count;
    Dialog dialog_for_search_olimps;
    private RecyclerView.LayoutManager layoutManager;


    private Search_olimpsViewModel search_olimpsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        search_olimpsViewModel =
                ViewModelProviders.of(this).get(Search_olimpsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search_olimps, container, false);
        final TextView textView = root.findViewById(R.id.text_search_olimps);
        search_olimpsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        for (int i = 0; i < 10; i++) {
            search_olimps.add(new Class_for_list(i, "name will be there"));
        }

        search_olimps_results_list = root.findViewById(R.id.search_olimps_result_list);
        search_olimps_filter_button = root.findViewById(R.id.search_olimps_filter_button);
        textView_results_count = root.findViewById(R.id.textView_results_count);

        adapter_for_search_olimps adapter_for_olimps = new adapter_for_search_olimps(search_olimps);

        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        search_olimps_results_list.setLayoutManager(layoutManager);
        search_olimps_results_list.setAdapter(adapter_for_olimps);
        System.out.println("oooo");

        dialog_for_search_olimps = new Dialog(getActivity());
        System.out.println("ppppp");
        dialog_for_search_olimps.setContentView(R.layout.dialog_for_subject_filter);

        //TextView text = (TextView) root.findViewById(R.id.text_for_search_olimps_dialog);
        //text.setText("Для восстановления пароля напишите на почту dina_gdr@mail.ru, указав в письме тему *Пароль* и направив мне ваш логин и секретное слово. В течение дня придет ответ!");


        search_olimps_filter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //alert.show();
                dialog_for_search_olimps.show();
            }
        });

        return root;
    }
}