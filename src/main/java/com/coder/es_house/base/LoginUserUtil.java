package com.coder.es_house.base;

import com.coder.es_house.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import sun.plugin.liveconnect.SecurityContextHelper;

/**
 * @author:apple
 * @date: 2019/3/23
 * @time: 上午9:41
 */
public class LoginUserUtil {
    public static User load() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal != null && principal instanceof User) {
            return (User) principal;
        }
        return null;
    }

    public static Long getLoginUserId() {
        User user = load();
        if (user == null) {
            return -1L;
        }

        return user.getId();
    }
}
