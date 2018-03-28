package com.anthonyestacado.mytasks.tasksview.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
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
import android.widget.Toast;

import com.anthonyestacado.mytasks.tasksview.fragments.usertaskeditor.EditUserTaskFragment;
import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.tasksview.fragments.taskslist.TasksListFragment;
import com.anthonyestacado.mytasks.tasksview.fragments.usertaskdetails.UserTaskDetailsFragment;

public class TasksActivity extends AppCompatActivity
                           implements NavigationView.OnNavigationItemSelectedListener,
                                      TasksActivityInterface {

    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    private FloatingActionButton fabAddNewTask;
    private FloatingActionButton fabEditTask;
    private FloatingActionButton fabSaveTask;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        //Set up toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setBackButtonOnToolbarEnabled(false);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar) ;
        appBarLayout.setExpanded(false,true);
        setAppBarOpened(false);

        //Set up fabs
        fabAddNewTask = (FloatingActionButton) findViewById(R.id.fab_add_task);
        fabAddNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadEditUserTaskFragment(0);
            }
        });


        fabEditTask = (FloatingActionButton) findViewById(R.id.fab_edit_task);
        fabEditTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        setFabEditEnabled(false);

        fabSaveTask = (FloatingActionButton) findViewById(R.id.fab_save_task);
        fabSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        setFabSaveEnabled(false);

        //Set up navigation drawer
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setDrawerEnabled(true);

        //load default fragment
        loadUserTasksListFragmentByCriteria(getResources().getString(R.string.title_all_tasks));
    }

    @Override
    public void onResume(){
        super.onResume();

        setFabEditEnabled(false);
        setFabSaveEnabled(false);

        lockToolbar();
        setAppBarOpened(false);

        setBackButtonOnToolbarEnabled(false);

        setDrawerEnabled(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        int fragments = getFragmentManager().getBackStackEntryCount();


        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (getSupportFragmentManager().findFragmentByTag("task editor") instanceof EditUserTaskFragment) {
                getSupportFragmentManager().popBackStack();
            } else {
                if (getSupportFragmentManager().findFragmentByTag("task details") instanceof UserTaskDetailsFragment) {
                    getSupportFragmentManager().popBackStack();
                } else {
                    if ((fragments - 1) == 0) {
                        finish();
                    } else {
                        if (fragments - 1 > 1) {
                            getFragmentManager().popBackStack();
                        } else {
                            if (fragments - 1  == 1) {
                                Toast toast = Toast.makeText(this, R.string.toast_leave_on_backpress, Toast.LENGTH_LONG);
                                toast.show();
                                getFragmentManager().popBackStack();
                            } else {
                                super.onBackPressed();
                            }
                        }
                    }
                }
            }
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

        switch (id) {
            case R.id.home: {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);
                return true;
            }
            case R.id.action_settings: {
                return true;
            }
            case R.id.action_testFragmentTaskDetails: {
                UserTaskDetailsFragment detailsFragment = new UserTaskDetailsFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, detailsFragment, "task details").addToBackStack(null).commit();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_all_tasks) {

            loadUserTasksListFragmentByCriteria(getResources().getString(R.string.title_all_tasks));

        } else if (id == R.id.nav_tasks_in_progress) {

            loadUserTasksListFragmentByCriteria(getResources().getString(R.string.title_tasks_in_progress));

        } else if (id == R.id.nav_done_tasks) {

            loadUserTasksListFragmentByCriteria(getResources().getString(R.string.title_done_tasks));

        } else if (id == R.id.nav_agenda) {

            //TODO: implement agenda as a part of Phase 2
            Toast toast = Toast.makeText(this, "Coming soon", Toast.LENGTH_LONG);
            toast.show();

        } else if (id == R.id.nav_change_user) {

            //TODO: implement multi-user support as a part of Phase 2
            Toast toast = Toast.makeText(this, "Coming soon", Toast.LENGTH_LONG);
            toast.show();

        } else if (id == R.id.nav_settings) {

            //TODO: implement settings as a part of Phase 2
            Toast toast = Toast.makeText(this, "Coming soon", Toast.LENGTH_LONG);
            toast.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setDrawerEnabled(boolean flag) {
        int lockMode = flag ? DrawerLayout.LOCK_MODE_UNLOCKED :
                DrawerLayout.LOCK_MODE_LOCKED_CLOSED;
        drawer.setDrawerLockMode(lockMode);
        toggle.setDrawerIndicatorEnabled(flag);
    }

    @Override
    public void setBackButtonOnToolbarEnabled(boolean flag) {
        if (flag) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public void loadUserTasksListFragmentByCriteria(String criteria) {
        //Initialize fragment
        TasksListFragment userTasksFragment = new TasksListFragment();

                //Send a parameters which is used in a fragment to determine what type of tasks it must load
        Bundle bundleForFragment = new Bundle();
        bundleForFragment.putString("criteria", criteria);
        userTasksFragment.setArguments(bundleForFragment);

        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, userTasksFragment).addToBackStack(null).commit();
    }

    @Override
    public void loadUserTaskDetailsFragment(int userTaskID) {
        UserTaskDetailsFragment detailsFragment = new UserTaskDetailsFragment();

        Bundle bundleForFragment = new Bundle();
        bundleForFragment.putInt("id", userTaskID);
        detailsFragment.setArguments(bundleForFragment);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, detailsFragment, "task details").addToBackStack(null).commit();

    }

    @Override
    public void loadEditUserTaskFragment(int userTaskID) {
        EditUserTaskFragment editorFragment = new EditUserTaskFragment();

        Bundle bundleForFragment = new Bundle();
        bundleForFragment.putInt("id", userTaskID);
        editorFragment.setArguments(bundleForFragment);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, editorFragment, "task editor").addToBackStack(null).commit();
    }

    @Override
    public void setHomeAsUpEnabled(boolean flag) {
        if (flag) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public void setFabAddEnabled(boolean flag){
        if (flag) {
            fabAddNewTask.show();
        } else {
            fabAddNewTask.hide();
        }

    }

    @Override
    public void setFabEditEnabled(boolean flag) {
        if (flag) {
            fabEditTask.show();
        } else {
            fabEditTask.hide();
        }

    }

    @Override
    public void setFabSaveEnabled(boolean flag) {
        if (flag) {
            fabSaveTask.show();
        } else {
            fabSaveTask.hide();
        }

    }

    @Override
    public void expandToolbar() {
        appBarLayout.setExpanded(true,true);
    }

    @Override
    public void lockToolbar() {
        appBarLayout.setExpanded(false,true);
    }

    @Override
    public void setToolbarTitle(String toolbarTitle) {
        collapsingToolbarLayout.setTitleEnabled(false);
        toolbar.setTitle(toolbarTitle);
    }

    @Override
    public void setAppBarOpened(boolean flag) {
        if (flag) {
            appBarLayout.setExpanded(true, true);
            appBarLayout.setActivated(true);

            CoordinatorLayout.LayoutParams params =(CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();

            params.height = (int) getResources().getDimension(R.dimen.app_bar_expanded_height);
            appBarLayout.setLayoutParams(params);
            collapsingToolbarLayout.setTitleEnabled(true);
        } else {
            CoordinatorLayout.LayoutParams params =(CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();

            appBarLayout.setExpanded(false, true);
            appBarLayout.setActivated(false);

            params.height = (int) getResources().getDimension(R.dimen.app_bar_collapsed_height);

            if (params != null) {
                AppBarLayout.Behavior behavior = new AppBarLayout.Behavior();
                behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
                    @Override
                    public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                        return false;
                    }
                });
                params.setBehavior(behavior);
                appBarLayout.setLayoutParams(params);
                collapsingToolbarLayout.setTitleEnabled(false);
            }
        }
    }

}
