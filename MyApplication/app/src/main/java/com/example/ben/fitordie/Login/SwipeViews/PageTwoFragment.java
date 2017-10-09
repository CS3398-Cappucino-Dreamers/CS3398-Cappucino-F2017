package com.example.ben.fitordie.Login.SwipeViews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ben.fitordie.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PageTwoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PageTwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageTwoFragment extends Fragment {



    public PageTwoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PageOneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PageTwoFragment newInstance() {
        PageTwoFragment fragment = new PageTwoFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_two, container, false);
    }

}
