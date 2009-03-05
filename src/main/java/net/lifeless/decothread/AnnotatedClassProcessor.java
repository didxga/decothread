package net.lifeless.decothread;

import java.lang.reflect.Method;

import net.lifeless.decothread.annotation.Concurrent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AnnotatedClassProcessor {

	private Log			log = LogFactory.getLog(AnnotatedClassProcessor.class);
	
	public boolean processClass(Class<?> target) {
		log.debug("processing target class for annotations:" + target.getCanonicalName());

		for (Method method : target.getMethods()) {
			Concurrent		concurrentAnnotation;
			
			log.debug("checking method:" + method.getName());
			
			concurrentAnnotation = method.getAnnotation(Concurrent.class);
			
			if (concurrentAnnotation != null) {
				log.debug("found @Concurrent here!");
			}
		}
		
		return false;
	}
}
