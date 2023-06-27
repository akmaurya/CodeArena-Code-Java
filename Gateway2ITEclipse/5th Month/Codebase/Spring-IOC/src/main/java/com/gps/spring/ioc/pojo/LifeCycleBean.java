package com.gps.spring.ioc.pojo;





//public class LifeCycleBean implements BeanNameAware, BeanFactoryAware {
public class LifeCycleBean {
//public class LifeCycleBean implements InitializingBean, DisposableBean {
	private String valueX;
	private String valueY;

//	@Override
//	public void destroy() throws Exception {
//		System.out.println("LifeCycleBean clean up get called successfully via destroy...");
//	}
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("LifeCycleBean intialized successfully via afterPropertiesSet...");
//	}

	public void initMethod() {
		System.out.println("LifeCycleBean intialized successfully via custom method...");
	}

	public void destroyMethod() {
		System.out.println("LifeCycleBean clean up get called successfully via custom method...");
	}

	public void defaultInit() {
		System.out.println("LifeCycleBean default intialized successfully via default global method...");
	}

	public void defaultDestroy() {
		System.out.println("LifeCycleBean default clean up get called successfully via default global method...");
	}

//	@Override
//	public void setBeanName(String arg0) {
//		System.out.println("BeanNameAware get called. Bean name is [" + arg0 + "]");
//	}
//
//	@Override
//	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//		System.out.println("BeanFactoryAware get called. Bean factory instance contains falselifeCycleBean ["
//				+ beanFactory.containsBean("falselifeCycleBean") + "]");
//	}

	public String getValueX() {
		return valueX;
	}

	public void setValueX(String valueX) {
		this.valueX = valueX;
	}

	public String getValueY() {
		return valueY;
	}

	public void setValueY(String valueY) {
		this.valueY = valueY;
	}

	@Override
	public String toString() {
		return "valueX [" + valueX + "], valueY [" + valueY + "]";
	}
}
