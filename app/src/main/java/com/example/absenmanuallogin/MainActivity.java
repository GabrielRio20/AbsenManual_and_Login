package com.example.absenmanuallogin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText var_tanggal;
    EditText var_waktu;
    Spinner spinner;
    EditText var_keterangan;
    Button var_kirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //constructor
        var_tanggal = findViewById(R.id.tanggal);
        var_waktu = findViewById(R.id.waktu);
        spinner = findViewById(R.id.tipe_absen);
        var_kirim = findViewById(R.id.submit);
        var_keterangan = findViewById(R.id.keterangan);

        var_tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        var_tanggal.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    showDatePicker();
                }
            }
        });

        //waktu set on click
        var_waktu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        var_waktu.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    showTimePicker();
                }
            }
        });

        //array spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }

        //button kirim set on click
        var_kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(var_tanggal.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Isikan Tanggal terlebih dahulu!", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(var_waktu.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Isikan Waktu terlebih dahulu", Toast.LENGTH_SHORT).show();
                }

                else{
                    showAlertDialog();
                }
            }
        });
    }

    //method tanggal
    public void showDatePicker(){
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(), "date-picker");
    }

    public void processedDatePickerResult(int day, int month, int year){
        String day_string = Integer.toString(day);
        String month_string = Integer.toString(month);
        String year_string = Integer.toString(year);
        String dateMessage = day_string + "/" + month_string + "/" + year_string;
        var_tanggal.setText(dateMessage);
    }

    //method waktu
    public void showTimePicker(){
        DialogFragment timeFragment = new TimePickerFragment();
        timeFragment.show(getSupportFragmentManager(), "time-picker");
    }

    public void processedTimePicker(int hour, int minute){
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);
        String timeMessage = hour_string + ":" + minute_string;
        var_waktu.setText(timeMessage);
    }

    //method alert
    public void showAlertDialog(){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setTitle("Konfirmasi");
        alertBuilder.setMessage("Apakah kamu yakin data yang kamu isi sudah sesuai?");
        alertBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Absen Berhasil", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());
            }
        });

        alertBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertBuilder.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}