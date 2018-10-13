package site.zengguang.util.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author zengguang
 *
 */
public class XSSFilter implements Filter {

    private FilterConfig config = null;
    private static boolean noInit = true;
    private String apostrophe = "&#39;";

    @Override
    public void init(FilterConfig paramFilterConfig) throws ServletException {
        this.config = paramFilterConfig;
        noInit = false;
        String str = paramFilterConfig.getInitParameter("apostrophe");
        if (str != null) {
            this.apostrophe = str.trim();
        }
    }

    @Override
    public void destroy() {
        this.config = null;
    }

    public FilterConfig getFilterConfig() {
        return this.config;
    }

    public void setFilterConfig(FilterConfig paramFilterConfig) {
        if (noInit) {
            noInit = false;
            this.config = paramFilterConfig;
            String str = paramFilterConfig.getInitParameter("apostrophe");
            if (str != null) {
                this.apostrophe = str.trim();
            }
        }
    }

    @Override
    public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse,
            FilterChain paramFilterChain) throws IOException, ServletException {
        paramFilterChain.doFilter(new RequestWrapper((HttpServletRequest) paramServletRequest, this.apostrophe),
                paramServletResponse);
    }
}
