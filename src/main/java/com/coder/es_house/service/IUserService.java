package com.coder.es_house.service;

import com.coder.es_house.entity.User;

/**
 * @author:apple
 * @date: 2019/2/9
 * @time: 下午8:49
 */
public interface IUserService {
    User findUserByName(String name);
}
