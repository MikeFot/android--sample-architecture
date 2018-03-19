package com.michaelfotiadis.samplearchitecture.domain.listener;

public abstract class Canceller {

    private Cancellable cancellable;

    public void register(Cancellable cancellable) {
        this.cancellable = cancellable;
    }

    public void unRegister() {
        this.cancellable = null;
    }

    protected void cancel() {
        if (cancellable != null) {
            cancellable.cancel();
        }
    }

}
