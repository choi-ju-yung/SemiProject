package com.semi.mypage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.semi.member.model.vo.Member;

/**
 * Servlet Filter implementation class CheckAthuticate
 */
@WebFilter()
public class CheckAthuticate extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public CheckAthuticate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpSession session = ((HttpServletRequest)request).getSession();
//		Member loginMember = (Member)session.getAttribute("loginMember");
		
//		HttpServletRequest req = ((HttpServletRequest)request);
//		HttpSession session = ((HttpServletRequest)request).getSession();
//		Member loginMember = (Member)session.getAttribute("loginMember");
//		if(loginMember==null || 
//		   loginMember.getUserId().equals(request.getParameter("userId"))){
//			req.setAttribute("msg", "잘못된 접근입니다.");
//			req.setAttribute("loc", "/");
//			req.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
//		} else {
//			chain.doFilter(request, response);
//		}
		
		HttpSession session=((HttpServletRequest)request).getSession();
		System.out.println(session);
		Member loginMember=(Member)session.getAttribute("mypageMember");
		System.out.println(loginMember);
		if(loginMember==null||
				!loginMember.getUserId()
				.equals(request.getParameter("userId"))) {
			request.setAttribute("msg", "잘못된 접근입니다. 나쁜놈아! :(");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp")
			.forward(request, response);
			//throw new RuntimeException("잘못된 접근입니다. 나쁜놈아! :(");
		}
		else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
