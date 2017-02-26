package cn.tedu.cloud_note.aspect;

import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Component
@Aspect
public class LoggerBean {
	@Before("within(cn.tedu.cloud_note.controller..*)")
	public void logController(){
		System.out.println("AOP功能注入Controller!");
	}
	@Before("within(cn.tedu.cloud_note.service..*)")
	public void logService(){
		System.out.println("AOP注入Service");
	}
}
