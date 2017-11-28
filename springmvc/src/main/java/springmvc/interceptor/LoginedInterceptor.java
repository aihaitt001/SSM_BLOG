package springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.User;

public class LoginedInterceptor implements HandlerInterceptor {
	private static final String[] IGNORE_URI = { "jpg", "img", "css", "js", "/login", "/404", "/error", "/register", };

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		boolean islogined = false;
		String servletPath = request.getServletPath();
		String method = request.getMethod();
		for (String s : IGNORE_URI) {
			if (s.equals("artcles") && method.equals("GET")) {
				System.out.println("不拦截");
				islogined = true;
				break;
			}
			if (servletPath.contains(s)) {
				System.out.println("不拦截");
				islogined = true;
				break;
			}
		}
		if (!islogined) {
			User user = (User) request.getSession().getAttribute("user_session");
			if (user == null) {
				System.out.println("先登录！");
				// request.setAttribute("message", "请先登陆！");
				response.sendRedirect("/springmvc/login");
				return islogined;
			} else {
				System.out.println("允许通过！");
				request.getSession().setMaxInactiveInterval(1200);
				islogined = true;
			}
		}

		return islogined;
	}

}
