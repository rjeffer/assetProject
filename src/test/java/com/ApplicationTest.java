package com;

import com.disney.controller.GeneralController;

import org.junit.Before;
import org.junit.Test;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import com.disney.service.DBService;
import org.mockito.Mockito;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import java.util.Optional;

public class ApplicationTest {

	private MockMvc mvc;

	private GeneralController controller;

	private DBService service;

	public ApplicationTest() {

		service = Mockito.mock(DBService.class);
		controller = new GeneralController();
	}

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void createAsset() throws Exception {

		String xml = "<asset>\n" + "<id>1237</id>\n" + "<channel>espn5</channel>\n" + "<assetType>promo</assetType>\n"
				+ "<som>01:00:00;0001</som>\n" + "<duration>00:00:30;00</duration>\n"
				+ "<title>Just do it - Nike</title>\n" + "<airDate>04/23/2021</airDate>\n" + "<cc>false</cc>\n"
				+ "<audio>5.1</audio>\n" + "<frameRate>59.94</frameRate>\n" + "\n" + "</asset>";

		mvc.perform(post("/new").contentType(MediaType.APPLICATION_XML).content(xml));

	}

	@Test
	public void getById() throws Exception {
		Mockito.doReturn(Optional.empty()).when(service).getAssetById("1237");

		mvc.perform(get("/get/1237")).andExpect(MockMvcResultMatchers.status().is(HttpStatus.FOUND.value()));
	}

	@Test
	public void getAll() throws Exception {
		Mockito.doReturn(Optional.empty());

		mvc.perform(get("/get/")).andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
	}

	@Test
	public void update() throws Exception {

		String xml = "<asset>\n" + "<id>1237</id>\n" + "<channel>espn789</channel>\n" + "<assetType>promo</assetType>\n"
				+ "<som>01:00:00;0001</som>\n" + "<duration>00:00:30;00</duration>\n"
				+ "<title>Just do it - Nike</title>\n" + "<airDate>04/23/2021</airDate>\n" + "<cc>false</cc>\n"
				+ "<audio>5.6</audio>\n" + "<frameRate>59.94</frameRate>\n" + "\n" + "</asset>";

		Mockito.doReturn(Optional.empty());

		mvc.perform(put("/update").content(xml).content(MediaType.APPLICATION_XML_VALUE))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.NOT_FOUND.value()));
	}

	@Test
	public void delete() throws Exception {

		Mockito.doReturn(Optional.empty());

		mvc.perform(MockMvcRequestBuilders.delete("/delete"));

	}
	
	@Test
	public void deleteById() throws Exception {

		Mockito.doReturn(Optional.empty());

		mvc.perform(MockMvcRequestBuilders.delete("/delete/1237"));

	}

}
