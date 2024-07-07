package com.jobnet.user.dtos.requests;

import com.jobnet.common.utils.pagination.PaginationRequest;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class RecruitersGetRequest extends PaginationRequest {

    private String email;
    private String name;
    private String phone;
    private String business;
}
