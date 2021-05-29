package com.example.sobotilnic_online.ui.profile;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.sobotilnic_online.Login_or_sign_in;
import com.example.sobotilnic_online.MainActivity;
import com.example.sobotilnic_online.R;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    Button button_exit, save_changes, button_bot_subject;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        final TextView textView = root.findViewById(R.id.text_profile);
        profileViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        button_exit = root.findViewById(R.id.button_exit);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(getActivity().getApplicationContext(), Login_or_sign_in.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        save_changes = root.findViewById(R.id.save_changes);
        save_changes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Изменения сохранены", Toast.LENGTH_LONG).show();
            }
        });


        button_bot_subject = root.findViewById(R.id.button_bot_subject);
        button_bot_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog subjects_bot = new Dialog(getActivity());
                //dialogIfForget.setTitle("Заголовок диалога");
                subjects_bot.setContentView(R.layout.dialog_for_subject_filter);
                TextView text = (TextView) subjects_bot.findViewById(R.id.text_for_search_olimps_dialog);
                text.setText("CHECK BOX WILL BE THERE");
                subjects_bot.show();
            }
        });




        return root;
    }
}