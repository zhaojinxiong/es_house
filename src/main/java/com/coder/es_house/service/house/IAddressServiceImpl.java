package com.coder.es_house.service.house;

import com.coder.es_house.entity.SupportAddress;
import com.coder.es_house.repository.SupportAddressRepository;
import com.coder.es_house.service.ServiceMultiResult;
import com.coder.es_house.web.controller.house.SupportAddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:apple
 * @date: 2019/2/28
 * @time: 下午10:07
 */
@Service
public class IAddressServiceImpl implements IAddressService {

    @Autowired
    private SupportAddressRepository supportAddressRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ServiceMultiResult<SupportAddressDTO> findAllCities() {
        List<SupportAddress> addresses =  supportAddressRepository.findAllByLevel(SupportAddress.Level.CITY.getValue());

        List<SupportAddressDTO> addressDTOS = new ArrayList<>();

        for (SupportAddress supportAddress :addresses){
            SupportAddressDTO target = modelMapper.map(supportAddress,SupportAddressDTO.class);
            addressDTOS.add(target);
        }


        return new ServiceMultiResult<>(addressDTOS.size(),addressDTOS);
    }
}
