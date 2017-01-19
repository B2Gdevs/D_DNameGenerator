package com.bensquared.epicnamegenerator;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bensquared.epicnamegenerator.util.IabHelper;
import com.bensquared.epicnamegenerator.util.IabResult;
import com.bensquared.epicnamegenerator.util.Purchase;



public class unlockFeatures extends Fragment {
    TextView scrollableText;
    GestureDetectorCompat gestureDectector;
    Context context;
    private static final String TAG = "InAppBilling";
    IabHelper mHelper;
    static final String ITEM_SKU = "com.bensquared.donatetest";
    Button donate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.fragment_unlock_features, container, false);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "IMMORTAL.ttf");

        scrollableText = (TextView)inflatedView.findViewById(R.id.featuresText);
        TextView why = (TextView)inflatedView.findViewById(R.id.plainFeatureIdentifier);

        scrollableText.setTypeface(typeface);
        why.setTypeface(typeface);
        scrollableText.setMovementMethod(new ScrollingMovementMethod());
        scrollableText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDectector.onTouchEvent(event);

                return false;
            }
        });


        gestureDectector = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
                return super.onFling(e1, e2, velocityX, velocityY);

            }
        });

return inflatedView;
}


}
