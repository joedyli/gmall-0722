//package io.guli.config;
//
//import com.google.gson.Gson;
//import HttpContextUtils;
//import R;
//import org.apache.http.HttpStatus;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.*;
//import javax.servlet.FilterConfig;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Configuration
//public class DemoConfig {
//
//    @Bean
//    public FilterRegistrationBean demoFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setDispatcherTypes(DispatcherType.REQUEST);
//        registration.setFilter(new DemoFilter());
//        registration.addUrlPatterns("/sys/*");
//        registration.setName("demoFilter");
//        return registration;
//    }
//
//    class DemoFilter implements Filter{
//
//        @Override
//        public void init(FilterConfig filterConfig) throws ServletException {
//
//        }
//
//        @Override
//        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//            HttpServletRequest request = (HttpServletRequest)servletRequest;
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//            if(request.getMethod().equalsIgnoreCase("OPTIONS")){
//                filterChain.doFilter(servletRequest, servletResponse);
//                return;
//            }
//
//            String uri = request.getRequestURI();
//            String[] filters = new String[]{"save","update","delete","password"};
//            //判断是否包含
//            for(String filter : filters){
//                if(uri.indexOf(filter) != -1){
//                    R r = R.error(HttpStatus.SC_OK, "测试环境，不能操作！");
//                    String json = new Gson().toJson(r);
//
//                    response.setContentType("application/json;charset=utf-8");
//                    response.setHeader("Access-Control-Allow-Credentials", "true");
//                    response.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());
//                    response.getWriter().print(json);
//                    return;
//                }
//            }
//
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//
//        @Override
//        public void destroy() {
//
//        }
//    }
//}
