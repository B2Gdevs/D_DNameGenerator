package com.bensquared.epicnamegenerator;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link settings.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link settings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class settings extends Fragment {

    Intent newIntent;
    Intent disclaimerIntent;
    Intent aboutUsIntent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.fragment_settings, container, false);

        newIntent = new Intent(getContext(), howto.class);
        disclaimerIntent = new Intent(getContext(), Disclaimer.class);
        aboutUsIntent = new Intent(getContext(), aboutUS.class);

        final Button howTo = (Button)inflatedView.findViewById(R.id.howTobutton);
        final Button disclaimer =(Button)inflatedView.findViewById(R.id.disclaimerbutton);
        final Button aboutUSbutton = (Button)inflatedView.findViewById(R.id.aboutbutton);
        final TextView info = (TextView)inflatedView.findViewById(R.id.hereIsSomeInfo);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "IMMORTAL.ttf");

        info.setTypeface(typeface);

        howTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(newIntent);
            }
        });

        disclaimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(disclaimerIntent);
            }
        });

        aboutUSbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(aboutUsIntent);
            }
        });

        return inflatedView;
    }

}
