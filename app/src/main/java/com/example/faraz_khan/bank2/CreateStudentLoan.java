package com.example.faraz_khan.bank2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CreateStudentLoan extends AppCompatActivity {
    public int acc_num;
    public int loan;
    public String name;
    Control ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student_loan);
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

    public void createStudentLoanButton(View view) {
        ctrl = Control.getInstance();
        EditText customer_first_name = (EditText) findViewById(R.id.first_name_studentloan);
        EditText customer_surname = (EditText) findViewById(R.id.surname_studentloan);


        name = customer_first_name.getText().toString();
        name += " ";
        name += customer_surname.getText().toString();

        EditText idtext = (EditText) findViewById(R.id.ID_studentloan);
        int id = Integer.parseInt(idtext.getText().toString());
        EditText accNumText = (EditText) findViewById(R.id.accnum_studentloan);
        acc_num = Integer.parseInt(accNumText.getText().toString());
        EditText amountText = (EditText) findViewById(R.id.amount_studentloan);
        loan = Integer.parseInt(amountText.getText().toString());


        List<String> CreateStudentList = new ArrayList<>();
        CreateStudentList = ctrl.createLoan(name, id, acc_num, 3, "Student Loan", loan);

        ListAdapter CreateStudentLoanAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, CreateStudentList);
        ListView CreateStudentListView = (ListView) findViewById(R.id.studentLoan_listview);

        CreateStudentListView.setAdapter(CreateStudentLoanAdapter);


    }


}
