package com.whynotyue.community.util;

import com.whynotyue.community.entity.User;
import org.springframework.stereotype.Component;


/**
 * 持有用户信息，用于代替 session 对象
 */
@Component
public class HostHolder {
    // ThreadLocal 保存线程独有数据，实现线程间数据隔离
    private ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public void setUser(User user) {
        threadLocal.set(user);
    }

    public User getUser() {
        return threadLocal.get();
    }

    public void clear() {
        threadLocal.remove();
    }

}
