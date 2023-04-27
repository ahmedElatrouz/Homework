package com.aelatrouz.client.impl;

import com.aelatrouz.client.CompanyApiClient;
import com.aelatrouz.client.exception.CompanyDataNotFoundException;
import com.aelatrouz.dto.CompanyDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CompanyApiClientImpl implements CompanyApiClient {

	private final RestTemplate restTemplate = new RestTemplate();

	@Value("${companyInfo.api.url}")
	private String companyDataUrl;

	@Override
	public List<CompanyDto> getCompanyData(String siret) {
		String url = companyDataUrl + siret;
		ResponseEntity<List<CompanyDto>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CompanyDto>>() {
		});
		List<CompanyDto> companyDataList = responseEntity.getBody();
		if (CollectionUtils.isEmpty(companyDataList)) {
			throw new CompanyDataNotFoundException("No company data found for siret: " + siret);
		}
		return companyDataList;
	}

	public void setCompanyDataUrl(String companyDataUrl) {
		this.companyDataUrl = companyDataUrl;
	}
}
