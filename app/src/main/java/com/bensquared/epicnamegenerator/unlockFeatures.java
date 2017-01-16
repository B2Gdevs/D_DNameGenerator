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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link unlockFeatures.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link unlockFeatures#newInstance} factory method to
 * create an instance of this fragment.
 */
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
        donate = (Button) inflatedView.findViewById(R.id.upgradeButton);
        TextView why = (TextView)inflatedView.findViewById(R.id.plainFeatureIdentifier);

        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyClick(v);
            }
        });



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

        String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn0Epad8p2WRF/rTWFs1AFKI2hXINvMRN9RqlDk5NsdMNmjrCUzLG+Y2ojVyKEoFFnVfoXIdqwJjdSIp+cu/mNKO/C/UsQuIshqTCHK5pgxCt63fKhFdb7/vucbvaS1N8QtkFYyjDsWXaRhg73c+JeUOuqmuloG/6RMkTbAFDLMXFNh645DcRX37N90uAA1kBhhypfdctxgECWQs/q/6+331i+azvKIUGb8vGv0G4QIH1h2SZaBRcJQXVtBQ7qixx3e9BMvyuWuG15ObHZNKvEhHNP0goz1Fkn3Ouo/6pCaH5hqUnRVxWXWjwlWut6aK6/6iczeI+6nQJriPVE1NdkQIDAQAB";
        mHelper = new IabHelper(getContext(), base64EncodedPublicKey);

        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener(){
            public void onIabSetupFinished(IabResult result) {
                if (!result.isSuccess()) {
                    Log.d(TAG, "In-app Billing setup failed: " + result);
                }
                else {
                    Log.d(TAG, "In-app Billing is set up OK");
                }
            }

        });

        scrollableText.setTypeface(typeface);
        why.setTypeface(typeface);


        return inflatedView;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(!mHelper.handleActivityResult(requestCode, resultCode, data)){
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    public void buyClick(View view){

        mHelper.launchPurchaseFlow(getActivity(), ITEM_SKU, 10001, mPurchaseFinishedListener, "mypurchasetoken");
    }

    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        @Override
        public void onIabPurchaseFinished(IabResult result, Purchase info) {

            Log.d(TAG, "Purchase finished: " + result + ", purchase: " + info);

            // if we were disposed of in the meantime, quit.
            if (mHelper == null) return;

            if (result.isFailure()) {
                //handling a failure.
                Toast.makeText(getContext(),"Error purchasing: " + result, Toast.LENGTH_LONG);
                return;
            }
            else if (info.getSku().equals(ITEM_SKU)){
                donate.setEnabled(false);

            }

        }
    };

//      Not consuming anything...its a donate button
//    IabHelper.QueryInventoryFinishedListener mRecievedQueryListener = new IabHelper.QueryInventoryFinishedListener() {
//        @Override
//        public void onQueryInventoryFinished(IabResult result, Inventory inv) {
//            if(result.isFailure()){
//                //handle error
//            }
//            else{
//
//                mHelper.consumeAsync(inv.getPurchase(ITEM_SKU), mConsumeFinishedListener);
//            }
//        }
//    };

    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener() {
        @Override
        public void onConsumeFinished(Purchase purchase, IabResult result) {
            if(result.isSuccess()){
                scrollableText.setText("Thanks for helping out even though you didn't need to.  I mean really, I think that" +
                "even though this app is offensive it is something that was done to better oneself and I am happy that" +
                "I have received some reward for attempting to gain more knowledge.");
            }else{
                Toast.makeText(getContext(), "The donation didn't go through.", Toast.LENGTH_LONG);
                donate.setEnabled(true);
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mHelper != null)
            mHelper.dispose();
        mHelper = null;

    }
}
