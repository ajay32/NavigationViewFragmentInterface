package ajaymehta.navigationviewfragmentinterface.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ajaymehta.navigationviewfragmentinterface.R;
import ajaymehta.navigationviewfragmentinterface.interfaces.Communicator;


/**
 * Created by vaibhav chugh on 2/17/2017.
 */

public class FirstFragment extends Fragment {

    private static final String TAG = "FirstFragment";


    Fragment fragment;


    private Toolbar toolbar;
    private ImageView back_button, appicon, icon;
    private TextView toolbarHeading, badgeCount;
    private LinearLayout back;
    private FragmentManager fragmentManager;
    Context context;
    ImageView iv_toggle;
    RelativeLayout toggle;
    EditText et_enterdata;
    Communicator com;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_fragment, container, false);

        fragmentManager = getFragmentManager();

        init(v);
        onCreate(savedInstanceState);
        return v;
    }

    private void init(View v) {
        et_enterdata = (EditText) v.findViewById(R.id.et_enterdata);


        et_enterdata.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {  // when this method is called i need context  context ..so that it work at the same time in the mainActiviy..

                // seding data to amother fragment or activity ..its all about context ... you can see context from here see below ..or using LifeCycle Method ..onAttach()
                //  com = (Communicator)getActivity();
                String et_enterdata1 = et_enterdata.getText().toString();  // getting data from edit Text box
                com.response(et_enterdata1);       // sending data to Interface method (in main Activity)
                toolbarHeading.setText(et_enterdata1);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    // see onAttach .. method ...continiously listen in main Activity .... so we can pass context here to mainActivity ...
    // or just dont pass here ...(till your fragment is connected to main Acitivity it gets called ..u above on textChanged method ....
    //  com = (Communicator)getActivity();  <-- i have written context ...but i commented it coz from onAttac() method i sending context ..till fragmnet n Activity connected..context is always there as passed.


    @Override
    public void onAttach(Activity activity) {    // containing local context ..
        super.onAttach(activity);

         com = (Communicator) activity;


    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);


        back_button = (ImageView) toolbar.findViewById(R.id.back_button);
        appicon = (ImageView) toolbar.findViewById(R.id.appicon);

        toolbarHeading = (TextView) toolbar.findViewById(R.id.toolbar_title);
        back = (LinearLayout) toolbar.findViewById(R.id.back_buttonclick);
        icon = (ImageView) toolbar.findViewById(R.id.icon);
        iv_toggle = (ImageView) toolbar.findViewById(R.id.iv_toggle);

        iv_toggle.setVisibility(View.VISIBLE);
        badgeCount = (TextView) toolbar.findViewById(R.id.badge_icon);


        toolbarHeading.setVisibility(View.VISIBLE);
        toolbarHeading.setText("Fragment Toolbar");


        appicon.setVisibility(View.GONE);

        toggle = (RelativeLayout) toolbar.findViewById(R.id.toggle);
        toggle.setVisibility(View.VISIBLE);

    }


}