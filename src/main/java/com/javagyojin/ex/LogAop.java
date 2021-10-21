package com.javagyojin.ex;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	
	
//	@Pointcut("execution(public void get*(..))") //public void�� ��� get�޼���
//	@Pointcut("execution(* com.javagyojin.ex.*.*())") //com.javagyojin.ex ��Ű���� �Ķ���Ͱ� ���� ��� �޼���	
//	@Pointcut("execution(* com.javagyojin.ex..*.*())") //com.javagyojin.ex ��Ű�� & com.javagyojin.ex ���� ��Ű���� �Ķ���Ͱ� ���� ��� �޼��� 
//	@Pointcut("execution(* com.javagyojin.ex.Worker.*())") //com.javagyojin.ex.Worker Ŭ�����ȿ� �ִ� ��� �޼���
		
//	@Pointcut("within(com.javagyojin.ex.*)") //com.javagyojin.ex ��Ű�� �ȿ� �ִ� ��� �޼���
//	@Pointcut("within(com.javagyojin.ex..*)") //com.javagyojin.ex ��Ű�� & ���� ��Ű�� �ȿ� �ִ� ��� �޼���
//	@Pointcut("within(com.javagyojin.ex.Worker)") //com.javagyojin.ex.Worker Ŭ���� �ȿ� �ִ� ��� �޼���
	
//	@Pointcut("bean(student)") //student �󿡸� ����
	@Pointcut("bean(*ker)") //*ker�� ������ �̸��� �󿡸� ����
	
	private void pointcutMethod() {
		
	}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint jointpoint) throws Throwable { 
		// around ��� ��ü�� �޼ҵ尡 ���� ��,�� �Ǵ� �ͼ��� �߻��������� ������ ����
		
		String signatureStr = jointpoint.getSignature().toShortString();
		System.out.println(signatureStr + "�޼��尡 ���� �Ǿ����ϴ�!");
		long st = System.currentTimeMillis();
				
		try {
			Object obj = jointpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "�޼��尡 ���� �Ǿ����ϴ�!");
			System.out.println(signatureStr + "����ð� : " + (et-st));
		}
	}
	
	@Before("within(com.javagyojin.ex.*)")
	public void beforeAdvice(JoinPoint joinPoint) { //before ��� ��ü�� �޼ҵ� ȣ�� ���� ������ ����
		System.out.println("before Advice�� �����");
	}
	
}
