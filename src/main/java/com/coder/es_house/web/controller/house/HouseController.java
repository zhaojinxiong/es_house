package com.coder.es_house.web.controller.house;

import com.coder.es_house.base.ApiResponse;
import com.coder.es_house.service.ServiceMultiResult;
import com.coder.es_house.service.house.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:apple
 * @date: 2019/2/28
 * @time: 下午9:22
 */
@Controller
public class HouseController {

    @Autowired
    private IAddressService addressService;



    @GetMapping("address/support/cities")
    @ResponseBody
    public ApiResponse getSupportCities(){
        ServiceMultiResult<SupportAddressDTO> result =  addressService.findAllCities();
        if(result.getResultSize() == 0){
            return ApiResponse.ofSuccess(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(result.getResult());
    }



}
