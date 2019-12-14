package com.huatech.mall.common.utils;

/**
 * @Author leek
 * @Date 2018-10-23 下午1:50
 * @Version 1.0
 * @Description
 */
public interface ICacheService {
    /**
     * 保存key
     *
     * @param key   键
     * @param value 值
     */
    void set(String key, String value);

    /**
     * 保存key，并设置有效时间
     *
     * @param key     键
     * @param value   值
     * @param expires 时间
     */
    void set(String key, String value, long expires);

    /**
     * 获取值
     *
     * @param key 键
     * @return
     */
    String get(String key);

    /**
     * 获取值
     *
     * @param key
     * @param callback
     * @param <T>
     * @return
     */
    <T> T get(String key, ICallback callback);

    /**
     * 移除键值
     *
     * @param key
     */
    void remove(String key);

    /**
     * 判断键值是否存在
     *
     * @param key
     * @return
     */
    boolean exists(String key);

    /**
     * 内部接口
     */
    public static interface ICallback {
        <T> T execute();
    }
}
