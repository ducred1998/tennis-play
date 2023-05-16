package io.datajek.databaserelationships.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PlayerProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String twitter;

	@OneToOne(mappedBy = "playerProfile", cascade = CascadeType.ALL)
//   @JsonBackReference
	private Player player;

	public PlayerProfile() {
	}

	public PlayerProfile(String twitter) {
		super();
		this.twitter = twitter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "PlayerDetail [id=" + id + ", twitter=" + twitter + ", player=" + player + "]";
	}
}
