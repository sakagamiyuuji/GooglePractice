package com.e.googlepractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;
    public final static String EXTRA_MESSAGE = "extra_message";

    private EditText msgEdit1;
    private TextView headReply, txtReply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgEdit1 = findViewById(R.id.msg_edit1);
        headReply = findViewById(R.id.text_header);
        txtReply =findViewById(R.id.text_message_reply);


    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Clicked");
        Intent connect = new Intent(MainActivity.this, SecondActivity.class);
        String message = msgEdit1.getText().toString();
        connect.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(connect, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                headReply.setVisibility(View.VISIBLE);
                txtReply.setText(reply);
                txtReply.setVisibility(View.VISIBLE);
            }
        }
    }
}
