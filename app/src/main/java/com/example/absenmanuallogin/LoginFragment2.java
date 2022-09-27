package com.example.absenmanuallogin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment2 extends Fragment {
    Button var_daftar;
    EditText var_nama;
    EditText var_email2;
    EditText var_password2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.activity_login_fragment2, container, false);
        var_nama = v.findViewById(R.id.nama);
        var_email2 = v.findViewById(R.id.email2);
        var_password2 = v.findViewById(R.id.password2);
        var_daftar = v.findViewById(R.id.daftar);
        var_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(var_nama.getText().toString())){
                    Toast.makeText(getActivity(), "Isikan Nama terlebih dahulu!", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(var_email2.getText().toString())){
                    Toast.makeText(getActivity(), "Isikan Email terlebih dahulu", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(var_password2.getText().toString())){
                    Toast.makeText(getActivity(), "Isikan Password terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        return v;
    }
}