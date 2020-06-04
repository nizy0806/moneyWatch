package mw.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Advice {

	public String around(ProceedingJoinPoint jp) throws Throwable{

		ServletRequestAttributes sr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sr.getRequest();
		HttpSession session = request.getSession();
		
		if(session != null) {	// ���� ����
			String id = (String)session.getAttribute("memId");
			if(id == null || id.equals("")) {	// ���� ID������ ���ٸ�(�α׾ƿ�����)
				return "redirect:/index.mw";	// �α��� �������� �̵�
			}
		}		
		
		return (String)jp.proceed();
	}
	
}
