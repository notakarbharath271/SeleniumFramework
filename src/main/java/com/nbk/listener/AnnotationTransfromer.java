package com.nbk.listener;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.nbk.utilities.DataProviderUtility;



public class AnnotationTransfromer implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProviderUtility.class);
		annotation.setRetryAnalyzer(RetryFailTest.class);
		
	}


	}

