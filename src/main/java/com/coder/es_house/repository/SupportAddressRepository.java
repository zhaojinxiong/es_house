package com.coder.es_house.repository;

import com.coder.es_house.entity.SupportAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author:apple
 * @date: 2019/2/28
 * @time: 下午9:53
 */
public interface SupportAddressRepository extends CrudRepository<SupportAddress,Long> {
    /**
     * 获取所有对应行政级别的信息
     * @param level
     * @return
     */
    List<SupportAddress> findAllByLevel(String level);


}
