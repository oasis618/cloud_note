package test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class TestBase {
	public ApplicationContext getContext(){
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml",
				"conf/spring-transaction.xml","conf/spring-aop.xml"	};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		return ac;
	}
}
