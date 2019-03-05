package com.coder.es_house.service.house;

import com.coder.es_house.entity.SupportAddress;
import com.coder.es_house.service.ServiceMultiResult;
import com.coder.es_house.web.controller.house.SupportAddressDTO;

import java.util.List;

/**
 * 地址服务接口
 * @author:apple
 * @date: 2019/2/28
 * @time: 下午9:59
 */
public interface IAddressService {
    ServiceMultiResult<SupportAddressDTO> findAllCities();
}
