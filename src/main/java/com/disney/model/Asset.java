package com.disney.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Asset {

	private String id;
	private String channel;
	private String assetType;
	private String som;
	private String duration;
	private String title;
	private String airDate;
	private String cc;
	private String audio;
	private String frameRate;

	public Asset() {

	}

	public Asset(String id, String channel, String assetType, String som, String duration, String title, String airDate,
			String cc, String audio, String frameRate) {

		this.id = id;
		this.channel = channel;
		this.assetType = assetType;
		this.som = som;
		this.duration = duration;
		this.title = title;
		this.airDate = airDate;
		this.cc = cc;
		this.audio = audio;
		this.frameRate = frameRate;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getSom() {
		return som;
	}

	public void setSom(String som) {
		this.som = som;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAirDate() {
		return airDate;
	}

	public void setAirDate(String airDate) {
		this.airDate = airDate;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public String getFrameRate() {
		return frameRate;
	}

	public void setFrameRate(String frameRate) {
		this.frameRate = frameRate;
	}

	@Override
	public String toString() {
		String info = String.format(
				"Asset Info: channel = %s, assetType = %s, som = %s, "
						+ "duration = %s, title = %s, airDate = %s, cc = %s, " + "audio = %s, frameRate = %s",
				channel, assetType, som, duration, title, airDate, cc, audio, frameRate);

		return info;
	}

}
