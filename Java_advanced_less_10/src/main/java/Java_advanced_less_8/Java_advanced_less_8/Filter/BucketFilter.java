package Java_advanced_less_8.Java_advanced_less_8.Filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import Java_advanced_less_8.Java_advanced_less_8.AbstractCRUD.FilterService;
import Java_advanced_less_8.Java_advanced_less_8.Shop.StatusUser;

@WebFilter("/bucket.jsp")
public class BucketFilter implements Filter {

	private FilterService filterService = FilterService.getFilterService();
	
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		filterService.doFilterValidation(request, response, chain, Arrays.asList(StatusUser.user));
	}

	public void init(FilterConfig fConfig) throws ServletException {}
}