package com.jayway.mshopelink.modules.donation.infrastructure;

import com.jayway.mshopelink.modules.donation.application.RegisterDonation;
import com.jayway.mshopelink.modules.donation.domain.dto.ErrorResponse;
import com.jayway.mshopelink.modules.donation.domain.dto.RegisterDonationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.jayway.mshopelink.commons.Constants.REQUEST_ERROR;
import static com.jayway.mshopelink.commons.Utils.buildErrorResponse;

@RestController
@RequestMapping("/donations")
@RequiredArgsConstructor
public class DonationController  {
    private final RegisterDonation registerDonation;

    @GetMapping
    public ResponseEntity<Void> registerDonation(RegisterDonationRequest request) {
        registerDonation.register(request);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse errorResponse = buildErrorResponse(HttpStatus.BAD_REQUEST, REQUEST_ERROR, ex.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }


}
