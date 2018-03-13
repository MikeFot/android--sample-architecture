package com.michaelfotiadis.samplearchitecture.ui.fontviews;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.michaelfotiadis.samplearchitecture.ui.typeface.Typeface;

public class FontButton extends AppCompatButton implements TypefaceEnabled {

    public FontButton(Context context) {
        super(context);
        init();
    }

    public FontButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setStateListAnimator(null);
        }
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }

    @Override
    public void setFont(final Typeface font) {
        setTypeface(ResourcesCompat.getFont(getContext(), font.getResId()));
    }

}
