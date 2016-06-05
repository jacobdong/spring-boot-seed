package site.igeek.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Created by jacobdong on 16/6/4.
 */
@Service
public class MQservice {

    private final Logger LOGGER = LoggerFactory.getLogger(MQservice.class);

    private final String CHARSET = "UTF-8";

    @Resource
    StringRedisTemplate stringRedisTemplate;

    /**
     * 使用连接池的方式 get
     *
     * @param keyBytes
     * @return
     */
    public byte[] getBytesValue(final byte[] keyBytes) {
        return stringRedisTemplate.execute(
                (RedisCallback<byte[]>) connection
                        -> connection.get(keyBytes));
    }


    /**
     * 使用连接池的方式 set
     *
     * @param keyBytes
     * @return
     */
    public byte[] setBytesValue(final byte[] keyBytes, byte[] valueBytes, long expireTime) {
        return stringRedisTemplate.execute((RedisCallback<byte[]>) connection -> {
            connection.set(keyBytes, valueBytes);
            if (-1 != expireTime) {
                connection.expire(keyBytes, expireTime);
            }
            return new byte[0];
        });
    }


    /**
     * 获取字符串类型的key 的 value
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        try {
            byte[] bytesValue = getBytesValue(key.getBytes());
            if (null == bytesValue) {
                return null;
            } else {
                return new String(bytesValue, CHARSET);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LOGGER.error("转码失败 #" + key);
            return null;
        }
    }


    public void set(final String key, final String value, final long expireTime) {
        setBytesValue(key.getBytes(), value.getBytes(), expireTime);
    }

}
