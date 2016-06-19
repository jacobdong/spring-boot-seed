package site.igeek.config;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import site.igeek.utils.GsonUtils;

import java.util.List;


/**
 * Created by jacobdong on 16/1/12.
 */
//@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(createGsonHttpMessageConverter());
        super.configureMessageConverters(converters);
    }


    /**
     * 配置json序列化使用GSON
     *
     * @return
     */
    public static GsonHttpMessageConverter createGsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(GsonUtils.GSON);
        return converter;
    }
}
