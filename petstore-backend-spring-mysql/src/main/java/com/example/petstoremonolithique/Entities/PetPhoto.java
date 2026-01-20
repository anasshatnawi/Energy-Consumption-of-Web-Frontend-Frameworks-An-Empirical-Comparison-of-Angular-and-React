package com.example.petstoremonolithique.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pet_photos")
public class PetPhoto {
	@Id
	@GeneratedValue
	private Long id;
	private Long petID;
	@Lob
	@Column(columnDefinition = "TEXT")
	private String metaData;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] fileData;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setPetID(Long petID) {
		this.petID = petID;
	}

	public Long getPetID() {
		return this.petID;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}

	public String getMetaData() {
		return this.metaData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public byte[] getFileData() {
		return this.fileData;
	}
}
