package com.hebergement.entity;

import static com.googlecode.objectify.ObjectifyService.ofy;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Date;
import java.util.List;

@Cache
@Entity
public class Commentaire {
	
	@Id private Long id;
	@Index private Date createdAt = new Date();
	
	private String name;
	private String content;
	@Index private int idHebergement;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIdHebergement() {
		return idHebergement;
	}
	public void setIdHebergement(int idHebergement) {
		this.idHebergement = idHebergement;
	}
	
	public void save() {
		this.setCreatedAt(new Date());
		ofy().save().entity(this).now();
	}
	
	public static List<Commentaire> findByHebergement(int id) {
		
		return ofy().load().type(Commentaire.class).filter("idHebergement = ", id).list();
	}
	
	public static List<Commentaire> listAll() {
		return ofy().load().type(Commentaire.class).list();
	}
	
	

}
