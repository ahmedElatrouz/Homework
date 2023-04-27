package com.aelatrouz.dto;

import java.io.Serializable;

public class ConventionDto implements Serializable {

	private boolean active;
	private String date_publi;
	private String etat;
	private String id;
	private long mtime;
	private String nature;
	private String num;
	private String texte_de_base;
	private String title;
	private long effectif;
	private String shortTitle;
	private String url;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDate_publi() {
		return date_publi;
	}

	public void setDate_publi(String date_publi) {
		this.date_publi = date_publi;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getMtime() {
		return mtime;
	}

	public void setMtime(long mtime) {
		this.mtime = mtime;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTexte_de_base() {
		return texte_de_base;
	}

	public void setTexte_de_base(String texte_de_base) {
		this.texte_de_base = texte_de_base;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getEffectif() {
		return effectif;
	}

	public void setEffectif(long effectif) {
		this.effectif = effectif;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
