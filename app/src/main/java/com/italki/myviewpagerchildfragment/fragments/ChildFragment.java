package com.italki.myviewpagerchildfragment.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.italki.myviewpagerchildfragment.BaseFragment;
import com.italki.myviewpagerchildfragment.R;

/**
 * Created by Hami on 2014/12/3.
 */
public class ChildFragment extends BaseFragment {
    private String mTitle;

    public ChildFragment(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText("-- Child fragment : " + mTitle);
        return view;
    }

    public static ChildFragment newInstance(String mTitle){
        return new ChildFragment(mTitle);
    }
}
