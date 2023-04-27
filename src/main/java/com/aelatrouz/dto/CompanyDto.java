package com.aelatrouz.dto;

import java.io.Serializable;
import java.util.List;

public class CompanyDto implements Serializable {

	private String siret;
	private List<ConventionDto> conventions;

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public List<ConventionDto> getConventions() {
		return conventions;
	}

	public void setConventions(List<ConventionDto> conventions) {
		this.conventions = conventions;
	}
}
