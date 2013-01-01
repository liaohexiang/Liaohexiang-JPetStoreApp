package org.springframework.samples.jpetstore.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AccessiblityChecker {

	@Pointcut("execution(* org.springframework.samples.jpetstore.dao.*.get*(..))")
	public void accessilityReadOnlyPointcut(){}

	@Pointcut("execution(* org.springframework.samples.jpetstore.dao.*.update*(..))||" +
			"execution(* org.springframework.samples.jpetstore.dao.*.insert*(..))")
	public void accessilityModificationPointcut(){}
	
	@Before("org.springframework.samples.jpetstore.aop.AccessiblityChecker.accessilityReadOnlyPointcut()")
	public void checkReadOnly(JoinPoint joinPoint){
		
		System.out.println("checkReadOnly "+joinPoint.getSignature().getName());
	}
	@Before("org.springframework.samples.jpetstore.aop.AccessiblityChecker.accessilityModificationPointcut()")
	public void checkMoidification(JoinPoint joinPoint){
		System.out.println("checkMoidification "+joinPoint.getSignature().getName());
	}
	@AfterReturning(value="org.springframework.samples.jpetstore.aop.AccessiblityChecker.accessilityReadOnlyPointcut()",returning="retValue")
	public void afterReturningCheck(JoinPoint joinPoint, Object retValue){
		System.out.println("afterReturningCheck "+joinPoint.getSignature().getName()+">>>"+retValue.getClass().getName() );
	}
}
