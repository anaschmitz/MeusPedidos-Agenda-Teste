package utils;

public enum Status {
	
	ALLACTIVITIES("Todas as Atividades"), 
	ACTIVITIESNOTDONE("Atividades não realizadas"), 
	ACTIVITIESDONE("Atividades realizadas");
	
	Status(String label){
		this.label = label;
	}
	
	private String label;
	
	public String getLabel(){
		return this.label;
	}

}
