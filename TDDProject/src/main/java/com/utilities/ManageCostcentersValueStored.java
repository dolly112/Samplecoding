package com.utilities;

/**
 * @author ROSMOLS
 *
 */
public class ManageCostcentersValueStored {

	/**newly added DAtabase after db column */
	String costcenter;
	String description;
	String subDepartment;
	String department;
	String plant;
	String assignedDatabases;
	String assignedRules;
	String remark;
	Boolean plaUser;
	Boolean plaRecall;
	Boolean plaAdmin;
	Boolean plaReporting;
	String role;
	String database;
	// requets access page
	String pendingRequestCount;
	String approvedRequestCount;
	String rejectedRequestCount;
	//request access config status
	String nonConfigStatus;
	String userToFind;

	public String getPendingRequestCount() {
		return pendingRequestCount;
	}

	public void setPendingRequestCount(String pendingRequestCount) {
		this.pendingRequestCount = pendingRequestCount;
	}

	public String getApprovedRequestCount() {
		return approvedRequestCount;
	}

	public void setApprovedRequestCount(String approvedRequestCount) {
		this.approvedRequestCount = approvedRequestCount;
	}

	public String getRejectedRequestCount() {
		return rejectedRequestCount;
	}

	public void setRejectedRequestCount(String rejectedRequestCount) {
		this.rejectedRequestCount = rejectedRequestCount;
	}

	

	public ManageCostcentersValueStored() {
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubDepartment() {
		return subDepartment;
	}

	public void setSubDepartment(String subDepartment) {
		this.subDepartment = subDepartment;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getAssignedDatabases() {
		return assignedDatabases;
	}

	public void setAssignedDatabases(String assignedDatabases) {
		this.assignedDatabases = assignedDatabases;
	}

	public String getAssignedRules() {
		return assignedRules;
	}

	public void setAssignedRules(String assignedRules) {
		this.assignedRules = assignedRules;
	}

	public Boolean getPlaUser() {
		return plaUser;
	}

	public void setPlaUser(Boolean plaUser) {
		this.plaUser = plaUser;
	}

	public Boolean getPlaRecall() {
		return plaRecall;
	}

	public void setPlaRecall(Boolean plaRecall) {
		this.plaRecall = plaRecall;
	}

	public Boolean getPlaAdmin() {
		return plaAdmin;
	}

	public void setPlaAdmin(Boolean plaAdmin) {
		this.plaAdmin = plaAdmin;
	}

	public Boolean getPlaReporting() {
		return plaReporting;
	}

	public void setPlaReporting(Boolean plaReporting) {
		this.plaReporting = plaReporting;
	}

	@Override
	public String toString() {
		return "ManageCostcentersValueStored [costcenter=" + costcenter + ", description=" + description
				+ ", subDepartment=" + subDepartment + ", department=" + department + ", plant=" + plant
				+ ", assignedDatabases=" + assignedDatabases + ", assignedRules=" + assignedRules + ", remark=" + remark
				+ ", plaUser=" + plaUser + ", plaRecall=" + plaRecall + ", plaAdmin=" + plaAdmin + ", plaReporting="
				+ plaReporting + ", role=" + role + ", database=" + database + ", pendingRequestCount="
				+ pendingRequestCount + ", approvedRequestCount=" + approvedRequestCount + ", rejectedRequestCount="
				+ rejectedRequestCount + "]";
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getNonConfigStatus() {
		return nonConfigStatus;
	}

	public void setNonConfigStatus(String nonConfigStatus) {
		this.nonConfigStatus = nonConfigStatus;
	}

	public String getUserToFind() {
		return userToFind;
	}

	public void setUserToFind(String userToFind) {
		this.userToFind = userToFind;
	}



}
