package com.utilities;

/**
 * @author ROSMOLS
 *
 */
public class ManageDatabaseValueStored {
	
	
	String database;
	String description;
	String assignedCostcenters;
	String assignedRoles;
	String modifyDate;
	String modifyUser;
	
	
	
	
	
	public ManageDatabaseValueStored()
	{
		
	}


   public String toString()
   {
	   return "Database [database=" + database + ", description=" + description + ", assignedCostcenters="
				+ assignedCostcenters + ", assignedRoles=" + assignedRoles + ", modifyDate=" + modifyDate + ", modifyUser="
				+ modifyUser +"]";
   }


	public String getDatabase() {
		return database;
	}





	public void setDatabase(String database) {
		this.database = database;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public String getAssignedCostcenters() {
		return assignedCostcenters;
	}





	public void setAssignedCostcenters(String assignedCostcenters) {
		this.assignedCostcenters = assignedCostcenters;
	}





	public String getAssignedRoles() {
		return assignedRoles;
	}





	public void setAssignedRoles(String assignedRoles) {
		this.assignedRoles = assignedRoles;
	}





	public String getModifyDate() {
		return modifyDate;
	}





	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}





	public String getModifyUser() {
		return modifyUser;
	}





	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}










}