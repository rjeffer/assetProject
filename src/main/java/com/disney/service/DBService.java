package com.disney.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import com.disney.model.Asset;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@CacheConfig(cacheNames = { "assets" })
public class DBService {

	private static final Logger LOGGER = LogManager.getLogger(DBService.class);

	@Autowired
	CacheManager cacheManager;

	List<Asset> assets = new ArrayList<>();

	
	//Adding new asset to cache
	@Cacheable
	public List<Asset> newAsset(Asset asset) {

		assets.add(asset);

		return this.assets;
	}

	
	//Retrieve all the assets
	@Cacheable
	public List<Asset> getAssets() {

		simulate();

		return this.assets;

	}

	
	//Retrieves an individual asset by id
	@Cacheable
	public List<Asset> getAssetById(String id) {

		List<Asset> data = new ArrayList<>();

		for (int i = 0; i < assets.size(); i++) {

			if (assets.get(i).getId().equalsIgnoreCase(id)) {

				data.add(assets.get(i));
			}

		}

		return data;

	}

	
	//Updates an individual asset by id if found
	@CachePut
	public String update(Asset asset) {

		for (int i = 0; i < assets.size(); i++) {

			if (assets.get(i).getId().equalsIgnoreCase(asset.getId())) {

				assets.set(i, asset);

				return "Successfully updated";

			}

		}

		return "Asset doesn't exist";

	}
	
	//Deletes an asset by id

	public void deleteById(String id) {

		cacheManager.getCache("assets").evict(id);
	}

	
	//Deletes all from cache
	@CacheEvict(allEntries = true)
	public void delete() {

		for (String name : cacheManager.getCacheNames()) {
			cacheManager.getCache(name).clear();
		}
	}

	
	//Faster process to retrieve assets from cache
	private void simulate() {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}