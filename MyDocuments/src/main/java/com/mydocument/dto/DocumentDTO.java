package com.mydocument.dto;

import java.util.List;


public class DocumentDTO {
	private String documentName;
    private List<InfoDTO> informations;
	
	public DocumentDTO() {
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public List<InfoDTO> getInformations() {
		return informations;
	}

	public void setInformations(List<InfoDTO> informations) {
		this.informations = informations;
	}

}
