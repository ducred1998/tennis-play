package io.datajek.databaserelationships.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Tournament {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String location;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "tournament_id")
	private List<Registration> registrations = new ArrayList<>();

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinTable(name = "tournament_categories", joinColumns = @JoinColumn(name = "tournament_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	@JsonIgnoreProperties("tournaments")
	private List<Category> playingCategories = new ArrayList<>();

	public Tournament() {
	}

	public Tournament(int id, String name, String location, List<Registration> registrations) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.registrations = registrations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public List<Category> getPlayingCategories() {
		return playingCategories;
	}

	public void setPlayingCategories(List<Category> playingCategories) {
		this.playingCategories = playingCategories;
	}

	// set up one to many relationship
	public void addRegistration(Registration reg) {
		registrations.add(reg);
	}

	// remove registration
	public void removeRegistration(Registration reg) {
		if (registrations != null)
			registrations.remove(reg);
	}

	// set up many-to-many relationship
	public void addCategory(Category category) {
		playingCategories.add(category);
		// set up bidirectional relationship
		category.getTournaments().add(this);
	}

	// remove category
	public void removeCategory(Category category) {
		if (playingCategories != null)
			playingCategories.remove(category);
		// update bidirectional relationship
		category.getTournaments().remove(this);
	}

	@Override
	public String toString() {
		return "Tournament [id=" + id + ", name=" + name + ", location=" + location + ", registrations=" + registrations
				+ ", playingCategories=" + playingCategories + "]";
	}

}
