package com.jobnet.post.dtos.requests;

import com.jobnet.common.utils.pagination.PaginationRequest;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class PostsGetRequest extends PaginationRequest {

    private String search;
    private String categoryId;
    private String professionId;
    private BigInteger minSalary;
    private BigInteger maxSalary;
    private String provinceName;
    private String workingFormat;
    private String recruiterId;
    private String businessId;
    private List<String> activeStatus;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Boolean isExpired;
}
