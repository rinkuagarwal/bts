package com.ibm.bts.entity;

import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

public class Bug {
    @Id
	private String id;
	@NotNull
	@NotBlank
	private String description;
	@NotNull
	@NotBlank
	private String status;
	private Date date;

	public String getId() {
		return id;
	}
    public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
