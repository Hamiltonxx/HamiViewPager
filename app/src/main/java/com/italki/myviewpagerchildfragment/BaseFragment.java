package com.italki.myviewpagerchildfragment;

import android.support.v4.app.Fragment;

import com.italki.myviewpagerchildfragment.interfaces.PageFragmentListener;

/**
 * Created by Hami on 2014/12/3.
 */
public class BaseFragment extends Fragment {
    private boolean mShowingChild;
    protected PageFragmentListener mListener;

    protected boolean isShowingChild() {
        return mShowingChild;
    }
    protected void setShowingChild(boolean showingChild){
        mShowingChild = showingChild;
    }
}
