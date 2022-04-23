package Java_advanced_less_8.Java_advanced_less_8.AbstractCRUD;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Java_advanced_less_8.Java_advanced_less_8.Shop.StatusUser;

public class FilterService {

	private static FilterService filterService;

	private FilterService() {
	}

	public static FilterService getFilterService() {
		if (filterService == null) {
			filterService = new FilterService();
		}

		return filterService;
	}

	public void doFilterValidation(ServletRequest request, ServletResponse response, FilterChain chain,
			List<StatusUser> ustatusUser) throws IOException, ServletException {

		try {
			HttpSession session = ((HttpServletRequest) request).getSession();
			StatusUser statusUser = StatusUser.valueOf((String) session.getAttribute("statusUser"));

			if (statusUser != null && StatusUser.contains(statusUser)) {
				chain.doFilter(request, response);
			} else {
				((HttpServletRequest) request).getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			((HttpServletRequest) request).getRequestDispatcher("index.jsp").forward(request, response);
		}

	}
}
