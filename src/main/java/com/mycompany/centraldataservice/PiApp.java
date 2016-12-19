package com.mycompany.centraldataservice;

import java.io.IOException;
import java.util.Properties;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class PiApp extends ResourceConfig
{
	public PiApp(){
		packages("com.mycompany");
	}
}
