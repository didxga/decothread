package net.lifeless.decothread.tests;

import net.lifeless.decothread.AnnotatedClassProcessor;
import net.lifeless.decothread.annotation.Concurrent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

public class ThreadedAnnotationTests {

	private Log			log = LogFactory.getLog(ThreadedAnnotationTests.class);
	
	@Test
	public void testAnnotatedClass() {
		TestClass		testClass;
		
		testClass		= new TestClass();
		
		Assert.assertNotNull(testClass);
		
		for (int i = 0; i < 10; i++) {
			testClass.execute();
		}
	}
	
	@Test
	public void testClassProcessor() {
		AnnotatedClassProcessor	processor;
		
		processor = new AnnotatedClassProcessor();
		
		processor.processClass(TestClass.class);
	}
	public static class TestClass {
		
		@Concurrent
		public void execute() {
			System.out.println("execute() threadId:" + Thread.currentThread().getId());
		}
	}
}
