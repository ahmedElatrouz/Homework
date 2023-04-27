package com.aelatrouz.kafka.consumers;

import com.aelatrouz.client.CompanyApiClient;
import com.aelatrouz.csv.CsvWriter;
import com.aelatrouz.dto.CompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanySiretConsumer {

	@Autowired
	private CsvWriter csvWriter;

	@Autowired
	private CompanyApiClient companyApiClient;

	@KafkaListener(topics = "siretCodes")
	public void consume(String code) {
		List<CompanyDto> companyDtos = companyApiClient.getCompanyData(code);
		csvWriter.writeToFile(companyDtos);
	}
}