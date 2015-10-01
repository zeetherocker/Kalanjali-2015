package com.zap.Kalanjali;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.nineoldandroids.view.ViewHelper;
import com.zap.Kalanjali.EventMasterFlow.EventContent;
import com.zap.Kalanjali.EventMasterFlow.EventItem;
import com.zap.Kalanjali.EventMasterFlow.EventList1;
import com.zap.Kalanjali.EventMasterFlow.EventList2;


/**
 * Fragment with Flexible Space Header
 * Created by chomi3 on 09.12.14.
 */
public class EventActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {
    public static final String TAG = "FlexibleSpaceHeaderFragment";

    private static final int MAIN_ARG = 1111;
    private static final int HOME_ARG = 2222;
    private static final int FIRST_DAY_LIST = 1212;
    private static final int SECOND_DAY_LIST = 2323;

    //@InjectView(R.id.observable_sv)
    ScrollFling mScrollView;

    //@InjectView(R.id.title)
    TextView mTitle; //Title used instead of Toolbar.title
    TextView mEventDesc;
    View mextraView;

    //@InjectView(R.id.toolbar_view)
    Toolbar mToolbarView;

    //@InjectView(R.id.ll_above_photo)
    protected LinearLayout llTintLayer; //Layout that we're tinting when scrolling

    //@InjectView(R.id.fl_image)
    protected FrameLayout flImage; //Layout that hosts the header image

    private int mParallaxImageHeight;
    private int mScrollY = 0; //Keeps track of our scroll.
    private boolean mIsToolbarShown = true;
    private int mToolbarHeight;
    private boolean goingUp = false;

    private int mToolbarBackgroundColor;
    private EventItem CurrentItem = new EventItem();
    private View mView;
    private View mTextView;
    private int rootheight;
    private int textheight;

    int ItemPos = 0;
    int string = 1;
    int string1 = 0;
    int arg;
    int eventLocationId;

    public EventActivity() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Toolbar);
        setContentView(R.layout.event_activity);

        //Store flexible space height
        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);

        mTitle = (TextView) findViewById(R.id.title);
        mEventDesc = (TextView) findViewById(R.id.event_desc);
        mToolbarView = (Toolbar) findViewById(R.id.toolbar_view);
        llTintLayer = (LinearLayout) findViewById(R.id.ll_above_photo);
        flImage = (FrameLayout) findViewById(R.id.fl_image);
        mextraView = findViewById(R.id.extra_view);

        Bundle b = getIntent().getExtras();
        arg = b.getInt("arg");
        ItemPos = b.getInt("pos");
        string = b.getInt("title");
        string1 = b.getInt("desc");

        switch (arg) {
            case MAIN_ARG:
                mTitle.setText(getString(string));
                mEventDesc.setText(getString(string1));
                mextraView.setMinimumHeight((int) getResources().getDimension(R.dimen.extra_view_height));
                break;

            case HOME_ARG :
                CurrentItem = EventContent.ITEMS.get(ItemPos);
                mTitle.setText(getString(CurrentItem.title));
                mEventDesc.setText(getString(CurrentItem.event_desc));
                eventLocationId = CurrentItem.eventLocationId;
                break;

            case FIRST_DAY_LIST :
                CurrentItem = EventList1.ITEMS.get(ItemPos);
                mTitle.setText(getString(CurrentItem.title));
                mEventDesc.setText(getString(CurrentItem.event_desc));
                eventLocationId = CurrentItem.eventLocationId;
                break;

            case SECOND_DAY_LIST :
                CurrentItem = EventList2.ITEMS.get(ItemPos);
                mTitle.setText(getString(CurrentItem.title));
                mEventDesc.setText(getString(CurrentItem.event_desc));
                eventLocationId = CurrentItem.eventLocationId;
                break;

        }
        mScrollView = (ScrollFling) findViewById(R.id.observable_sv);

        configureToolbarView();
        configureScrollView();
        getFloatingActionButton();

    }

    public void getFloatingActionButton() {

        FloatingActionsMenu button = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
        drawable.getPaint().setColor(getResources().getColor(R.color.white));

        final FloatingActionButton actionA = (FloatingActionButton) findViewById(R.id.action_a);
        actionA.setIcon(R.drawable.ic_map_button);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventActivity.this, Locate_us.class);
                Bundle b = new Bundle();
                b.putInt("cameraPos", eventLocationId);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        final FloatingActionButton actionB = (FloatingActionButton) findViewById(R.id.action_b);
        actionB.setIcon(R.drawable.ic_register);
        actionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EventActivity.this, "Working on it", Toast.LENGTH_SHORT).show();
            }
        });

        if (arg == MAIN_ARG){
            button.setVisibility(View.GONE);
        }

    }

    private void configureScrollView() {
        mScrollView.setScrollViewCallbacks(this);
        mScrollView.setOverScrollMode(View.OVER_SCROLL_NEVER);

        mScrollView.setOnFlingListener(new ScrollFling.OnFlingListener() {
            @Override
            public void onFlingStarted() {
                if (goingUp && !mIsToolbarShown) {
                    showFullToolbar(50);
                }
            }

            @Override
            public void onFlingStopped() {

            }
        });

        ViewTreeObserver vto = mTitle.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    mTitle.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    mTitle.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                updateFlexibleSpaceText(0);
            }
        });
    }

    private void configureToolbarView() {
        setSupportActionBar(mToolbarView);
        mToolbarView.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        mToolbarView.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventActivity.this.onBackPressed();
            }
        });

        //Remove toolbars title, as we have our own title implementation
        mToolbarView.post(new Runnable() {
            @Override
            public void run() {
                mToolbarView.setTitle("");

            }
        });

        mToolbarBackgroundColor = getResources().getColor(R.color.colorPrimary);
        TypedValue tv = new TypedValue();
        if (EventActivity.this.getTheme().resolveAttribute(R.attr.actionBarSize, tv, true)) {
            mToolbarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }
        setBackgroundAlpha(mToolbarView, 0.0f, mToolbarBackgroundColor);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (arg == MAIN_ARG)
            getMenuInflater().inflate(R.menu.menu_main, menu);
        else
            getMenuInflater().inflate(R.menu.menu_event, menu);
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
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        if (id == R.id.action_maps) {
            Intent intent = new Intent(this, Locate_us.class);
            Bundle b = new Bundle();
            b.putInt("cameraPos", eventLocationId);
            intent.putExtras(b);
            startActivity(intent);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        //Store actual scroll state:
        if (mScrollY > scrollY) {
            goingUp = true;
        } else if (mScrollY < scrollY) {
            goingUp = false;
        }

        //If we're close to edge, show toolbar faster
        if (mScrollY - scrollY > 50 && !mIsToolbarShown) {
            showFullToolbar(50); //speed up
        } else if (mScrollY - scrollY > 0 && scrollY <= mParallaxImageHeight && !mIsToolbarShown) {
            showFullToolbar(250);
        }

        //Show or hide full toolbar color, so it will become visible over scrollable content:
        if (scrollY >= mParallaxImageHeight - mToolbarHeight) {
            setBackgroundAlpha(mToolbarView, 1, mToolbarBackgroundColor);
        } else {
            setBackgroundAlpha(mToolbarView, 0, mToolbarBackgroundColor);
        }

        //Translate flexible image in Y axis
        ViewHelper.setTranslationY(flImage, scrollY / 2);

        //Calculate flexible space alpha based on scroll state
        float alpha = 1 - (float) Math.max(0, mParallaxImageHeight - (mToolbarHeight) - scrollY) / (mParallaxImageHeight - (mToolbarHeight * 1.5f));
        setBackgroundAlpha(llTintLayer, alpha, mToolbarBackgroundColor);

        //Store last scroll state
        mScrollY = scrollY;

        //Move the flexible text
        updateFlexibleSpaceText((scrollY));
    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

        //If we're scrolling up, and are too far away from toolbar, hide it:
        if (scrollState == ScrollState.UP) {
            if (mScrollY > mParallaxImageHeight) {
                if (mIsToolbarShown) {
                    hideFullToolbar();
                }
            } else {
                // Don't hide toolbar yet
            }
        } else if (scrollState == ScrollState.DOWN) {
            //Show toolbar as fast as we're starting to scroll down
            if (!mIsToolbarShown) {
                showFullToolbar(250);
            }
        }
    }

    private void setBackgroundAlpha(View view, float alpha, int baseColor) {
        int a = Math.min(255, Math.max(0, (int) (alpha * 255))) << 24;
        int rgb = 0x00ffffff & baseColor;
        view.setBackgroundColor(a + rgb);
    }


    public void showFullToolbar(int duration) {
        mIsToolbarShown = true;

        final AnimatorSet animatorSet = buildAnimationSet(duration,
                buildAnimation(mToolbarView, -mToolbarHeight, 0),
                buildAnimation(mTitle, -mToolbarHeight, 0));

        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                updateFlexibleSpaceText(mScrollY); //dirty update fling-fix
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                updateFlexibleSpaceText(mScrollY); //dirty update fling-fix
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animatorSet.start();

    }

    private ObjectAnimator buildAnimation(View view, float from, float to) {
        return ObjectAnimator
                .ofFloat(view, View.TRANSLATION_Y, from, to);
    }

    public void hideFullToolbar() {
        mIsToolbarShown = false;
        final AnimatorSet animatorSet = buildAnimationSet(250,
                buildAnimation(mToolbarView, 0, -mToolbarHeight),
                buildAnimation(mTitle, 0, -mToolbarHeight));
        animatorSet.start();
    }

    private AnimatorSet buildAnimationSet(int duration, ObjectAnimator... objectAnimators) {

        AnimatorSet a = new AnimatorSet();
        a.playTogether(objectAnimators);
        a.setInterpolator(AnimationUtils.loadInterpolator(EventActivity.this, android.R.interpolator.accelerate_decelerate));
        a.setDuration(duration);

        return a;
    }

    /**
     * Scale title view and move it in Flexible space
     * @param scrollY
     */
    private void updateFlexibleSpaceText(final int scrollY) {
        if (!mIsToolbarShown) return;

        int adjustedScrollY = scrollY;
        if (scrollY < 0) {
            adjustedScrollY = 0;
        } else if (scrollY > mParallaxImageHeight) {
            adjustedScrollY = mParallaxImageHeight;
        }

        float maxScale = 0.1f;
        float scale = maxScale * ((float) (mParallaxImageHeight - mToolbarHeight) - adjustedScrollY) / (mParallaxImageHeight - mToolbarHeight);
        if (scale < 0) {
            scale = 0;
        }

        ViewHelper.setPivotX(mTitle, 0);
        ViewHelper.setPivotY(mTitle, 0);
        ViewHelper.setScaleX(mTitle, 1 + scale);
        ViewHelper.setScaleY(mTitle, 1 + scale);

        int maxTitleTranslation = (int) (mParallaxImageHeight * 0.75f);
        int titleTranslation = (int) (maxTitleTranslation * ((float) scale / maxScale));
        ViewHelper.setTranslationY(mTitle, titleTranslation);
    }
}