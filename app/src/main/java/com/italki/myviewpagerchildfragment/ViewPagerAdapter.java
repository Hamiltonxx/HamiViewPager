package com.italki.myviewpagerchildfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.italki.myviewpagerchildfragment.fragments.ChildFragment;
import com.italki.myviewpagerchildfragment.fragments.FirstPageFragment;
import com.italki.myviewpagerchildfragment.fragments.SecondPageFragment;
import com.italki.myviewpagerchildfragment.fragments.ThirdPageFragment;
import com.italki.myviewpagerchildfragment.interfaces.PageFragmentListener;

/**
 * Created by Hami on 2014/12/3.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter{
    private BaseFragment mFragmentAtPos1;
    private BaseFragment mFragmentAtPos2;
    private final FragmentManager mFragmentManager;

    private static final int NUM_OF_ITEMS = 3; // No of ViewPager items

    private static final String STR_CHILD_TAG_2 = " -> child fragment of tag 2";
    private static final String STR_CHILD_TAG_3 = " -> child fragment of tag 3";

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 1){
            if(mFragmentAtPos1 == null){
                mFragmentAtPos1 = SecondPageFragment.newInstance(new PageFragmentListener() {
                    @Override
                    public void onSwitchToNextFragment() {
                        mFragmentManager.beginTransaction().remove(mFragmentAtPos1).commit();
                        mFragmentAtPos1 = ChildFragment.newInstance(STR_CHILD_TAG_2);
                        mFragmentAtPos1.setShowingChild(true);
                        notifyDataSetChanged();
                    }
                });
            }
            return mFragmentAtPos1;
        }else if(position == 2){
            if(mFragmentAtPos2 == null){
                mFragmentAtPos2 = ThirdPageFragment.newInstance(new PageFragmentListener() {
                    @Override
                    public void onSwitchToNextFragment() {
                        mFragmentManager.beginTransaction().remove(mFragmentAtPos2).commit();
                        mFragmentAtPos2 = ChildFragment.newInstance(STR_CHILD_TAG_3);
                        mFragmentAtPos2.setShowingChild(true);
                        notifyDataSetChanged();
                    }
                });
            }
            return mFragmentAtPos2;
        }

        return FirstPageFragment.newInstance(); /*****************/
    }

    @Override
    public int getCount() {
        return NUM_OF_ITEMS;
    }

    @Override
    public int getItemPosition(Object object) {
//        if(object instanceof SecondPageFragment && mFragmentAtPos1 instanceof ChildFragment){
//            return POSITION_NONE;
//        }else if(object instanceof  ThirdPageFragment && mFragmentAtPos2 instanceof ChildFragment){
//            return POSITION_NONE;
//        }else if(object instanceof ChildFragment){
//            return POSITION_NONE;
//        }
//        return POSITION_UNCHANGED;
        return POSITION_NONE;
    }

    public void replaceChildFragment(BaseFragment oldFrg, int position){
        switch (position){
        case 1:
            mFragmentManager.beginTransaction().remove(oldFrg).commit();
            mFragmentAtPos1 = SecondPageFragment.newInstance(new PageFragmentListener() {
                @Override
                public void onSwitchToNextFragment() {
                    mFragmentManager.beginTransaction().remove(mFragmentAtPos1).commit();
                    mFragmentAtPos1 = ChildFragment.newInstance(STR_CHILD_TAG_2);
                    mFragmentAtPos1.setShowingChild(true);
                    notifyDataSetChanged();
                }
            });
            notifyDataSetChanged();
            break;
        case 2:
            mFragmentManager.beginTransaction().remove(oldFrg).commit();
            mFragmentAtPos2 = ThirdPageFragment.newInstance(new PageFragmentListener() {
                public void onSwitchToNextFragment() {
                    mFragmentManager.beginTransaction().remove(mFragmentAtPos2).commit();
                    mFragmentAtPos2 = ChildFragment.newInstance(STR_CHILD_TAG_3);
                    mFragmentAtPos2.setShowingChild(true);
                    notifyDataSetChanged();
                }
            });
            notifyDataSetChanged();
            break;
        default:
            break;
        }
    }
}
