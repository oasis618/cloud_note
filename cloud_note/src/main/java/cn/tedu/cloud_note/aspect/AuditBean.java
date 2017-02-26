package cn.tedu.cloud_note.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuditBean {
	@Around("within(cn.tedu.cloud_note.service..*)")
	public Object audit(ProceedingJoinPoint point) throws Throwable{
		Object obj = null;
		try {
			long time=System.currentTimeMillis();
			/*point.proceed()相当于一个service
			 可在其上下定义切入点*/
			obj = point.proceed();
			long lastTime=System.currentTimeMillis();
			String name = point.getSignature().toString();
			System.out.println(name+"耗时-->"+(lastTime-time));
		} catch (Throwable e) {
			e.printStackTrace();
			//AOP获取异常如果不抛出的话,事物获取不到异常就无法完成回滚
			throw e;
		}
		return obj;
	}
}
