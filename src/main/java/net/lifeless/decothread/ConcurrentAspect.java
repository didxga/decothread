package net.lifeless.decothread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ConcurrentAspect {

	private static Log		log = LogFactory.getLog(ConcurrentAspect.class);
	
	@Pointcut("@annotation(net.lifeless.decothread.annotation.Concurrent)")
	public void isAnnotated() { }
	
	@Around("net.lifeless.decothread.ConcurrentAspect.isAnnotated()")
	public Object executeConcurrentMethod() {
		log.trace("executing concurrent method");
		return null;
	}
}
