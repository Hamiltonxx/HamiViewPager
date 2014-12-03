package com.italki.myviewpagerchildfragment.fragments;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import com.italki.myviewpagerchildfragment.BaseFragment;
        import com.italki.myviewpagerchildfragment.R;

/**
 * First fragment.
 */
public class FirstPageFragment extends BaseFragment {

    public FirstPageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        TextView tv = (TextView)view.findViewById(R.id.textView);
        tv.setText("FirstPageFragment");
        return view;
    }

    public static FirstPageFragment newInstance() {
        return new FirstPageFragment();
    }

}