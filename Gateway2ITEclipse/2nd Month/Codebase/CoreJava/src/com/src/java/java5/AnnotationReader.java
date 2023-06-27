package com.src.java.java5;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class AnnotationReader {
	public static void main(String args[]) throws Exception {
		Class<AnnotatedClass> classObject = AnnotatedClass.class;
		readAnnotation(classObject);
		Method method1 = classObject.getMethod("annotatedMethod1", new Class[] {});
		readAnnotation(method1);
		Method method2 = classObject.getMethod("annotatedMethod2", new Class[] {});
		readAnnotation(method2);
	}

	static void readAnnotation(AnnotatedElement element) {
		try {
			System.out.println("\nFinding annotations on " + element.getClass().getName());
			Annotation[] classAnnotations = element.getAnnotations();

			for (Annotation annotation : classAnnotations) {
				if (annotation instanceof Author) {
					Author author = (Author) annotation;
					System.out.println("Author name:" + author.name());
				} else if (annotation instanceof Version) {
					Version version = (Version) annotation;
					System.out.println("Version number:" + version.number());
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
