package com.example.sumpractbackv1.model.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.sumpractbackv1.model.entity.ParticipantInfo;
import com.example.sumpractbackv1.model.entity.RstrList;
import com.example.sumpractbackv1.model.enums.ParticipantStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@Schema(name = "ParticipantInfo")
public class ParticipantInfoResponse extends BaseEntityResponse {

	private String nameP;

	@Schema(nullable = true)
	private String englName;

	@Schema(nullable = true)
	private String regN;

	@Schema(nullable = true)
	private String cntrCd;

	@Schema(nullable = true)
	private String rgn;

	@Schema(nullable = true)
	private String ind;

	@Schema(nullable = true)
	private String tnp;

	@Schema(nullable = true)
	private String nnp;

	@Schema(nullable = true)
	private String adr;

	@Schema(nullable = true)
	private Long prntBIC;

	private LocalDate dateIn;

	@Schema(nullable = true)
	private LocalDate dateOut;

	private String ptType;

	private String srvcs;

	private String xchType;

	private Long uid;

	@Schema(nullable = true)
	private ParticipantStatus participantStatus;

	private List<Long> rstrLists;

	@Schema(nullable = true)
	private Long bicDirectoryEntryId;

	public ParticipantInfoResponse(ParticipantInfo participantInfo) {
		super(participantInfo);
		this.nameP = participantInfo.getNameP();
		this.englName = participantInfo.getEnglName();
		this.regN = participantInfo.getRegN();
		this.cntrCd = participantInfo.getCntrCd();
		this.rgn = participantInfo.getRgn();
		this.ind = participantInfo.getInd();
		this.tnp = participantInfo.getTnp();
		this.nnp = participantInfo.getNnp();
		this.adr = participantInfo.getAdr();
		this.prntBIC = participantInfo.getPrntBIC();
		this.dateIn = participantInfo.getDateIn();
		this.dateOut = participantInfo.getDateOut();
		this.ptType = participantInfo.getPtType();
		this.srvcs = participantInfo.getSrvcs();
		this.xchType = participantInfo.getXchType();
		this.uid = participantInfo.getUid();
		this.participantStatus = participantInfo.getParticipantStatus();
		this.rstrLists = participantInfo.getRstrLists() != null
				? participantInfo.getRstrLists().stream()
					.map(RstrList::getId)
					.collect(Collectors.toList())
				: null;
		this.bicDirectoryEntryId = participantInfo.getBicDirectoryEntry() != null
				? participantInfo.getBicDirectoryEntry().getId()
				: null;
	}
	
}
