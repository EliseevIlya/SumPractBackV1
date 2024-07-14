package com.example.sumpractbackv1.model.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.example.sumpractbackv1.model.entity.BICDirectoryEntry;
import com.example.sumpractbackv1.model.entity.ImportData;
import com.example.sumpractbackv1.model.enums.CreationReason;
import com.example.sumpractbackv1.model.enums.InfoTypeCode;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@ToString
@Schema(name = "ImportData")
public class ImportDataResponse extends BaseEntityResponse {
	
	private String xmlns;

	private Long edno;

	private LocalDate edDate;

	private Long edAuthor;

	private Long edReceiver;

	private CreationReason creationReason;

	private ZonedDateTime creationDateTime;

	private InfoTypeCode infoTypeCode;

	private LocalDate businessDay;

	private Integer directoryVersion;

	private PartInfoResponse partInfo;

	@Schema(nullable = true)
	private InitialEDResponse initialED;

	private List<Long> bicDirectoryEntryList;

	public ImportDataResponse(ImportData importData) {
		super(importData);
		this.xmlns = importData.getXmlns();
		this.edno = importData.getEdno();
		this.edDate = importData.getEdDate();
		this.edAuthor = importData.getEdAuthor();
		this.edReceiver = importData.getEdReceiver();
		this.creationReason = importData.getCreationReason();
		this.creationDateTime = importData.getCreationDateTime();
		this.infoTypeCode = importData.getInfoTypeCode();
		this.businessDay = importData.getBusinessDay();
		this.directoryVersion = importData.getDirectoryVersion();
		this.partInfo = importData.getPartInfo() != null
				? new PartInfoResponse(importData.getPartInfo())
				: null;
		this.initialED = importData.getInitialED() != null
				? new InitialEDResponse(importData.getInitialED())
				: null;
		this.bicDirectoryEntryList = importData.getBicDirectoryEntryList() != null
				? importData.getBicDirectoryEntryList().stream()
						.map(BICDirectoryEntry::getId)
						.collect(Collectors.toList())
				: List.of();
	}

}
