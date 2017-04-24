package com.ramyoogesh.android.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Facultypage extends AppCompatActivity {

    Button b1,b2;
    EditText e1,e2,e3,e4,e5,e6;
    private int a,b,c,d,g;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private DatabaseReference mDatabaseReference1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultypage);


        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);

        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);

        e4=(EditText)findViewById(R.id.editText4);
        e5=(EditText)findViewById(R.id.editText5);
        e6=(EditText)findViewById(R.id.editText6);


        mFirebaseDatabase=FirebaseDatabase.getInstance();

        mDatabaseReference=mFirebaseDatabase.getReference().child("Course");
        mDatabaseReference1=mFirebaseDatabase.getReference().child("Course2");


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 a = Integer.parseInt(e1.getText().toString());
                b = Integer.parseInt(e2.getText().toString());
                c = Integer.parseInt(e3.getText().toString());

               Valuestore newval= new Valuestore(a,b,c);

                mDatabaseReference.push().setValue(newval);

                Toast.makeText(Facultypage.this, "Your value is updated ! ", Toast.LENGTH_SHORT).show();




            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                d = Integer.parseInt(e4.getText().toString());
                g = Integer.parseInt(e5.getText().toString());

                Valuestore neee=new Valuestore(d,g);

                mDatabaseReference1.push().setValue(neee);


                Toast.makeText(Facultypage.this, "Your value is updated  Successfullyy ! ", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Facultypage.this,MainActivity.class);
                startActivity(i);




            }
        });






    }
}
