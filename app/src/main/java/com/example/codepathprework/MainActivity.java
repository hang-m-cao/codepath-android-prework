package com.example.codepathprework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Boolean textChanged = false;
    private TextView text;
    private EditText inputText;
    private Boolean bgChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textLabel);
        Button changeTextButton = (Button) findViewById(R.id.textColorButton);
        Button changeText = (Button) findViewById(R.id.textLabelButton);
        Button bgColorButton = (Button) findViewById(R.id.backgroundColorButton);
        inputText = (EditText) findViewById(R.id.inputText);
        View layout = (View) findViewById(R.id.screen);

        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textChanged){
                    text.setTextColor(Color.BLACK);
                }
                else{
                    text.setTextColor(Color.WHITE);

                }
                textChanged = !textChanged;
            }
        });

        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String changeTo = inputText.getText().toString();
                String noInput = getResources().getString(R.string.no_input_default);
                if (changeTo.length() > 0){
                    text.setText(changeTo);
                }
                else{
                    text.setText(noInput);
                    Toast.makeText(MainActivity.this, "Enter some text above to customize it", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bgColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bgChanged){
                    layout.setBackground(new ColorDrawable(ContextCompat.getColor(MainActivity.this, R.color.teal_200)));
                }
                else{
                    layout.setBackground(new ColorDrawable(ContextCompat.getColor(MainActivity.this, R.color.pink)));
                }
                bgChanged = !bgChanged;
            }
        });

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(getResources().getString(R.string.default_label));
                text.setTextColor(Color.WHITE);
                textChanged = false;
                layout.setBackground(new ColorDrawable(ContextCompat.getColor(MainActivity.this, R.color.purple_200)));
                inputText.setText("");
            }
        });
    }
}