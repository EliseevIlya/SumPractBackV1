package com.example.sumpractbackv1.model.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.example.sumpractbackv1.model.entity.Accounts;
import com.example.sumpractbackv1.model.entity.BICDirectoryEntry;
import com.example.sumpractbackv1.model.entity.Swbics;
import com.example.sumpractbackv1.model.enums.ChangeType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@Schema(name = "BICDirectoryEntry")
public class BICDirectoryEntryResponse extends BaseEntityResponse {

	private Long bic;

	private ChangeType changeType;

	private ParticipantInfoResponse participantInfo;

	private List<Long> swbicsList;

	private List<Long> accountsList;
	
	public BICDirectoryEntryResponse(BICDirectoryEntry bicDirectoryEntry) {
		super(bicDirectoryEntry);
		this.bic = bicDirectoryEntry.getBic();
		this.changeType = bicDirectoryEntry.getChangeType();
		this.participantInfo = new ParticipantInfoResponse(bicDirectoryEntry.getParticipantInfo());
		this.swbicsList = bicDirectoryEntry.getSwbicsList() != null
				? bicDirectoryEntry.getSwbicsList().stream()
					.map(Swbics::getId)
					.collect(Collectors.toList())
				: List.of();
		this.accountsList = bicDirectoryEntry.getAccountsList() != null
				? bicDirectoryEntry.getAccountsList().stream()
					.map(Accounts::getId)
					.collect(Collectors.toList())
				: List.of();
	}
	
}
