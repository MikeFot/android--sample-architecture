package com.michaelfotiadis.samplearchitecture.injection;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface AndroidAwareComponent {


}