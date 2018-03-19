package com.anthonyestacado.mytasks.tasksview.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.tasksview.fragments.taskslist.TasksListFragment;

public class ActivityTasks extends AppCompatActivity
                            implements NavigationView.OnNavigationItemSelectedListener, IActivityTasks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        //Set up toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainActivityToolbar);
        setSupportActionBar(toolbar);

        //Set up fab
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //Set up navigation drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Initialize default fragment
        TasksListFragment userTasksFragment = new TasksListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Send a parameters which is used in a fragment to determine what type of tasks it must load
        Bundle bundleForFragment = new Bundle();
        bundleForFragment.putString("userTaskSelectionCriteria", String.valueOf(R.string.title_all_tasks));
        userTasksFragment.setArguments(bundleForFragment);

        //Start fragment
        fragmentTransaction.add(R.id.fragment_container, userTasksFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_tasks, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_all_tasks) {
            // Handle the camera action
        } else if (id == R.id.nav_tasks_in_progress) {

        } else if (id == R.id.nav_done_tasks) {

        } else if (id == R.id.nav_agenda) {

        } else if (id == R.id.nav_change_user) {

        } else if (id == R.id.nav_settings) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setToolbarTitle(int resourceID) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainActivityToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(resourceID);
    }

    @Override
    public void expandToolbar() {

    }
}
