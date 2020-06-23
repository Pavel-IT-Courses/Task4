package com.gmail.pavkascool.task4.fragment;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gmail.pavkascool.task4.R;
import com.gmail.pavkascool.task4.db.DogDatabaseHelper;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddDogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddDogFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText name;
    private EditText age;
    private EditText breed;
    private Button add;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddDogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddDogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddDogFragment newInstance(String param1, String param2) {
        AddDogFragment fragment = new AddDogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_dog, container, false);
        name = view.findViewById(R.id.add_name);
        age = view.findViewById(R.id.add_age);
        breed = view.findViewById(R.id.add_breed);
        add = view.findViewById(R.id.button_add);
        add.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_add) {
            String dogName = name.getText().toString();
            if (!dogName.isEmpty()) {
                ContentValues cv = new ContentValues();
                cv.put("name", dogName);
                cv.put("age", age.getText().toString());
                cv.put("breed", breed.getText().toString());
                DogDatabaseHelper helper = DogDatabaseHelper.getInstance();
                SQLiteDatabase db = helper.getReadableDatabase();
                db.insert("dogs", null, cv);
                helper.close();
            }
        }
    }
}
