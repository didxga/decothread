package net.lifeless.decothread.tests;

import javax.annotation.Resource;

import net.lifeless.decothread.AnnotatedClassProcessor;
import net.lifeless.decothread.ConcurrentAspect;
import net.lifeless.decothread.annotation.Concurrent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/net/lifeless/decothread/decothread.xml" })
public class ThreadedAnnotationTests {

	private Log					log = LogFactory.getLog(ThreadedAnnotationTests.class);
	
	@Resource
	private TestClass			testClass;
	
	@Test
	public void testConcurrentClass() {
		testClass.execute();
		testClass.executeNonConcurrent();
		testClass.foo();
	}
	
	//@Test
	public void testAnnotatedClass() {
		TestClass		testClass;
		
		testClass		= new TestClass();
		
		Assert.assertNotNull(testClass);
		
		for (int i = 0; i < 10; i++) {
			testClass.execute();
		}
	}
	
	//@Test
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
		
		public void executeNonConcurrent() {
			System.out.println("executeNoneConcurrent() threadId:" + Thread.currentThread().getId());
		}
		
		@Concurrent
		public void foo() {
			System.out.println("foo() threadId:" + Thread.currentThread().getId());
		}
	}
}
