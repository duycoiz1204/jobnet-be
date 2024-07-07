package com.jobnet.user.dtos.requests;

import com.jobnet.common.utils.pagination.PaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class JobSeekersGetRequest extends PaginationRequest {

    private String email;
    private String name;
    private String phone;
    private String accountType;
    private String verificationStatus;
}
