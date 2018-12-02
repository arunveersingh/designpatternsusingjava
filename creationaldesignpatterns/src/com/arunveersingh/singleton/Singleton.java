package com.arunveersingh.singleton;

import java.time.Instant;

/**
 * 
 * @author arunveersingh9@gmail.com
 *
 */
public class Singleton {

    // Step 3:
    // making it static only method #getInstance() in this class is static and
    // this variable is required there. And making it static will ensure even if
    // multiple instances of Singleton are created this reference is a class
    // level one.
    private static ObjectInDemand objectInDemand = null;

    // Step 1:
    // restricting initialization through default construction and not
    // introducing parameterized constructors.
    private Singleton() {

    }

    // Step 2:
    // restricted access to the constructors, thats why creating a static
    // method, so as it can be accessed.
    static ObjectInDemand getInstance() {

	if (objectInDemand == null) {
	    synchronized (Singleton.class) {
		System.out.println("Initialization Attempted: "
			+ Thread.currentThread().getName() + " ; "
			+ Instant.now());
		if (objectInDemand == null) {
		    objectInDemand = new ObjectInDemand(
			    Thread.currentThread().getName() + "_"
				    + Thread.currentThread().getName(),
			    Instant.now());
		}
	    }
	}
	return objectInDemand;
    }

}
