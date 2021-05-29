package com.example.sobotilnic_online.ui.search_sobotilnic;

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

import com.example.sobotilnic_online.R;

public class Search_sobotilnicFragment extends Fragment {

    private Search_sobotilnicViewModel search_sobotilnicViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        search_sobotilnicViewModel =
                ViewModelProviders.of(this).get(Search_sobotilnicViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search_sobotilnic, container, false);
        final TextView textView = root.findViewById(R.id.text_search_sobotilnic);
        search_sobotilnicViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}