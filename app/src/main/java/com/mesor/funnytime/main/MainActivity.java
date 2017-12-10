package com.mesor.funnytime.main;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.mesor.funnytime.R;
import com.mesor.funnytime.base.BaseActivity;
import com.mesor.funnytime.main.model.MainPresenter;
import com.mesor.funnytime.main.model.MainView;
import com.mesor.funnytime.main.model.Media;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView, XRecyclerView.LoadingListener {

    @BindView(R.id.recyclerView)
    XRecyclerView xRecyclerView;
    @BindView((R.id.toolbar))
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private MainPresenter mainPresenter;

    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(view -> {
        });

        DrawerLayout drawer = findViewById(R.id.rootView);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        xRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
        xRecyclerView.setLoadingListener(this);
        initPresenter();
    }

    void initPresenter() {
        mainPresenter = new MainPresenter();
        presenter = mainPresenter;
    }

    void initRecyclerView() {
        mayRequestPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, new OnRequestPermissionSuccessListener() {
            @Override
            public void onSuccess() {
                xRecyclerView.refresh();
                mainPresenter.refreshMediaList();
            }

            @Override
            public void onFailed() {
                prompt(R.string.prompt_permission_storage, () -> initRecyclerView());
            }
        });
    }

    @Override
    public void refresh(List<Media> list) {
        if (mainAdapter == null) {
            mainAdapter = new MainAdapter(this, media -> {
                //TODO
            });
            xRecyclerView.setAdapter(mainAdapter);
        }
        mainAdapter.setContent(list);
    }

    @Override
    public void onLoadMore() {
        mainPresenter.loadMoreMedia();
    }

    @Override
    public void onRefresh() {
        mainPresenter.refreshMediaList();
    }

    @Override
    public void stopLoading() {
        xRecyclerView.refreshComplete();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mainAdapter == null || mainAdapter.getItemCount() == 0) {
            initRecyclerView();
        }
    }

    @Override
    protected void onPause() {
        xRecyclerView.refreshComplete();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.rootView);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {
        } else if (id == R.id.nav_slideshow) {
        } else if (id == R.id.nav_manage) {
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }

        DrawerLayout drawer = findViewById(R.id.rootView);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
