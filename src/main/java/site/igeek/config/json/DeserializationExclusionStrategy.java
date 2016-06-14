package site.igeek.config.json;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * Created by jacobdong on 16/5/5.
 */
public class DeserializationExclusionStrategy implements ExclusionStrategy {
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


    private boolean shouldSkip(Exclude exclude) {
        if (null != exclude) {
            if (!exclude.deserialize()) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
}
