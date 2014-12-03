package com.italki.myviewpagerchildfragment.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.italki.myviewpagerchildfragment.BaseFragment;
import com.italki.myviewpagerchildfragment.R;
import com.italki.myviewpagerchildfragment.interfaces.PageFragmentListener;

/**
 * Created by Hami on 2014/12/3.
 */
public class ThirdPageFragment extends BaseFragment {
    public ThirdPageFragment() {
    }
    public ThirdPageFragment(PageFragmentListener listener){
        this.mListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText("ThirdPageFragment");
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.onSwitchToNextFragment();
                }
            }
        });
        return view;
    }

    public static ThirdPageFragment newInstance(PageFragmentListener listener){
        return new ThirdPageFragment(listener);
    }
}
