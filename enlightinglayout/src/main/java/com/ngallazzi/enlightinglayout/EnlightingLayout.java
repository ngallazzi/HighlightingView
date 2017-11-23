package com.ngallazzi.enlightinglayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * Created by Nicola on 2016-11-08.
 */

public class EnlightingLayout extends LinearLayout implements View.OnClickListener {
    private static final String TAG = EnlightingLayout.class.getSimpleName();
    private final int DEFAULT_ANIMATION_DURATION = 700;

    private Drawable mNormalDrawable,mEnlightedDrawable;
    private String mText;
    private int mAnimationDuration;
    private int mEnlightedColor,mEnlightedTextColor,mDefaultTextColor;

    private ImageView ivEnlighting;
    private TextView tvEnlighting;
    private LinearLayout llEnlighting;

    private ProgressBar mPbStatus;

    private TransitionDrawable mTransition;
    private boolean isEnlighted;
    private Context mContext;

    public EnlightingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.EnlightingLayout,
                0, 0);
        try {
            mContext = context;
            mNormalDrawable = a.getDrawable(R.styleable.EnlightingLayout_normalIcon) != null ?
                    a.getDrawable(R.styleable.EnlightingLayout_normalIcon) : ContextCompat.getDrawable(context,R.drawable.ic_bluetooth_searching);
            mEnlightedDrawable = a.getDrawable(R.styleable.EnlightingLayout_enlightedIcon);
            mText = a.getString(R.styleable.EnlightingLayout_text) != null ?
                    a.getString(R.styleable.EnlightingLayout_text) : context.getString(R.string.lorem_ipsum);
            mAnimationDuration = a.getInt(R.styleable.EnlightingLayout_animationDurationInMillis,DEFAULT_ANIMATION_DURATION);
            mEnlightedColor = a.getString(R.styleable.EnlightingLayout_enlightedColor) != null ?
                    Color.parseColor(a.getString(R.styleable.EnlightingLayout_enlightedColor)) : ContextCompat.getColor(context,R.color.default_enlighted_color);
            mEnlightedTextColor = a.getString(R.styleable.EnlightingLayout_enlightedTextColor) != null ?
                    Color.parseColor(a.getString(R.styleable.EnlightingLayout_enlightedTextColor)) : ContextCompat.getColor(context,R.color.default_enlighted_text_color);
            init();
        } finally {
            a.recycle();
        }
    }

    private void init() {
        inflate(getContext(), R.layout.enlighting_layout, this);
        setOnClickListener(this);
        llEnlighting = (LinearLayout) findViewById(R.id.llEnlighting);
        ivEnlighting = (ImageView) findViewById(R.id.ivEnlighting);
        tvEnlighting = (TextView) findViewById(R.id.tvEnlighting);
        mPbStatus = (ProgressBar) findViewById(R.id.pbStatus);
        ivEnlighting.setImageDrawable(mNormalDrawable);
        tvEnlighting.setText(mText);
        mDefaultTextColor = tvEnlighting.getCurrentTextColor();
        ColorDrawable color = new ColorDrawable(mEnlightedColor);
        ColorDrawable alpha = new ColorDrawable(mEnlightedColor);
        alpha.setAlpha(128);
        Drawable[] layers = new Drawable[]{llEnlighting.getBackground(),color};
        mTransition = new TransitionDrawable(layers);
        llEnlighting.setBackground(mTransition);
    }


    public void setEnlighted(Boolean status){
        if (status){
            mTransition.startTransition(mAnimationDuration);
            if (mEnlightedDrawable!=null){
                ivEnlighting.setImageDrawable(mEnlightedDrawable);
            }
            ivEnlighting.setColorFilter(ContextCompat.getColor(mContext,R.color.default_enlighted_text_color));
            tvEnlighting.setTextColor(mEnlightedTextColor);
            mPbStatus.setVisibility(INVISIBLE);
            isEnlighted = true;
        }else{
            if (isEnlighted){
                mTransition.reverseTransition(mAnimationDuration);
                tvEnlighting.setTextColor(mDefaultTextColor);
                ivEnlighting.setImageDrawable(mNormalDrawable);
                ivEnlighting.setColorFilter(null);
                isEnlighted = false;
            }
        }
    }
    public void setText(String text){
        if (text!=null){
            this.tvEnlighting.setText(text);
        }
    }
    public void setImage(Drawable drawable){
        if (drawable!=null){
            this.ivEnlighting.setImageDrawable(drawable);
        }
    }

    public boolean isEnlighted(){
        return isEnlighted;
    }

    public void showProgressBar(){
        mPbStatus.setVisibility(VISIBLE);
    }

    public void hideProgressBar(){
        mPbStatus.setVisibility(INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (!isEnlighted()){
            setEnlighted(true);
        }else{
            setEnlighted(false);
        }
    }

}
