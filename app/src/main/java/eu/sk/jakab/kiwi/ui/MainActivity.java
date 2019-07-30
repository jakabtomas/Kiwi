package eu.sk.jakab.kiwi.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import eu.sk.jakab.kiwi.R;
import eu.sk.jakab.kiwi.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainActivityInterface{
    private static final String FRAGMENT_TAG_LIST  = "list";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            FragmentManager fm = getSupportFragmentManager();

            ListFragment listFragment = (ListFragment) fm.findFragmentByTag(FRAGMENT_TAG_LIST);
            if(listFragment!=null){
                new ListPresenter(listFragment);
            }
        }else {
            openFlightsList();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getSupportFragmentManager().getBackStackEntryCount()==0){
            finish();
        }
    }

    private void openFlightsList() {
        ListFragment listFragment = ListFragment.newInstance();
        replaceFragment(listFragment, null, R.id.fragment_main, FRAGMENT_TAG_LIST, true);
        new ListPresenter(listFragment);
    }
}
