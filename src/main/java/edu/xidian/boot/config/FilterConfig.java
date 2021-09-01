package edu.xidian.boot.config;

import edu.xidian.boot.filter.TestFilter1;
import edu.xidian.boot.filter.TestFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * springboot注册过滤器
 */
@Configuration
public class FilterConfig {

    /**
     * 注册filter1
     * @return
     */
    @Bean
    public FilterRegistrationBean<TestFilter1> filter1() {
        FilterRegistrationBean<TestFilter1> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new TestFilter1()); //注册自定义过滤器
        filterFilterRegistrationBean.setName("filter1");//设置过滤器名称
        List<String> strings = new ArrayList<>();
        strings.add("/*");
        filterFilterRegistrationBean.setUrlPatterns(strings);
        filterFilterRegistrationBean.setOrder(1);//优先级，数值越小越优先
        return filterFilterRegistrationBean;
    }

    /**
     * 注册filter2
     * @return
     */
    @Bean
    public FilterRegistrationBean<TestFilter2> filter2(){
        FilterRegistrationBean<TestFilter2> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new TestFilter2());
        filterFilterRegistrationBean.setName("filter2");
        filterFilterRegistrationBean.setOrder(6);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("/test/*");
        filterFilterRegistrationBean.setUrlPatterns(strings);
        return filterFilterRegistrationBean;
    }
}
