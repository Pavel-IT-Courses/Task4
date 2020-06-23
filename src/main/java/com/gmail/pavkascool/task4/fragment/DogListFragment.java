package com.gmail.pavkascool.task4.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.pavkascool.task4.R;
import com.gmail.pavkascool.task4.db.DogDatabaseHelper;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DogListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DogListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DogListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DogListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DogListFragment newInstance(String param1, String param2) {
        DogListFragment fragment = new DogListFragment();
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
//        SQLiteDatabase db = DogDatabaseHelper.getInstance().getReadableDatabase();
//        Cursor c = db.query("dogs", null, null, null, null, null, null);
//        if (c.moveToFirst()) {
//
//            // определяем номера столбцов по имени в выборке
//            int idColIndex = c.getColumnIndex("id");
//            int nameColIndex = c.getColumnIndex("name");
//            int ageColIndex = c.getColumnIndex("age");
//            int breedColIndex = c.getColumnIndex("breed");
//
//            do {
//                // получаем значения по номерам столбцов и пишем все в лог
//                Log.d("DATABASE",
//                        "ID = " + c.getInt(idColIndex) +
//                                ", name = " + c.getString(nameColIndex) +
//                                ", age = " + c.getString(ageColIndex));
//                // переход на следующую строку
//                // а если следующей нет (текущая - последняя), то false - выходим из цикла
//            } while (c.moveToNext());
//        } else
//            Log.d("DATABASE", "0 rows");
//        c.close();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dog_list, container, false);
    }
}
