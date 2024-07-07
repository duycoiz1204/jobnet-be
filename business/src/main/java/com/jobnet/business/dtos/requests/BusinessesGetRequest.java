package com.jobnet.business.dtos.requests;

import com.jobnet.common.utils.pagination.PaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessesGetRequest extends PaginationRequest {

    private String name;
    private String emailDomain;
    private String phone;
    private String status;
    private Boolean isDeleted;
}
