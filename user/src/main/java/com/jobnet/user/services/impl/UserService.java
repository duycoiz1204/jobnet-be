package com.jobnet.user.services.impl;

import com.jobnet.common.exceptions.ResourceNotFoundException;
import com.jobnet.common.i18n.MessageUtil;
import com.jobnet.user.dtos.requests.VerificationRequest;
import com.jobnet.user.models.JobSeeker;
import com.jobnet.user.models.User;
import com.jobnet.user.models.VerificationOTP;
import com.jobnet.user.models.enums.ERole;
import com.jobnet.user.models.enums.EVerificationStatus;
import com.jobnet.user.repositories.JobSeekerRepository;
import com.jobnet.user.repositories.UserRepository;
import com.jobnet.user.services.IUserService;
import com.jobnet.user.services.IVerificationOTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

private final UserRepository userRepository;
private final JobSeekerRepository jobSeekerRepository;
private final IVerificationOTPService confirmationOTPService;
private final MessageUtil messageUtil;

@Override
public VerificationOTP verifyUser(VerificationRequest request) {
	User user = userRepository.findById(request.getUserId())
					.orElseThrow(() -> new ResourceNotFoundException(messageUtil.getMessage("error.notFound.user")));
	
	VerificationOTP verificationOTP =
		confirmationOTPService.updateVerificationOTPConfirmedAt(user, request.getOtpToken());
	
	if (user.getRole().equals(ERole.JobSeeker)) {
		JobSeeker jobSeeker = jobSeekerRepository.findByEmail(user.getEmail())
								  .orElseThrow(() -> new ResourceNotFoundException(messageUtil.getMessage("error.notFound.user")));
		jobSeeker.setVerificationStatus(EVerificationStatus.Verified);
		jobSeeker.setEnabled(true);
		jobSeekerRepository.save(jobSeeker);
	} else {
		user.setEnabled(true);
		userRepository.save(user);
	}
	return verificationOTP;
}
}
