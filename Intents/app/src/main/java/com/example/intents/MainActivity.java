package com.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    Button explicit_btn, implicit_btn;
    private static final int PICK_CONTACT_SUBACTIVITY=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        explicit_btn = (Button)findViewById(R.id.explicit_Intent);
        implicit_btn = (Button) findViewById(R.id.implicit_Intent);

        //implement Onclick event for Explicit Intent

        explicit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new  Intent(getBaseContext(), activity_second.class);
                startActivity(intent);


            }
        });

        //implement onClick event for Implicit Intent


        implicit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(Intent.ACTION_VIEW);
               // intent.setData(Uri.parse("tel:+919860814039"));

               // startActivity(intent);
                Uri uri = Uri.parse("content://contacts/people");
                Intent intent=new Intent(Intent.ACTION_PICK,uri);
                startActivityForResult(intent,PICK_CONTACT_SUBACTIVITY);
            }
        });


    }
}