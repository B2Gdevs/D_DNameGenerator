package layout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bensquared.epicnamegenerator.R;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link saved.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link saved#newInstance} factory method to
 * create an instance of this fragment.
 */
public class saved extends Fragment{


    SharedPreferences sharedMale;
    SharedPreferences sharedFemale;
 //   SharedPreferences neitherGender;
    String maleNameList = "maleNameList";
    String femaleNameList = "femaleNameList";
  //  String neitherNameList ="neitherNameList";
    int counter = 0;
    List<String> nameHolder = new ArrayList<>();
    ListAdapter savedAdapter;
    ListView savedList;
    Spinner savedSelector;
    Button clearButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.fragment_saved, container, false);

        savedList = (ListView) inflatedView.findViewById(R.id.savedList);
        savedSelector = (Spinner) inflatedView.findViewById(R.id.savedSelector);
        clearButton = (Button)inflatedView.findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext(), android.R.style.Theme_DeviceDefault_Light_Dialog_Alert)
                        .setTitle("Delete Names")
                        .setMessage("Do you really want to delete the names?")
                        .setIcon(R.drawable.trash)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(getContext(), "Names cleared forever", Toast.LENGTH_SHORT).show();
                                nameHolder.clear();
                                if(savedSelector.getSelectedItemPosition() == 0)
                                sharedMale.edit().clear().apply();
                                else if(savedSelector.getSelectedItemPosition() == 1)
                                    sharedFemale.edit().clear().apply();
//                                else
//                                    neitherGender.edit().clear().apply();
                                savedList.setAdapter(savedAdapter);
                            }})
                        .setNegativeButton(android.R.string.no, null).show();

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                savedAdapter = new ArrayAdapter<>(getContext(), R.layout.listviewcustom, nameHolder);
                ArrayAdapter<String> savedSelectorAdapter = new ArrayAdapter<>(getContext(), R.layout.spinner_dropdownlayout, getResources().getStringArray(R.array.saved));
                savedSelector.setAdapter(savedSelectorAdapter);
                savedList.setAdapter(savedAdapter);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                savedSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (savedSelector.getSelectedItemPosition() == 0) {

                            nameHolder.clear();
                            Map<String, ?> keys = sharedMale.getAll();
                            counter = keys.size();

                            if (counter != 0) {
                                for (int i = 0; i < counter; counter--)
                                    nameHolder.add(sharedMale.getString(Integer.toString(counter - 1), Integer.toString(counter - 1)));

                            }
                            savedList.setAdapter(savedAdapter);

                        }
                        else if(savedSelector.getSelectedItemPosition() == 1){

                            nameHolder.clear();
                            Map<String, ?> keys = sharedFemale.getAll();
                            counter = keys.size();

                            if (counter != 0) {
                                for (int i = 0; i < counter; counter--)
                                    nameHolder.add(sharedFemale.getString(Integer.toString(counter - 1), Integer.toString(counter - 1)));
                            }

                            savedList.setAdapter(savedAdapter);

                        }
//                        else{
//
//                            nameHolder.clear();
//                            Map<String, ?> keys = neitherGender.getAll();
//                            counter = keys.size();
//
//                            if (counter != 0) {
//                                for (int i = 0; i < counter; counter--)
//                                    nameHolder.add(neitherGender.getString(Integer.toString(counter - 1), Integer.toString(counter - 1)));
//                            }
//
//                            savedList.setAdapter(savedAdapter);
//
//                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

        }).start();

        sharedMale = getContext().getSharedPreferences(maleNameList, Context.MODE_PRIVATE);
        sharedFemale = getContext().getSharedPreferences(femaleNameList, Context.MODE_PRIVATE);
     //   neitherGender = getContext().getSharedPreferences(neitherNameList, Context.MODE_PRIVATE);

        nameHolder.clear();

        // 0 is for male and 1 is for female
        if (savedSelector.getSelectedItemPosition() == 0) {
            if (nameHolder.isEmpty()) {

                Map<String, ?> keys = sharedMale.getAll();
                counter = keys.size();

                if (counter != 0) {
                    for (int i = 0; i < counter; counter--)
                        nameHolder.add(sharedMale.getString(Integer.toString(counter - 1), "null"));
                }
            }
        } else if(savedSelector.getSelectedItemPosition() == 1) {
            if (nameHolder.isEmpty()) {

                Map<String, ?> keys = sharedFemale.getAll();
                counter = keys.size();

                if (counter != 0) {
                    for (int i = 0; i < counter; counter--)
                        nameHolder.add(sharedFemale.getString(Integer.toString(counter - 1), "null"));

                }
            }
//            else{
//                if (nameHolder.isEmpty()) {
//
//                    Map<String, ?> keys = neitherGender.getAll();
//                    counter = keys.size();
//
//                    if (counter != 0) {
//                        for (int i = 0; i < counter; counter--)
//                            nameHolder.add(neitherGender.getString(Integer.toString(counter - 1), "null"));
//
//
//                    }
           //     }
         //   }
        }

        return inflatedView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser) {
                    if (savedSelector.getSelectedItemPosition() == 0) {

                        nameHolder.clear();
                        Map<String, ?> keys = sharedMale.getAll();
                        counter = keys.size();

                        if (counter != 0) {
                            for (int i = 0; i < counter; counter--)
                                nameHolder.add(sharedMale.getString(Integer.toString(counter - 1), Integer.toString(counter - 1)));

                        }
                        savedList.setAdapter(savedAdapter);


                    }
                    else if(savedSelector.getSelectedItemPosition() == 1){

                        nameHolder.clear();
                        Map<String, ?> keys = sharedFemale.getAll();
                        counter = keys.size();

                        if (counter != 0) {
                            for (int i = 0; i < counter; counter--)
                                nameHolder.add(sharedFemale.getString(Integer.toString(counter - 1), Integer.toString(counter - 1)));
                        }

                        savedList.setAdapter(savedAdapter);

                    }
//                    else {
//
//                        nameHolder.clear();
//                        Map<String, ?> keys = neitherGender.getAll();
//                        counter = keys.size();
//
//                        if (counter != 0) {
//                            for (int i = 0; i < counter; counter--)
//                                nameHolder.add(neitherGender.getString(Integer.toString(counter - 1), Integer.toString(counter - 1)));
//                        }
//                        savedList.setAdapter(savedAdapter);
//
//                    }
                }
        }
}
