package com.example.todolist;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView=(ListView)findViewById(R.id.myListView);
        final EditText myEditText=(EditText) findViewById(R.id.myEditText);

        final ArrayList<String> todoitems=new ArrayList<String>();

        final ArrayAdapter<String> aa;

        aa=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,todoitems);

        myListView.setAdapter(aa);

        todoitems.add("Hello");
        todoitems.add("Hi");

     myEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_DOWN)
                    if((keyCode==KeyEvent.KEYCODE_DPAD_CENTER)||(keyCode==KeyEvent.KEYCODE_ENTER))
                    {
                        todoitems.add(0,myEditText.getText().toString());
                        aa.notifyDataSetChanged();
                        myEditText.setText("");
                        return true;
                    }
                return false;
            }
        });






    }
}