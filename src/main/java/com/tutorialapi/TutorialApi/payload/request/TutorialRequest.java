package com.tutorialapi.TutorialApi.payload.request;

import jakarta.validation.constraints.NotBlank;

public class TutorialRequest {
	@NotBlank(message = "The title is required.")
  	private String title;

	@NotBlank(message = "The description is required.")
	private String description;

    private String published;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public String getPublished() {
		return published;
	}

    public void setPublished(String published) {
		this.published = published;
	}


}
