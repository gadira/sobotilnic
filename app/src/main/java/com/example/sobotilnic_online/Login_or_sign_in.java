package com.example.sobotilnic_online;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_or_sign_in extends AppCompatActivity {
    Button buttonRegistration, buttonSignIn, buttonPressIfForget;
    TextView textHello;
    EditText editLogin, editPassword, editSecretKey;
    Dialog dialogIfForget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_sign_in);
        buttonPressIfForget = findViewById(R.id.buttonPressIfForget);
        buttonRegistration = findViewById(R.id.buttonRegistration);
        buttonSignIn = findViewById(R.id.buttonSignIn);
        textHello = findViewById(R.id.textHello);
        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editLogin);
        editSecretKey = findViewById(R.id.editSecretKey);





        //AlertDialog.Builder b = new AlertDialog.Builder(Login_or_sign_in.this);
        //View dialogView =
        //        LayoutInflater.from(Login_or_sign_in.this).inflate(R.layout.dialog_view,
        //                null);
        //ставим наше окружение
        //b.setView(dialogView);
        //Dialog d = b.create();
        //AlertDialog.Builder builder = new AlertDialog.Builder(new
        //        ContextThemeWrapper(this, R.style.myDialog));


        //AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        //alertDialogBuilder.setTitle(getString(R.string.app_name));
        //alertDialogBuilder.setMessage("ddddddd")
        //        .setCancelable(false)
        //        .setPositiveButton("Ok",
        //                new DialogInterface.OnClickListener() {
        //                    public void onClick(DialogInterface dialog, int id) {
        //                        dialog.dismiss();
        //                    }
        //                });

        //final AlertDialog alert = alertDialogBuilder.create();
        //alert.show();


        dialogIfForget = new Dialog(Login_or_sign_in.this);
        //dialogIfForget.setTitle("Заголовок диалога");
        dialogIfForget.setContentView(R.layout.dialog_view);
        TextView text = (TextView) dialogIfForget.findViewById(R.id.textForDialog);
        text.setText("Для восстановления пароля напишите на почту dina_gdr@mail.ru, указав в письме тему *Пароль* и направив мне ваш логин и секретное слово. В течение дня придет ответ!");


        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editLogin.getText().toString().equals("") && !editPassword.getText().toString().equals("")){
                    Intent i;
                    i = new Intent(Login_or_sign_in.this, MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Что-то не так - вы не ввели логин или пароль", Toast.LENGTH_LONG).show();
                }
            }
        });


        buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editLogin.getText().toString().equals("") && !editPassword.getText().toString().equals("") && !editSecretKey.getText().toString().equals("")){
                    Intent i;
                    i = new Intent(Login_or_sign_in.this, MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Что-то не так- вы не ввели логин, секретное слово или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });


        buttonPressIfForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //alert.show();
                dialogIfForget.show();
            }
        });

    }
}
