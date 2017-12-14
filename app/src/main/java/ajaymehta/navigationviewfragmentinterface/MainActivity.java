package ajaymehta.navigationviewfragmentinterface;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import ajaymehta.navigationviewfragmentinterface.fragment.FirstFragment;
import ajaymehta.navigationviewfragmentinterface.interfaces.Communicator;

import static ajaymehta.navigationviewfragmentinterface.R.layout.app_bar_main;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , Communicator{


    Fragment fragment;
    FragmentManager fragmentManager;

    private ImageView back_button, appicon, icon;
    public static TextView title, badgeCount;
    private ImageView iv_toggle;
    private Animation animSideLeft;
    public Toolbar toolbar;
    private LinearLayout back;
    private RelativeLayout toggle;
    TextView toolbarHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     /*   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // our done code .... bang..
        //====================================================================


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        back_button = (ImageView) findViewById(R.id.back_button);
        appicon = (ImageView) findViewById(R.id.appicon);

        title = (TextView) findViewById(R.id.toolbar_title);
        back = (LinearLayout) findViewById(R.id.back_buttonclick);
        icon = (ImageView) findViewById(R.id.icon);
        iv_toggle = (ImageView) findViewById(R.id.iv_toggle);
        badgeCount = (TextView) findViewById(R.id.badge_icon);
        title.setVisibility(View.VISIBLE);
        title.setText("Product List");
        appicon.setVisibility(View.GONE);

        //toolbar header
    // why i write like below ?
    /*    coz our navigationView (a componenet)[ view]  has got two layout files  1. nav_header_main.xml  and other menu_drawer
   our  ..textView (Toolbar header) a [ view ]      is in nav_header_main.xml file ...
   so  navigationView (pre initlized)  ..i used to get HeaderFile view ... thats textview (could be other textview n imageview) n initlize it .
    * */

    toolbarHeader = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_toolbar_header);


        //++++++++++++++++++++++++++++++++++++++++++++++++++

        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            fragment = new FirstFragment();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.content_main, fragment, "firstfragment");
            fragmentTransaction.commit();

        }


    }   // end of onCreate Method ......


    // our interface method ...
    @Override
    public void response(String data) {

        toolbarHeader.setText(data);

    }

        //====================================================================






    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
