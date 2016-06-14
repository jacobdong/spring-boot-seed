package site.igeek.config.json;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * 序列化时通过 配置 annotation {@link Exclude} 忽略实体对象中的属性
 * Created by jacobdong on 16/5/5.
 */
public class SerializationExclusionStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        Exclude exclude = f.getAnnotation(Exclude.class);
        return shouldSkip(exclude);
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        Exclude exclude = clazz.getAnnotation(Exclude.class);
        return shouldSkip(exclude);
    }

    /**
     * 序列化是否跳过此属性
     *
     * @param exclude
     * @return
     */
    private boolean shouldSkip(Exclude exclude) {
        if (null != exclude) {
            if (!exclude.serialize()) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
}
