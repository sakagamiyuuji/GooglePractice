package com.e.googlepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button balas;
    private EditText msgEdit2;
    private TextView headSend, txtSend;

    public static final String EXTRA_REPLY = "extra_reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        headSend = findViewById(R.id.text_header_send);
        txtSend = findViewById(R.id.text_message_reply);
        balas = findViewById(R.id.btn_reply);
        msgEdit2 = findViewById(R.id.msg_edit2);

        Intent connect = getIntent();
        String message = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        headSend.setVisibility(View.VISIBLE);
        txtSend.setText(message);
        txtSend.setVisibility(View.VISIBLE);

    }

    public void returnReply(View view) {
        String reply = msgEdit2.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
