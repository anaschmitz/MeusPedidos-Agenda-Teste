package entity;

import java.util.Date;

import utils.AppointmentType;
import utils.DateUtils;

public class Appointment {

	private AppointmentType type;
	private String client;
	private int cbDateIndex;
	private Date date;
	private String dateFormatted;
	private String hourFormmatted;
	private String user;
	private String note;
	private String description;
	private boolean done;

	public Appointment(AppointmentType type, String client, int cbDateIndex, Date date, String user, String note) {
		this.type = type;
		this.client = client;
		this.cbDateIndex = cbDateIndex;
		this.date = date;
		this.user = user;
		this.note = note;
		this.dateFormatted = null;
		this.hourFormmatted = null;
	}

	public Appointment(AppointmentType type, String client, Date date, String user, String note, boolean done,
			String description) {
		this.type = type;
		this.client = client;
		this.date = date;
		this.user = user;
		this.note = note;
		this.done = done;
		this.description = description;
		this.dateFormatted = null;
		this.hourFormmatted = null;
	}

	public Appointment(AppointmentType type, String client, String description, Date date) {
		this.type = type;
		this.client = client;
		this.description = description;
		this.date = date;
		this.dateFormatted = null;
		this.hourFormmatted = null;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
		this.dateFormatted = null;
		this.hourFormmatted = null;
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

	public String getDateFormatted() {
		if (dateFormatted == null) {
			dateFormatted = DateUtils.getDateFormatted(getDate(), DateUtils.BR_PATTERN);
		}
		return dateFormatted;
	}

	public String getHourFormmatted() {
		if (hourFormmatted == null) {
			hourFormmatted = DateUtils.getDateFormatted(getDate(), DateUtils.HOUR_PATTERN);
		}
		return hourFormmatted;
	}

}
