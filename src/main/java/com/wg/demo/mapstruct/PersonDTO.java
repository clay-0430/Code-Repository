package com.wg.demo.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wg
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    private String name;

    private Integer age;

}
