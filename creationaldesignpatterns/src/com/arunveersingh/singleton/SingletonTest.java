package com.arunveersingh.singleton;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SingletonTest {
    
    ArrayList<Instant> instants = new ArrayList<>();

    @Test
    void testGetInstance() {
	
	Executor executor = Executors.newFixedThreadPool(10);
	
	IntStream.range(0, 10).forEach(n -> {
	    System.out.println(n);
	    executor.execute(()-> {
		instants.add(Singleton.getInstance().getInitializedAt());
		System.out.println(Singleton.getInstance().toString());
		});
	});
	
	try {
	    TimeUnit.MILLISECONDS.sleep(5000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	
	Assert.assertEquals(instants.size(), 10);
	Set<Instant> set = new HashSet<>(instants);
	
	Assert.assertEquals(set.size(), 1);

    }
}
