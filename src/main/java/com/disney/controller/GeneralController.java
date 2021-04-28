package com.disney.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.disney.service.DBService;
import com.disney.model.Asset;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class GeneralController {

	@Autowired
	DBService dbService;

	private static final Logger LOGGER = LogManager.getLogger(GeneralController.class);

	
	//API for adding new asset
	@PostMapping(path="/new", consumes= {"application/xml"})
	
	public String newAsset(@RequestBody Asset value) {

		LOGGER.info("Added asset with id " + value.getId());
		
		dbService.newAsset(value);
		
		return "Successfully created asset";

	}

	//API for getting assets
	@GetMapping(path="/get", produces= {"application/xml"})
	public List<Asset> getAssets() {

		List<Asset> assets = dbService.getAssets();
		
		LOGGER.info("Successfully retrieve assets");


		return assets;
	}
	
	
	//API for getting asset based off an id
	@GetMapping(path="/get/{id}", produces= {"application/xml"})
	
	public List<Asset> getAssetById(@PathVariable String id) {

		List<Asset> asset = dbService.getAssetById(id);
		
		
		return asset;
	}
	
	
	//Update an asset according to id
	@PutMapping(path = "/update", consumes= {"application/xml"})
	
	public String update(@RequestBody Asset value) {

		return dbService.update(value);
	}
	
	
	//API for deleting an single asset
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable String id) {

		dbService.deleteById(id);

	}
	
	//API for deleting all assets
	@DeleteMapping("/deleteAll")
	public void delete() {

		dbService.delete();

	}
	
}