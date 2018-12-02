package com.arunveersingh.singleton;

import java.time.Instant;

public class ObjectInDemand {
    
    private String initializedByThread;
    private Instant initializedAt;
    
    public ObjectInDemand(String initializedByThread, Instant instant) {
	super();
	this.initializedByThread = initializedByThread;
	this.initializedAt = instant;
    }

    public String getInitializedByThread() {
        return initializedByThread;
    }

    public void setInitializedByThread(String initializedByThread) {
        this.initializedByThread = initializedByThread;
    }

    public Instant getInitializedAt() {
        return initializedAt;
    }

    public void setInitializedAt(Instant initializedAt) {
        this.initializedAt = initializedAt;
    }

    @Override
    public String toString() {
	return "ObjectInDemand [initializedByThread=" + initializedByThread
		+ ", initializedAt=" + initializedAt + "]";
    }
    
    
}
