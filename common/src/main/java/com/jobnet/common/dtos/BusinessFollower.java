package com.jobnet.common.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BusinessFollower {
	@NotNull(message = "FollowerAction must be required")
	private EFollowerAction status;
	@NotNull(message = "userId must be required")
	private String userId;
}
