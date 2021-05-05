package com.sample.interviewtask.domain.customer.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by TapuMandal on 5/3/2021.
 * For any query ask online.tapu@gmail.com
 */

@Data
public class CustomerDto implements Serializable {
    private int id;
    private String name;
    private int departmentId;
}
