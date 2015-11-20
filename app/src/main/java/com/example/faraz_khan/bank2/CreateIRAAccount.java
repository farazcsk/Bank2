package com.example.faraz_khan.bank2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CreateIRAAccount extends AppCompatActivity {
    public int acc_num;
    public int accNumGenerator;
    public double amount;
    public String name;
    public ArrayList<BaseAccount> accounts = new ArrayList<BaseAccount>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_iraaccount);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void cIRAAccount(View view) {
        EditText customer_first_name = (EditText) findViewById(R.id.first_name_5);
        EditText customer_surname = (EditText) findViewById(R.id.surname_5);

        name = customer_first_name.getText().toString();
        name += " ";
        name += customer_surname.getText().toString();

        EditText idtext = (EditText) findViewById(R.id.ID_5);
        int id = Integer.parseInt(idtext.getText().toString());
        accNumGenerator++;
        acc_num++;


        accounts.add(new IRAccount(name, acc_num, id));

        TextView output = (TextView) findViewById(R.id.ira_account_output);
        output.setText(createSummary(name, acc_num, id));


    }

    public String createSummary(String name, int acc_num, int id) {

        String message = "Your IRA Account: ";
        message += "\nName: " + name;
        message += "\nAccount Number: " + acc_num;
        message += "\nID: " + id;
        message += "\nHas Successfully Been Created!";


        return message;
    }

}
