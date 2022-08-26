package com.wg.demo.tool.cvs2Bean;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CsvFile {

    @CsvBindByName(column = "id")
    private String id;

    @CsvBindByName(column = "token_value")
    private String token;

    @CsvBindByName(column = "type")
    private String type;

    @CsvBindByName(column = "due_time")
    private String dueTime;

    @CsvBindByName(column = "status")
    private String status;

    @CsvBindByName(column = "gmt_create")
    private String gmtCreate;

    @CsvBindByName(column = "gmt_modified")
    private String gmtModified;

}
