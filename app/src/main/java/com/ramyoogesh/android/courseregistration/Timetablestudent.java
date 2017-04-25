package com.ramyoogesh.android.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Timetablestudent extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private DatabaseReference mDatabaseReference1;
    private ChildEventListener mChildEventListener;
    private ChildEventListener mChildEventListener1;

    public int e,g,st1,a,z,str2;

    TextView t1,t2,t3,t4,t5,t6;
    Button b3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetablestudent);



        mFirebaseDatabase=FirebaseDatabase.getInstance();

        mDatabaseReference=mFirebaseDatabase.getReference().child("Course");
        mDatabaseReference1=mFirebaseDatabase.getReference().child("Course2");

        t1=(TextView)findViewById(R.id.one);
        t2=(TextView)findViewById(R.id.two);
        t3=(TextView)findViewById(R.id.three);
        t4=(TextView)findViewById(R.id.four);
        t5=(TextView)findViewById(R.id.five);
        t6=(TextView)findViewById(R.id.six);

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

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                t1.setText(e+"");
                t2.setText(g+"");
                t3.setText(st1+"");



                t4.setText(a+"");
                t5.setText(z+"");
                t6.setText(str2+"");



            }
        });



    /*

*/





    }
}
