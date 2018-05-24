package com.hebergement.entity;

import com.hebergement.entity.PMF;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

@Api(name = "hebergementendpoint", version = "v1", namespace = @ApiNamespace(ownerDomain = "http://localhost:8888", ownerName = "http://localhost:8888", packagePath = "entity"))
public class HebergementEndpoint {

	
	public static List<Hebergement> execute = new ArrayList<Hebergement>();
	@SuppressWarnings({"unused" })
	@ApiMethod(name = "listHebergement")
	public CollectionResponse<Hebergement> listHebergement() throws IOException {

		Cursor cursor = null;
		//List<Hebergement> execute = new ArrayList<Hebergement>();

		InputStream inputStream = new URL("http://www.data.gov.ma/data/storage/f/2014-06-18T15%3A23%3A33.132Z/liste-des-etablissements-hebergement-touristique-mt-2010.xls").openStream();

		//Get the workbook instance for XLS stream
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook(inputStream);
		HSSFSheet ws  = wb.getSheet("Liste_établissement 2010");
		
		int rowNum = ws.getLastRowNum() + 1 ;
			
		for  ( int i = 3 ; i < 200 ; i++) {
			HSSFRow row = ws.getRow(i) ;
				
				Hebergement heb = new Hebergement();
				heb.setId(new Long(i));
				heb.setProvince(row.getCell(0).toString());
				heb.setHebergement(row.getCell(1).toString());
				heb.setClassement(row.getCell(2).toString());
				heb.setEmail(row.getCell(3).toString());
				heb.setTel(row.getCell(4).toString());
				heb.setFax(row.getCell(5).toString());
				heb.setAdresse(row.getCell(6).toString());
				
				
				execute.add(heb);
			}
			
			for (Hebergement obj : execute);

		return CollectionResponse.<Hebergement> builder().setItems(execute).build();
	}
	
	@SuppressWarnings({"unused" })
	@ApiMethod(name = "listHebergementByVille" ,  path="listHebergementByVille")
	public CollectionResponse<Hebergement> listHebergementByVille(@Nullable @Named("ville") String ville) throws IOException {

		Cursor cursor = null;
		List<Hebergement> execute = new ArrayList<Hebergement>();

		InputStream inputStream = new URL("http://www.data.gov.ma/data/storage/f/2014-06-18T15%3A23%3A33.132Z/liste-des-etablissements-hebergement-touristique-mt-2010.xls").openStream();

		//Get the workbook instance for XLS stream
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook(inputStream);
		HSSFSheet ws  = wb.getSheet("Liste_établissement 2010");
		
		int rowNum = ws.getLastRowNum() + 1 ;
			
		for  ( int i = 3 ; i < 100 ; i++) {
			HSSFRow row = ws.getRow(i) ;
			if(ville.equals(row.getCell(0).toString().trim()))	{
				Hebergement heb = new Hebergement();
				heb.setId(new Long(i));
				heb.setProvince(row.getCell(0).toString());
				heb.setHebergement(row.getCell(1).toString());
				heb.setClassement(row.getCell(2).toString());
				heb.setEmail(row.getCell(3).toString());
				heb.setTel(row.getCell(4).toString());
				heb.setFax(row.getCell(5).toString());
				heb.setAdresse(row.getCell(6).toString());
				
				execute.add(heb);
			}
			
			}
			for (Hebergement obj : execute);

		return CollectionResponse.<Hebergement> builder().setItems(execute).build();
	}
	@SuppressWarnings({"unused" })
	@ApiMethod(name = "listHebergementByClassement" ,  path="listHebergementByClassement")
	public CollectionResponse<Hebergement> listHebergementByClassement(@Nullable @Named("classement") String classement) throws IOException {

		Cursor cursor = null;
		List<Hebergement> execute = new ArrayList<Hebergement>();

		InputStream inputStream = new URL("http://www.data.gov.ma/data/storage/f/2014-06-18T15%3A23%3A33.132Z/liste-des-etablissements-hebergement-touristique-mt-2010.xls").openStream();

		//Get the workbook instance for XLS stream
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook(inputStream);
		HSSFSheet ws  = wb.getSheet("Liste_établissement 2010");
		
		int rowNum = ws.getLastRowNum() + 1 ;
			
		for  ( int i = 3 ; i < 100 ; i++) {
			HSSFRow row = ws.getRow(i) ;
			if(classement.equals(row.getCell(2).toString().trim()))	{
				Hebergement heb = new Hebergement();
				heb.setId(new Long(i));
				heb.setProvince(row.getCell(0).toString());
				heb.setHebergement(row.getCell(1).toString());
				heb.setClassement(row.getCell(2).toString());
				heb.setEmail(row.getCell(3).toString());
				heb.setTel(row.getCell(4).toString());
				heb.setFax(row.getCell(5).toString());
				heb.setAdresse(row.getCell(6).toString());
				
				execute.add(heb);
			}
			
			}
			for (Hebergement obj : execute);

		return CollectionResponse.<Hebergement> builder().setItems(execute).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getHebergement")
	public Hebergement getHebergement(@Named("id") Long id) {
		Hebergement hebergement = null;
		for(Hebergement h:execute){
			if(h.getId().equals(id)){
				hebergement = h ;
			}
		}
		return hebergement;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param hebergement the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertHebergement")
	public Hebergement insertHebergement(Hebergement hebergement) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsHebergement(hebergement)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.makePersistent(hebergement);
		} finally {
			mgr.close();
		}
		return hebergement;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param hebergement the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateHebergement")
	public Hebergement updateHebergement(Hebergement hebergement) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsHebergement(hebergement)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(hebergement);
		} finally {
			mgr.close();
		}
		return hebergement;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeHebergement")
	public void removeHebergement(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Hebergement hebergement = mgr.getObjectById(Hebergement.class, id);
			mgr.deletePersistent(hebergement);
		} finally {
			mgr.close();
		}
	}

	private boolean containsHebergement(Hebergement hebergement) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Hebergement.class, hebergement.getId());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}
