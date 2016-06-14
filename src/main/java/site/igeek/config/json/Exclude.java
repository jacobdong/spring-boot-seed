package site.igeek.config.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jacobdong on 16/5/5.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Exclude {
    /**
     * 序列化
     *
     * @return
     */
    boolean serialize() default false;

    /**
     * 反序列化
     *
     * @return
     */
    boolean deserialize() default true;
}
