package com.tearat.my.activity;

import android.animation.Animator;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;

import com.tearat.R;
import com.tearat.base.BaseActivity;
import com.tearat.custom.sidemenu.interfaces.Resourceble;
import com.tearat.custom.sidemenu.interfaces.ScreenShotable;
import com.tearat.custom.sidemenu.model.SlideMenuItem;
import com.tearat.custom.sidemenu.util.ViewAnimator;
import com.tearat.my.Fragment.ContentFragment;

import java.util.ArrayList;
import java.util.List;

import io.codetail.animation.ViewAnimationUtils;
/**
 * Durian
 * 2017-2017/4/12
 */

public class SidemenuMainActivity extends BaseActivity implements ViewAnimator.ViewAnimatorListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private List<SlideMenuItem> list = new ArrayList<>();
    private ContentFragment contentFragment;
    private ViewAnimator viewAnimator;
    private int res = R.mipmap.content_music;
    private LinearLayout linearLayout;
   @Override
    protected int getLayoutId() {
        return R.layout.activity_sidemenu;
    }

    @Override
    public void initView() {
        contentFragment = ContentFragment.newInstance(R.mipmap.content_music);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, contentFragment)
                .commit();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        linearLayout = (LinearLayout) findViewById(R.id.left_drawer);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });


        setActionBar();
        createMenuList();
        viewAnimator = new ViewAnimator(this, list, contentFragment, drawerLayout, this);
    }
    private void createMenuList() {
        SlideMenuItem menuItem0 = new SlideMenuItem(ContentFragment.CLOSE, R.mipmap.icn_close);
        list.add(menuItem0);
        SlideMenuItem menuItem = new SlideMenuItem(ContentFragment.BUILDING, R.mipmap.icn_1);
        list.add(menuItem);
        SlideMenuItem menuItem2 = new SlideMenuItem(ContentFragment.BOOK, R.mipmap.icn_2);
        list.add(menuItem2);
        SlideMenuItem menuItem3 = new SlideMenuItem(ContentFragment.PAINT, R.mipmap.icn_3);
        list.add(menuItem3);
        SlideMenuItem menuItem4 = new SlideMenuItem(ContentFragment.CASE, R.mipmap.icn_4);
        list.add(menuItem4);
        SlideMenuItem menuItem5 = new SlideMenuItem(ContentFragment.SHOP, R.mipmap.icn_5);
        list.add(menuItem5);
        SlideMenuItem menuItem6 = new SlideMenuItem(ContentFragment.PARTY, R.mipmap.icn_6);
        list.add(menuItem6);
        SlideMenuItem menuItem7 = new SlideMenuItem(ContentFragment.MOVIE, R.mipmap.icn_7);
        list.add(menuItem7);
    }
    public void setActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,         /* DrawerLayout object */
                toolbar,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                linearLayout.removeAllViews();
                linearLayout.invalidate();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if (slideOffset > 0.6 && linearLayout.getChildCount() == 0)
                    viewAnimator.showMenuContent();
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }
    @Override
    public void setOnclick() {

    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return null;
    }





    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private ScreenShotable replaceFragment(ScreenShotable screenShotable, int topPosition) {
        this.res = this.res == R.mipmap.content_music ? R.mipmap.content_films : R.mipmap.content_music;
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        Animator animator = ViewAnimationUtils.createCircularReveal(view, 0, topPosition, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);

        findViewById(R.id.content_overlay).setBackgroundDrawable(new BitmapDrawable(getResources(), screenShotable.getBitmap()));
        animator.start();
        ContentFragment contentFragment = ContentFragment.newInstance(this.res);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
        return contentFragment;
    }

    @Override
    public ScreenShotable onSwitch(Resourceble slideMenuItem, ScreenShotable screenShotable, int position) {
        switch (slideMenuItem.getName()) {
            case ContentFragment.CLOSE:
                return screenShotable;
            default:
                return replaceFragment(screenShotable, position);
        }
    }

    @Override
    public void disableHomeButton() {
        getSupportActionBar().setHomeButtonEnabled(false);

    }

    @Override
    public void enableHomeButton() {
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerLayout.closeDrawers();

    }

    @Override
    public void addViewToContainer(View view) {
        linearLayout.addView(view);
    }
}
