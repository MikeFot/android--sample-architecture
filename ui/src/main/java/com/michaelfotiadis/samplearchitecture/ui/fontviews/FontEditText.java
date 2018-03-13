package com.michaelfotiadis.samplearchitecture.ui.fontviews;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.michaelfotiadis.samplearchitecture.ui.typeface.Typeface;

public class FontEditText extends AppCompatEditText implements TypefaceEnabled {

    public FontEditText(Context context) {
        super(context);
        init();
    }

    public FontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    private void init() {
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }

    @Override
    public void setFont(final Typeface font) {
        setTypeface(ResourcesCompat.getFont(getContext(), font.getResId()));
    }

}
