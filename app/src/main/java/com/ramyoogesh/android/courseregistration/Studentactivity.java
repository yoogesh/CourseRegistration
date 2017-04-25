package com.ramyoogesh.android.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Studentactivity extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private DatabaseReference mDatabaseReference1;
     private ChildEventListener mChildEventListener;
    private ChildEventListener mChildEventListener1;
    Button b1,b2,b3;
    public int e,bcd,st1,str2,g,f,d,j,u,a,z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentactivity);

        mFirebaseDatabase=FirebaseDatabase.getInstance();

        mDatabaseReference=mFirebaseDatabase.getReference().child("Course");
        mDatabaseReference1=mFirebaseDatabase.getReference().child("Course2");

        b1=(Button )findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);


        mChildEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Valuestore friendlyMessage=dataSnapshot.getValue(Valuestore.class);
                e=friendlyMessage.getCourseallot();
                g=friendlyMessage.getEndtime();
                st1=friendlyMessage.getStarttime();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        mDatabaseReference.addChildEventListener(mChildEventListener);




        mChildEventListener1=new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Valuestore friendlyMessage=dataSnapshot.getValue(Valuestore.class);

                a=friendlyMessage.getCourseallot();
                z=friendlyMessage.getEndtime();
                str2=friendlyMessage.getStarttime();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mDatabaseReference1.addChildEventListener(mChildEventListener1);
















        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(e<1)
                {
                    Toast.makeText(Studentactivity.this, "No seats are Available", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(Studentactivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                    d=e-1;

                    Valuestore newval= new Valuestore(d,st1,g);

                    mDatabaseReference.push().setValue(newval);

                }




            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(e<1)
                {
                    Toast.makeText(Studentactivity.this, "No seats are Available ", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if(st1==str2)
                    {
                        Toast.makeText(Studentactivity.this, "Slect Different course timing ! Course timing clashes", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(Studentactivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        u=a-1;

                        Valuestore newval= new Valuestore(u,str2);

                        mDatabaseReference1.push().setValue(newval);
                    }



                }




            }
        });






        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nw=new Intent(Studentactivity.this,Timetablestudent.class);
                startActivity(nw);




            }
        });



    }
}
