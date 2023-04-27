package com.aelatrouz.csv;

import com.aelatrouz.dto.CompanyDto;
import com.aelatrouz.dto.ConventionDto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class CsvWriter {
	private final Logger logger = LoggerFactory.getLogger(CsvWriter.class);

	@Value("${csv.file.name}")
	private String fileName;

	public void writeToFile(List<CompanyDto> companyDataList) {
		File file = new File(fileName);
		boolean fileExists = file.exists();
		try (FileWriter writer = new FileWriter(fileName, true);
				CSVPrinter csvPrinter = new CSVPrinter(writer, fileExists ?
						CSVFormat.DEFAULT :
						CSVFormat.DEFAULT.withHeader("siret", "convention_id", "etat", "convention_short_title", "convention_date_publi"));) {
			for (CompanyDto companyDto : companyDataList) {
				printCompanyData(csvPrinter, companyDto);
			}

		} catch (IOException e) {
			logger.error("Error while writing to file: {}", e.getMessage());
		}
	}

	private void printCompanyData(CSVPrinter csvPrinter, CompanyDto companyDto) throws IOException {
		ConventionDto conventionDto = companyDto.getConventions().stream().findAny().orElse(new ConventionDto());
		csvPrinter.printRecord(companyDto.getSiret(), conventionDto.getId(), conventionDto.getEtat(), conventionDto.getShortTitle(),
				conventionDto.getDate_publi());
	}

}
