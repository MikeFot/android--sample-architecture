package com.michaelfotiadis.samplearchitecture.ui.typeface;

import android.support.annotation.FontRes;

import com.michaelfotiadis.samplearchitecture.ui.R;


/**
 *
 */
public enum Typeface {

    OPEN_SANS_BOLD(R.font.opensans_bold),
    OPEN_SANS_BOLD_ITALIC(R.font.opensans_bold_italic),
    OPEN_SANS_EXTRA_BOLD(R.font.opensans_extra_bold),
    OPEN_SANS_EXTRA_BOLD_ITALIC(R.font.opensans_extra_bold_italic),
    OPEN_SANS_ITALIC(R.font.opensans_italic),
    OPEN_SANS_LIGHT(R.font.opensans_light),
    OPEN_SANS_LIGHT_ITALIC(R.font.opensans_light_italic),
    OPEN_SANS_REGULAR(R.font.opensans_regular),
    OPEN_SANS_SEMI_BOLD(R.font.opensans_semi_bold),
    OPEN_SANS_SEMI_BOLD_ITALIC(R.font.opensans_semi_bold_italic);

    @FontRes
    private final int resId;

    Typeface(int resId) {
        this.resId = resId;
    }

    public static Typeface fromResId(final int id) {

        for (Typeface typeface : Typeface.values()) {
            if (typeface.getResId() == id) {
                return typeface;
            }
        }
        return OPEN_SANS_REGULAR;
    }

    @FontRes
    public int getResId() {
        return resId;
    }

}
