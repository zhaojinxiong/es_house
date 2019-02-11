package com.coder.es_house.repository;

import com.coder.es_house.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 角色数据DAO
 * @author:apple
 * @date: 2019/2/11
 * @time: 上午11:01
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findRolesByUserId(Long userId);
}
