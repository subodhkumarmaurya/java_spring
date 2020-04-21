package com.gregchance.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//  ===== add additional columns below here=====
    @Size(min = 3, message = "Event name must be at least 3 characters")
    private String name;
    @NotNull(message = "Please provide and event date")
    @Future(message = "Event date must be in the future")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    @Size(min = 2, max = 20, message = "Event location must be at least 2 characters")
    private String location;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private User host;
    
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private List<Comment> comments;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "users_events",
    		joinColumns = @JoinColumn(name = "event_id"),
    		inverseJoinColumns = @JoinColumn(name = "user_id")
    		)
    private List<User> attendees;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    public Event() {

    }

//  ===== generate getters+setters below here

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist()
    protected void onCreate() {
    	this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = new Date();
    }
}
