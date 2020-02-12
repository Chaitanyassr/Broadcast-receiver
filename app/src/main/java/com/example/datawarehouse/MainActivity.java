package com.example.datawarehouse;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView picView = (ImageView) findViewById(R.id.imageView);
        TextView txtView = (TextView) findViewById(R.id.txt);

        Intent receivedIntent = getIntent();
        String receivedAction = receivedIntent.getAction();
        String receivedType = receivedIntent.getType();

        if (receivedAction.equals(Intent.ACTION_SEND)){
            if(receivedType.startsWith("text/")){
                picView.setVisibility(View.GONE);
                String receivedText = receivedIntent.getStringExtra(Intent.EXTRA_TEXT);
                if (receivedText != null){
                    textView.setText(receivedText);

                }

            }else if (receivedType.startsWith("image/")){
                txtView.setVisibility(View.GONE);
                Uri receivedUri = (Uri) receivedIntent.getParcelableExtra(Intent.EXTRA_STREAM);
                if (receivedAction.equals(Intent.ACTION_MAIN)){
                    Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                }
                
            }
        }

    }
}

