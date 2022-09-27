package com.example.absenmanuallogin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

public class LoginFragment1 extends Fragment {
    EditText var_email1;
    EditText var_password1;
    Button var_masuk;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.activity_login_fragment1, container, false);
        var_email1 = v.findViewById(R.id.email1);
        var_password1 = v.findViewById(R.id.password1);
        var_masuk = v.findViewById(R.id.masuk);
        var_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(var_email1.getText().toString())){
                    Toast.makeText(getActivity(), "Isikan Email terlebih dahulu!", Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty((var_password1.getText().toString()))){
                    Toast.makeText(getActivity(), "Isikan Password terlebih dahulu!", Toast.LENGTH_SHORT).show();
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