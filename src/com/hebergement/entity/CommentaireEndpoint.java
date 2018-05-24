package com.hebergement.entity;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.CollectionResponse;
import com.googlecode.objectify.ObjectifyService;

@Api(name = "commentaireendpoint" , version="v1")
public class CommentaireEndpoint {
	
	static {
		ObjectifyService.register(Commentaire.class);
	}
	
	
	@ApiMethod(name = "commentaire.findByHebergement", path="findByHebergement/{hebergementId}", httpMethod = HttpMethod.POST)
	public CollectionResponse<Commentaire> findByHebergement(@Named("hebergementId") int hebergementId) {				
		return CollectionResponse.<Commentaire> builder().setItems(Commentaire.findByHebergement(hebergementId)).build();
	}
	
	@ApiMethod(name = "commentaire.list", path="commentaire",httpMethod = HttpMethod.GET)
	public CollectionResponse<Commentaire> listPosts() {				
		return CollectionResponse.<Commentaire> builder().setItems(Commentaire.listAll()).build();
	}
	
	@ApiMethod(name = "commentaire.create", path="commentaire",httpMethod = HttpMethod.POST)
	public Commentaire createCommentaire(Commentaire commentaire) {		
		commentaire.save();
		return commentaire;		
	}
	
	
	

  
}
