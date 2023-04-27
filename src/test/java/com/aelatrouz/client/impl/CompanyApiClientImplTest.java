package com.aelatrouz.client.impl;

import com.aelatrouz.client.exception.CompanyDataNotFoundException;
import com.aelatrouz.dto.CompanyDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class CompanyApiClientImplTest {

	private CompanyApiClientImpl companyApiClient;

	@Mock
	private RestTemplate restTemplate;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		companyApiClient = new CompanyApiClientImpl();
		companyApiClient.setCompanyDataUrl("https://siret2idcc.fabrique.social.gouv.fr/api/v2/");
	}

	@Test
	void getCompanyData_shouldReturnCompanyData() {
		List<CompanyDto> expectedCompanyDataList = new ArrayList<>();
		CompanyDto companyDto = new CompanyDto();
		companyDto.setSiret("123456789");
		expectedCompanyDataList.add(companyDto);

		ResponseEntity<List<CompanyDto>> responseEntity = new ResponseEntity<>(expectedCompanyDataList, HttpStatus.OK);

		when(restTemplate.exchange(eq("https://siret2idcc.fabrique.social.gouv.fr/api/v2/123456789"), eq(HttpMethod.GET), any(), any(ParameterizedTypeReference.class))).thenReturn(responseEntity);

		List<CompanyDto> actualCompanyDataList = companyApiClient.getCompanyData("123456789");

		assertEquals(expectedCompanyDataList.get(0).getSiret(), actualCompanyDataList.get(0).getSiret());
	}

}
