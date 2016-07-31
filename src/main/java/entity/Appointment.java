package entity;

import utils.AppointmentType;

public class Appointment {

	private AppointmentType type;
	private String client;
	private int cbDateIndex;
	private String date;
	private String hour;
	private String user;
	private String note;

	public Appointment(AppointmentType type, String client, int cbDateIndex, String date, String hour, String user,
			String note) {
		this.type = type;
		this.client = client;
		this.cbDateIndex = cbDateIndex;
		this.date = date;
		this.hour = hour;
		this.user = user;
		this.note = note;
	}

	public AppointmentType getType() {
		return type;
	}

	public void setType(AppointmentType type) {
		this.type = type;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getCbDateIndex() {
		return cbDateIndex;
	}

	public void setCbDateIndex(int cbDateIndex) {
		this.cbDateIndex = cbDateIndex;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
