package com.aelatrouz.Controller;

import com.aelatrouz.client.CompanyApiClient;
import com.aelatrouz.csv.CsvWriter;
import com.aelatrouz.dto.CompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyDataController {

	@Autowired
	private CompanyApiClient companyApiClient;

	@Autowired
	private CsvWriter csvWriter;

	@GetMapping("/{siret}")
	public List<CompanyDto> getCompanyDataBySiretNumbers(@PathVariable("siret") String siret) {
		return companyApiClient.getCompanyData(siret);
	}

	@PostMapping("/store/csv")
	public ResponseEntity<String> storeCompanyData(@RequestParam String siret) {
		try {
			List<CompanyDto> companyDtos = companyApiClient.getCompanyData(siret);
			csvWriter.writeToFile(companyDtos);
			return ResponseEntity.ok("CSV generated successfully for siret: " + siret);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to generate CSV for siret: " + siret);
		}
	}
}
