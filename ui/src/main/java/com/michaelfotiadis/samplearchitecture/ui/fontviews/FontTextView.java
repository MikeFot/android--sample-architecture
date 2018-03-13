package com.michaelfotiadis.samplearchitecture.ui.fontviews;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;

import com.michaelfotiadis.samplearchitecture.ui.typeface.Typeface;

public class FontTextView extends android.support.v7.widget.AppCompatTextView implements TypefaceEnabled {

    public FontTextView(final Context context) {
        super(context);
        init();
    }

    public FontTextView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontTextView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init() {
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }

    @Override
    public void setFont(final Typeface font) {
        setTypeface(ResourcesCompat.getFont(getContext(), font.getResId()));
    }

}
