package site.igeek.config;

import org.apache.log4j.Logger;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import site.igeek.interceptor.RootInterceptor;
import site.igeek.utils.GsonUtils;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by jacobdong on 16/1/12.
 */
@Component
public class WebConfig extends WebMvcConfigurerAdapter {

    private final Logger LOGGER = Logger.getLogger(WebConfig.class);

    @Resource
    RootInterceptor rootInterceptor;


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(createGsonHttpMessageConverter());
        super.configureMessageConverters(converters);
        LOGGER.info("# 添加GSON 支持结束");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rootInterceptor);
    }


    ////////////////////////////////////////////////////////////////////////////////////////
    public static GsonHttpMessageConverter createGsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(GsonUtils.GSON);
        return converter;
    }
}
