package com.michaelfotiadis.samplearchitecture.analytics;

import com.michaelfotiadis.samplearchitecture.analytics.log.AnalyticsLog;

// fake mixpanel analytics
public class MixPanelAnalytics implements Analytics {
    @Override
    public void onApplicationStarted() {
        AnalyticsLog.i("onApplicationStarted");
    }

    @Override
    public void identifyUser(String id) {
        AnalyticsLog.i(String.format("identifyUser %s", id));
    }
}
