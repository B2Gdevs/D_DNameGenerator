package com.bensquared.epicnamegenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class howto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howto);

        TextView scrollableText = (TextView)findViewById(R.id.FullHowToTextinhowto);

        scrollableText.setMovementMethod(new ScrollingMovementMethod());

    }
}
