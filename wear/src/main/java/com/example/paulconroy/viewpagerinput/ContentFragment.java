package com.example.paulconroy.viewpagerinput;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by paulconroy on 15/12/2015.
 */
public class ContentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myInflatedView = inflater.inflate(R.layout.content_fragment_layout,
                container,false);





        return myInflatedView;
    }

    public static void stopCycling() {
        // TODO Auto-generated method stub

    }
}
