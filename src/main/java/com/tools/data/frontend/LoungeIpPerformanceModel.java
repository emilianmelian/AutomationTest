package com.tools.data.frontend;

public class LoungeIpPerformanceModel {

	private String careerLevel;
	private String payLevel;
	private String careerLevelName;
	private String individualPoints;
	private String unsafeIndividualPoints;
	private String teamPoints;
	private String styleCoachFirstLevel;
	private String goldStyleCoaches;

	
	
	
	public String getCareerLevelName() {
		return careerLevelName;
	}

	public void setCareerLevelName(String careerLevelName) {
		this.careerLevelName = careerLevelName;
	}

	public String getCareerLevel() {
		return careerLevel;
	}

	public void setCareerLevel(String careerLevel) {
		this.careerLevel = careerLevel;
	}

	public String getPayLevel() {
		return payLevel;
	}

	public void setPayLevel(String payLevel) {
		this.payLevel = payLevel;
	}

	public String getIndividualPoints() {
		return individualPoints;
	}

	public void setIndividualPoints(String individualPoints) {
		this.individualPoints = individualPoints;
	}

	public String getTeamPoints() {
		return teamPoints;
	}

	public void setTeamPoints(String teamPoints) {
		this.teamPoints = teamPoints;
	}

	public String getStyleCoachFirstLevel() {
		return styleCoachFirstLevel;
	}

	public void setStyleCoachFirstLevel(String styleCoachFirstLevel) {
		this.styleCoachFirstLevel = styleCoachFirstLevel;
	}

	public String getGoldStyleCoaches() {
		return goldStyleCoaches;
	}

	public void setGoldStyleCoaches(String goldStyleCoaches) {
		this.goldStyleCoaches = goldStyleCoaches;
	}

	public String getUnsafeIndividualPoints() {
		return unsafeIndividualPoints;
	}

	public void setUnsafeIndividualPoints(String unsafeIndividualPoints) {
		this.unsafeIndividualPoints = unsafeIndividualPoints;
	}

	@Override
	public String toString() {
		return "LoungeIpPerformanceModel [careerLevel=" + careerLevel + ", payLevel=" + payLevel + ", careerLevelName="
				+ careerLevelName + ", individualPoints=" + individualPoints + ", unsafeIndividualPoints="
				+ unsafeIndividualPoints + ", teamPoints=" + teamPoints + ", styleCoachFirstLevel="
				+ styleCoachFirstLevel + ", goldStyleCoaches=" + goldStyleCoaches + "]";
	}

	
}
