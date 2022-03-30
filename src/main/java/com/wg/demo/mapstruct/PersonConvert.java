package com.wg.demo.mapstruct;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.common.utils.JacksonUtils;
import org.mapstruct.Mapper;

/**
 * @author wg
 */
@Mapper(componentModel = "spring")
public interface PersonConvert {

    PersonDTO entity2DTO(PersonEntity personEntity);

    public static void main(String[] args) {
//        JacksonUtils.toJson("");
        JSON.toJSONString("");
    }

}
