package com.ngallazzi.highlightingview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * Created by Nicola on 2016-11-08.
 */

public class HighlightingView extends LinearLayout {
    private final int DEFAULT_ANIMATION_DURATION = 700;

    private Drawable mIconDrawable;
    private String mBottomText,mMiddleText;
    private int mAnimationDuration;
    private int mIdleBackgroundColor,
            mMiddleTextColor,mBottomTextColor, mHighlightedBackgroundColor;

    private ImageView ivTop;
    private TextView tvMiddleText,tvBottomText;

    private ProgressBar mPbStatus;

    private TransitionDrawable mTransition;
    private boolean isHighlighted;
    private Context mContext;

    public HighlightingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.HighlightingView,
                0, 0);
        try {
            mContext = context;
            mIconDrawable = a.getDrawable(R.styleable.HighlightingView_icon);
            mMiddleText = a.getString(R.styleable.HighlightingView_middleText);
            mBottomText = a.getString(R.styleable.HighlightingView_bottomText);
            mAnimationDuration = a.getInt(R.styleable.HighlightingView_animationDurationInMillis,
                    DEFAULT_ANIMATION_DURATION);
            mIdleBackgroundColor = a.getColor(R.styleable.
                            HighlightingView_idleBackgroundColor,
                    ContextCompat.getColor(mContext,android.R.color.white));
            mHighlightedBackgroundColor = a.getColor(R.styleable.
                            HighlightingView_enlightedBackgroundColor
                    , ContextCompat.getColor(mContext,android.R.color.holo_green_dark));
            mMiddleTextColor = a.getColor(R.styleable.
                            HighlightingView_middleTextColor
                    , ContextCompat.getColor(mContext,android.R.color.holo_orange_dark));
            mIconDrawable = Utils.getColoredDrawable(mIconDrawable, mMiddleTextColor);
            mBottomTextColor = a.getColor(R.styleable.
                            HighlightingView_bottomTextColor
                    , ContextCompat.getColor(mContext,android.R.color.tertiary_text_light));
            init();
        } finally {
            a.recycle();
        }
    }

    private void init() {
        inflate(getContext(), R.layout.highlighting_layout, this);
        
        ivTop = (ImageView) findViewById(R.id.ivTop);
        ivTop.setImageDrawable(mIconDrawable);

        tvMiddleText = (TextView) findViewById(R.id.tvMiddleText);
        tvMiddleText.setText(mMiddleText);
        tvMiddleText.setTextColor(mMiddleTextColor);

        tvBottomText = (TextView) findViewById(R.id.tvBottomText);
        tvBottomText.setText(mBottomText);
        tvBottomText.setTextColor(mBottomTextColor);

        mPbStatus = (ProgressBar) findViewById(R.id.pbStatus);

        Drawable backgroundDrawableNormal = Utils.getColoredDrawable(
                ContextCompat.getDrawable(mContext,R.drawable.rounded_corners),
                mIdleBackgroundColor);
        Drawable backgroundDrawableHighlighted = Utils.getColoredDrawable(
                ContextCompat.getDrawable(mContext,R.drawable.rounded_corners),
                mHighlightedBackgroundColor);
        Drawable[] layers = new Drawable[]{backgroundDrawableNormal,backgroundDrawableHighlighted};
        mTransition = new TransitionDrawable(layers);
        setBackground(mTransition);
    }


    private void setCurrentStatusView(){
        if (isHighlighted){
            mTransition.startTransition(mAnimationDuration);
            mIconDrawable = Utils.getColoredDrawable(mIconDrawable, Color.WHITE);
            tvMiddleText.setTextColor(Color.WHITE);
            tvBottomText.setTextColor(Color.WHITE);
        }else{
            mTransition.reverseTransition(mAnimationDuration);
            mIconDrawable = Utils.getColoredDrawable(mIconDrawable, mMiddleTextColor);
            tvMiddleText.setTextColor(mMiddleTextColor);
            tvBottomText.setTextColor(mBottomTextColor);
        }
        ivTop.setImageDrawable(mIconDrawable);
    }

    public void setMiddleText(String text){
        if (text!=null) {
            tvMiddleText.setText(text);
        }
    }

    public void setBottomText(String text){
        if (text!=null){
            tvBottomText.setText(text);
        }
    }

    public void setIcon(Drawable drawable){
        if (drawable!=null){
            ivTop.setImageDrawable(drawable);
        }
    }

    public boolean isHighlighted(){
        return isHighlighted;
    }

    public void showProgressBar(){
        mPbStatus.setVisibility(VISIBLE);
    }

    public void hideProgressBar(){
        mPbStatus.setVisibility(INVISIBLE);
    }

    public void setHighlighted(boolean isHighlighted){
        this.isHighlighted = isHighlighted;
        setCurrentStatusView();
    }
}
