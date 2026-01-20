package com.example.petstoremonolithique.Entities;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "pets")
public class Pet {
	@Id
	@GeneratedValue
	private Long id; // Changed to Long and added @Id and @GeneratedValue annotations

	private String name;
	@Enumerated(EnumType.STRING)
	private PetCategory category;
	@ElementCollection
	@CollectionTable(name = "pet_photos", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "photo_url")
	private List<String> photoUrls;

	private String tags;

	@Enumerated(EnumType.STRING)
	private PetStatus status;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setCategory(PetCategory category) {
		this.category = category;
	}

	public PetCategory getCategory() {
		return this.category;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public List<String> getPhotoUrls() {
		return this.photoUrls;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTags() {
		return this.tags;
	}

	public void setStatus(PetStatus status) {
		this.status = status;
	}

	public PetStatus getStatus() {
		return this.status;
	}
}
