package utils;

public enum AppointmentType {

	ACTIVITY("Atividade"), 
	VISIT("Visita"), 
	CALL("Ligação");

	AppointmentType(String label) {
		this.label = label;
	}

	private String label;

	public String getLabel() {
		return this.label;
	}
}
