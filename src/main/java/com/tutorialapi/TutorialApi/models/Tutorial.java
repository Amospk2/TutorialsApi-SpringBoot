package com.tutorialapi.TutorialApi.models;

import jakarta.persistence.*;
import com.tutorialapi.TutorialApi.models.User;

@Entity
@Table(name = "tutorial")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "title")
    private String title;


    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

    public Tutorial (){}

	public Tutorial(String title, String description, boolean published, User user) {
		this.title = title;
		this.description = description;
		this.published = published;
		this.user = user;
	}

    public long getId() {
		return id;
	}

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

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean isPublished) {
		this.published = isPublished;
	}
    
	public void setAutor(User user)
	{
		this.user = user;
	}

	public long getAutor(){
		return user.getId();
	}


	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
	}


}