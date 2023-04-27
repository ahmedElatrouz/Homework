package com.aelatrouz.client;

import com.aelatrouz.dto.CompanyDto;

import java.util.List;

public interface CompanyApiClient {

	List<CompanyDto> getCompanyData(String siret);
}
