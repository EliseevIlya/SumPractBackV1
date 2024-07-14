package com.example.sumpractbackv1.model.dto.response;

import java.time.LocalDate;

import com.example.sumpractbackv1.model.entity.InitialED;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@Schema(name = "InitialED")
public class InitialEDResponse extends BaseEntityResponse {

	private Long edno;

	private LocalDate edDate;

	private Long edAuthor;

	public InitialEDResponse(InitialED initialED) {
		super(initialED);
		this.edno = initialED.getEdno();
		this.edDate = initialED.getEdDate();
		this.edAuthor = initialED.getEdAuthor();
	}
	
}
