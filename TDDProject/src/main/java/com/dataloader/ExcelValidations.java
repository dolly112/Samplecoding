package com.dataloader;

import java.io.IOException;
import java.util.List;

import com.utilities.ExcelActions;



public class ExcelValidations {
	//List values
	
	private String costCenter;
	private String subDepartment;
	private String department;
	private String plant;
	private String Description;
	// private static ExcelActions excelRW;
	private String database;
	private String d_Description;
	private String rolename;
	private String r_Description;
	// Manage Users variables
	private String userIDMU;

	private String mangeUserFirstName;
	private String manageUserSurName;
	private String manageUserPlant;
	private String manageUserCostCenter;
	private String manageUserModifyUser;
	private String manageUserDepartment;
	private String manageUserEmail;
	// searchValues Cost center
	private String costCenterSearchValue;
	private String search;
	private String searchValues;
	// Manage Roles

	private String manageRoleName;
	private String manageRoleDescription;
	private String ResetNoHighlightedColorForUnsavedChanges;
	// request access variables
	private String remark;
	private String userToFindReqAccess;
	private String rolesToEnable;
	private String rejectComments;
	private String nonConfigStatus;
	private String databaseRequest;
	
	private String mapRoles;
	
	//newly added List
	private List<String> plantList;
	private List<String> departmentList;
	private List<String> subDepartmentList;
	private List<String> costcenterList;
	private List<String> RemarkList;
	private List<String> userToFindReqAccessList;
	private List<String> rolesToEnableList;
	private List<String> rejectCommentsList;
	private List<String> nonConfigStatusList;
	private List<String> databaseRequestList;
	private List<String> mapRolesList;
	
	//database List
	private List<String> databaseList;
	private List<String> descriptionList;

	public String getManageRoleName() {
		return manageRoleName;
	}

	public void setManageRoleName(String manageRoleName) {
		this.manageRoleName = manageRoleName;
	}

	public String getManageRoleDescription() {
		return manageRoleDescription;
	}

	public void setManageRoleDescription(String manageRoleDescription) {
		this.manageRoleDescription = manageRoleDescription;
	}

	public String getMangeUserFirstName() {
		return mangeUserFirstName;
	}

	public void setMangeUserFirstName(String mangeUserFirstName) {
		this.mangeUserFirstName = mangeUserFirstName;
	}

	public String getManageUserSurName() {
		return manageUserSurName;
	}

	public void setManageUserSurName(String manageUserSurName) {
		this.manageUserSurName = manageUserSurName;
	}

	public String getManageUserPlant() {
		return manageUserPlant;
	}

	public void setManageUserPlant(String manageUserPlant) {
		this.manageUserPlant = manageUserPlant;
	}

	public String getManageUserCostCenter() {
		return manageUserCostCenter;
	}

	public void setManageUserCostCenter(String manageUserCostCenter) {
		this.manageUserCostCenter = manageUserCostCenter;
	}

	public String getManageUserModifyUser() {
		return manageUserModifyUser;
	}

	public void setManageUserModifyUser(String manageUserModifyUser) {
		this.manageUserModifyUser = manageUserModifyUser;
	}

	public String getManageUserDepartment() {
		return manageUserDepartment;
	}

	public void setManageUserDepartment(String manageUserDepartment) {
		this.manageUserDepartment = manageUserDepartment;
	}

	public String getManageUserEmail() {
		return manageUserEmail;
	}

	public void setManageUserEmail(String manageUserEmail) {
		this.manageUserEmail = manageUserEmail;
	}

	private static ExcelActions excelRW;

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
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

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getD_Description() {
		return d_Description;
	}

	public void setD_Description(String dDescription) {
		d_Description = dDescription;
	}

	public String getRoleName() {
		return rolename;
	}

	public void setRoleName(String rolename) {
		this.rolename = rolename;
	}

	public String getR_Description() {
		return r_Description;
	}

	public void setR_Description(String rDescription) {
		r_Description = rDescription;
	}

	public String getUserIDMU() {
		return userIDMU;
	}

	public void setUserIDMU(String userIDMU) {
		this.userIDMU = userIDMU;
	}

	public void setCostCenterValues(String testcaseName, String sheetName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setCostCenter(excelRW.getData(sheetName, testcaseName, "Costcenter"));
		setSubDepartment(excelRW.getData(sheetName, testcaseName, "SubDepartment"));
		setDepartment(excelRW.getData(sheetName, testcaseName, "Department"));
		setPlant(excelRW.getData(sheetName, testcaseName, "Plant"));
		setDescription(excelRW.getData(sheetName, testcaseName, "MC_Description"));
		setCostCenterSearchValue(excelRW.getData(sheetName, testcaseName, "CostCenterSearch"));
		setSearch(excelRW.getData(sheetName, testcaseName, "Search"));
		setSearchValues(excelRW.getData(sheetName, testcaseName, "SearchValues"));
	}

	public void setCostCenterValuesUpdated(String testcaseName) { // toreduceTimeofSettingTabOfExcel
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setCostCenter(excelRW.getData("ManageCostcenter_EN", testcaseName, "Costcenter"));
		setSubDepartment(excelRW.getData("ManageCostcenter_EN", testcaseName, "SubDepartment"));
		setDepartment(excelRW.getData("ManageCostcenter_EN", testcaseName, "Department"));
		setPlant(excelRW.getData("ManageCostcenter_EN", testcaseName, "Plant"));
		setDescription(excelRW.getData("ManageCostcenter_EN", testcaseName, "MC_Description"));
		setCostCenterSearchValue(excelRW.getData("ManageCostcenter_EN", testcaseName, "CostCenterSearch"));
		setSearch(excelRW.getData("ManageCostcenter_EN", testcaseName, "Search"));
		setSearchValues(excelRW.getData("ManageCostcenter_EN", testcaseName, "SearchValues"));
	}

	public void setCostCenterValuesOfMapRoles(String testcaseName, String sheetName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setCostCenter(excelRW.getData(sheetName, testcaseName, "Costcenter"));
		setResetNoHighlightedColorForUnsavedChanges(
				excelRW.getData(sheetName, testcaseName, "ResetNoHighlightedColorForUnsavedChanges"));
		setRoleName(excelRW.getData(sheetName, testcaseName, "RoleName"));

	}

	public void setCostCenterValuesOfMapRolesUpdated(String testcaseName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setCostCenter(excelRW.getData("MapRoles_EN", testcaseName, "Costcenter"));
		setResetNoHighlightedColorForUnsavedChanges(
				excelRW.getData("MapRoles_EN", testcaseName, "ResetNoHighlightedColorForUnsavedChanges"));
		setRoleName(excelRW.getData("MapRoles_EN", testcaseName, "RoleName"));

	}

	public void setUserID(String testcaseName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setUserIDMU(excelRW.getData("ManageUsers_EN", testcaseName, "UserID"));
	}

	public void setCostCenterData(String testcaseName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setCostCenter(excelRW.getData("ManageCostcenter_EN", testcaseName, "Costcenter"));
	}

	/**
	 * Test steps details
	 * 
	 * @author MSURABH
	 * @throws IOException
	 */
	public void setDatabaseValues() {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDatabase(excelRW.getData("ManageDatabase_EN", "TestCase0012_addDatabaseToAddEditDatabasesPage", "Database"));
		setD_Description(excelRW.getData("ManageDatabase_EN", "TestCase0012_addDatabaseToAddEditDatabasesPage",
				"D_Description"));
	}

	/**
	 * Test steps details
	 * 
	 * @author MSURABH
	 * @throws IOException
	 */
	public void setRoleName() {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setRoleName(excelRW.getData("ManageRoles_EN", "TestCase0022_addingRolesOnManageRolesPage", "Role_Name"));
		setR_Description(
				excelRW.getData("ManageRoles_EN", "TestCase0022_addingRolesOnManageRolesPage", "R_Description"));
	}

	/**
	 * Test steps details
	 * 
	 * @author MSURABH
	 * @throws IOException
	 */
	public void editDatabaseValues() {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDatabase(
				excelRW.getData("ManageDatabase_EN", "TestCase0013_editDatabaseToAddEditDatabasesPage", "Database"));
		setD_Description(excelRW.getData("ManageDatabase_EN", "TestCase0013_editDatabaseToAddEditDatabasesPage",
				"D_Description"));
	}

	public void setDatabaseData(String testcaseName, String sheetName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDatabase(excelRW.getData(sheetName, testcaseName, "Database"));
		setD_Description(excelRW.getData(sheetName, testcaseName, "DatabaseDescription"));
		setDescription(excelRW.getData(sheetName, testcaseName, "Description"));
		setSearch(excelRW.getData(sheetName, testcaseName, "Search"));
		setSearchValues(excelRW.getData(sheetName, testcaseName, "SearchValues"));

	}

	public void setDatabaseDataUpdated(String testcaseName,String sheetName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDatabase(excelRW.getData(sheetName, testcaseName, "Database"));
		setD_Description(excelRW.getData(sheetName, testcaseName, "DatabaseDescription"));
		setDescription(excelRW.getData(sheetName, testcaseName, "Description"));
		setSearch(excelRW.getData(sheetName, testcaseName, "Search"));
		setSearchValues(excelRW.getData(sheetName, testcaseName, "SearchValues"));

	}

	public void setDatabaseValues(String testcaseName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDatabase(excelRW.getData("ManageDatabase_EN", testcaseName, "Database"));

		setD_Description(excelRW.getData("ManageDatabase_EN", testcaseName, "D_Description"));

	}

	public void setDatabaseValuesUpdated(String sheetName ,String testcaseName) {//ManageDatabase_EN
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDatabase(excelRW.getData(sheetName, testcaseName, "Database"));

		setDescription(excelRW.getData(sheetName, testcaseName, "Description"));
		

	}

	public void setManageUserFields(String testcaseName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMangeUserFirstName(excelRW.getData("ManageUsers_EN", testcaseName, "FirstName"));
		setManageUserSurName(excelRW.getData("ManageUsers_EN", testcaseName, "SurName"));
		setManageUserPlant(excelRW.getData("ManageUsers_EN", testcaseName, "Plant"));
		setManageUserCostCenter(excelRW.getData("ManageUsers_EN", testcaseName, "CostCenter"));
		setManageUserDepartment(excelRW.getData("ManageUsers_EN", testcaseName, "Department"));
		setManageUserEmail(excelRW.getData("ManageUsers_EN", testcaseName, "Email"));
		setManageUserModifyUser(excelRW.getData("ManageUsers_EN", testcaseName, "ModifyUser"));
	}

	public void setManageRoleNameFromExcel(String testcaseName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setManageRoleName(excelRW.getData("ManageRoles_EN", testcaseName, "RoleName"));
	}

	public void setRoleDescriptionFromExcel(String testcaseName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setManageRoleDescription(excelRW.getData("ManageRoles_EN", testcaseName, "RoleDescription"));
	}

	public void setRoleAndDescriptionFromExcel(String testcaseName, String sheetName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setManageRoleName(excelRW.getData(sheetName, testcaseName, "RoleName"));
		setManageRoleDescription(excelRW.getData(sheetName, testcaseName, "RoleDescription"));
	}

	public String getCostCenterSearchValue() {
		return costCenterSearchValue;
	}

	public void setCostCenterSearchValue(String costCenterSearchValue) {
		this.costCenterSearchValue = costCenterSearchValue;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearchValues() {
		return searchValues;
	}

	public void setSearchValues(String searchValues) {
		this.searchValues = searchValues;
	}

	public String getResetNoHighlightedColorForUnsavedChanges() {
		return ResetNoHighlightedColorForUnsavedChanges;
	}

	public void setResetNoHighlightedColorForUnsavedChanges(String resetNoHighlightedColorForUnsavedChanges) {
		this.ResetNoHighlightedColorForUnsavedChanges = resetNoHighlightedColorForUnsavedChanges;
	}

	public void setRequestAccessData(String testcaseName, String sheetName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setPlant(excelRW.getData(sheetName, testcaseName, "Plant"));
		setDepartment(excelRW.getData(sheetName, testcaseName, "Department"));
		setSubDepartment(excelRW.getData(sheetName, testcaseName, "SubDepartment"));
		setCostCenter(excelRW.getData(sheetName, testcaseName, "Costcenter"));
		setRemark(excelRW.getData(sheetName, testcaseName, "Remark"));
		setRolesToEnable(excelRW.getData(sheetName, testcaseName, "rolesToEnable"));

	}

	/**
	 * Pending,approved and rejected count- not implemented
	 */
	public void setRequestAccessDataUpdated(String testcaseName,String sheetName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setPlant(excelRW.getData(sheetName, testcaseName, "Plant"));
		setDepartment(excelRW.getData(sheetName, testcaseName, "Department"));
		setSubDepartment(excelRW.getData(sheetName, testcaseName, "SubDepartment"));
		setCostCenter(excelRW.getData(sheetName, testcaseName, "Costcenter"));
		setRemark(excelRW.getData(sheetName, testcaseName, "Remark"));
		setUserToFindReqAccess(excelRW.getData(sheetName, testcaseName, "userToFindReqAccess"));
		setRolesToEnable(excelRW.getData(sheetName, testcaseName, "rolesToEnable"));
		setRejectComments(excelRW.getData(sheetName ,testcaseName, "RejectComments"));
		setNonConfigStatus(excelRW.getData(sheetName, testcaseName, "nonConfigStatus"));
		setDatabaseRequest(excelRW.getData(sheetName, testcaseName, "DatabaseRequest"));
		setMapRoles(excelRW.getData(sheetName, testcaseName, "MapRoles"));

//		setPendingRequestCount(
//				excelRW.getData(sheetName,testcaseName, "PendingRequestCount")); 
//		setApprovedRequestCount(
//				excelRW.getData(sheetName,testcaseName, "ApprovedRequestCount"));
//		setRequestedRequestCount(
//				excelRW.getData(sheetName,testcaseName, "RejectedRequestCount"));

	}
	
	public void setRequestAccessDataByPassingValues(String mapRoles2, String userToFindReqAccess2, String rolesToEnable2, String remark2, String databaseRequest2, String nonConfigStatusLi, String plant2, String department2, String subDept, String costcenter2) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setPlant(plant2);
		setDepartment(department2);
		setSubDepartment(subDept);
		setCostCenter(costcenter2);
		setRemark(remark2);
		setUserToFindReqAccess(userToFindReqAccess2);
		setRolesToEnable(rolesToEnable2);
//		setRejectComments();
		setNonConfigStatus(nonConfigStatusLi);
		setDatabaseRequest(databaseRequest2);
		setMapRoles(mapRoles2);
		setDatabase(databaseRequest2);

//		setPendingRequestCount(
//				excelRW.getData(sheetName,testcaseName, "PendingRequestCount")); 
//		setApprovedRequestCount(
//				excelRW.getData(sheetName,testcaseName, "ApprovedRequestCount"));
//		setRequestedRequestCount(
//				excelRW.getData(sheetName,testcaseName, "RejectedRequestCount"));

	}
	
	public void setRequestAccessDataDBList(String testcaseName,String sheetName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setPlantList(excelRW.getDataList(sheetName, testcaseName, "Plant"));
		setDepartmentList(excelRW.getDataList(sheetName, testcaseName, "Department"));
		setSubDepartmentList(excelRW.getDataList(sheetName, testcaseName, "SubDepartment"));
		setCostcenterList(excelRW.getDataList(sheetName, testcaseName, "Costcenter"));
		setRemarkList(excelRW.getDataList(sheetName, testcaseName, "Remark"));
		setUserToFindReqAccessList(excelRW.getDataList(sheetName, testcaseName, "userToFindReqAccess"));
		setRolesToEnableList(excelRW.getDataList(sheetName, testcaseName, "rolesToEnable"));
		setRejectCommentsList(excelRW.getDataList(sheetName ,testcaseName, "RejectComments"));
		setNonConfigStatusList(excelRW.getDataList(sheetName, testcaseName, "nonConfigStatus"));
		setDatabaseRequestList(excelRW.getDataList(sheetName, testcaseName, "DatabaseRequest"));
		setMapRolesList(excelRW.getDataList(sheetName, testcaseName, "MapRoles"));
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRolesToEnable() {
		return rolesToEnable;
	}

	public void setRolesToEnable(String rolesToEnable) {
		this.rolesToEnable = rolesToEnable;
	}

	public String getUserToFindReqAccess() {
		return userToFindReqAccess;
	}

	public void setUserToFindReqAccess(String userToFindReqAccess) {
		this.userToFindReqAccess = userToFindReqAccess;
	}

	public void setCostCenterValuesToAddData(String testcaseName) { // toreduceTimeofSettingTabOfExcel
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setCostCenter(excelRW.getData("CCAddData", testcaseName, "Costcenter"));
		setSubDepartment(excelRW.getData("CCAddData", testcaseName, "SubDepartment"));
		setDepartment(excelRW.getData("CCAddData", testcaseName, "Department"));
		setPlant(excelRW.getData("CCAddData", testcaseName, "Plant"));
		setDescription(excelRW.getData("CCAddData", testcaseName, "MC_Description"));
		setCostCenterSearchValue(excelRW.getData("CCAddData", testcaseName, "CostCenterSearch"));
		setSearch(excelRW.getData("CCAddData", testcaseName, "Search"));
		setSearchValues(excelRW.getData("CCAddData", testcaseName, "SearchValues"));
	}

	public String getRejectComments() {
		return rejectComments;
	}

	public void setRejectComments(String rejectComments) {
		this.rejectComments = rejectComments;
	}

	public String getNonConfigStatus() {
		return nonConfigStatus;
	}

	public void setNonConfigStatus(String nonConfigStatus) {
		this.nonConfigStatus = nonConfigStatus;
	}

	public String getDatabaseRequest() {
		return databaseRequest;
	}

	public void setDatabaseRequest(String databaseRequest) {
		this.databaseRequest = databaseRequest;
	}

	public String getMapRoles() {
		return mapRoles;
	}

	public void setMapRoles(String mapRoles) {
		this.mapRoles = mapRoles;
	}

	public List<String> getPlantList() {
		return plantList;
	}

	public void setPlantList(List<String> plantList) {
		this.plantList = plantList;
	}

	public List<String> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<String> departmentList) {
		this.departmentList = departmentList;
	}

	public List<String> getSubDepartmentList() {
		return subDepartmentList;
	}

	public void setSubDepartmentList(List<String> subDepartmentList) {
		this.subDepartmentList = subDepartmentList;
	}

	public List<String> getCostcenterList() {
		return costcenterList;
	}

	public void setCostcenterList(List<String> costcenterList) {
		this.costcenterList = costcenterList;
	}

	public List<String> getRemarkList() {
		return RemarkList;
	}

	public void setRemarkList(List<String> remarkList) {
		RemarkList = remarkList;
	}

	public List<String> getUserToFindReqAccessList() {
		return userToFindReqAccessList;
	}

	public void setUserToFindReqAccessList(List<String> userToFindReqAccessList) {
		this.userToFindReqAccessList = userToFindReqAccessList;
	}

	public List<String> getRolesToEnableList() {
		return rolesToEnableList;
	}

	public void setRolesToEnableList(List<String> rolesToEnableList) {
		this.rolesToEnableList = rolesToEnableList;
	}

	public List<String> getRejectCommentsList() {
		return rejectCommentsList;
	}

	public void setRejectCommentsList(List<String> rejectCommentsList) {
		this.rejectCommentsList = rejectCommentsList;
	}

	public List<String> getNonConfigStatusList() {
		return nonConfigStatusList;
	}

	public void setNonConfigStatusList(List<String> nonConfigStatusList) {
		this.nonConfigStatusList = nonConfigStatusList;
	}

	public List<String> getDatabaseRequestList() {
		return databaseRequestList;
	}

	public void setDatabaseRequestList(List<String> databaseRequestList) {
		this.databaseRequestList = databaseRequestList;
	}

	public List<String> getMapRolesList() {
		return mapRolesList;
	}

	public void setMapRolesList(List<String> mapRolesList) {
		this.mapRolesList = mapRolesList;
	}

	/**
	 * @param testcaseNameCC
	 * @param sheetName
	 */
	public void setRequestAccessCombinationsDataList(String testcaseName, String sheetName) {
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setPlantList(excelRW.getDataList(sheetName, testcaseName, "Plant"));
		setDepartmentList(excelRW.getDataList(sheetName, testcaseName, "Department"));
		setSubDepartmentList(excelRW.getDataList(sheetName, testcaseName, "SubDepartment"));
		setCostcenterList(excelRW.getDataList(sheetName, testcaseName, "Costcenter"));
		setRemarkList(excelRW.getDataList(sheetName, testcaseName, "Remark"));
		setUserToFindReqAccessList(excelRW.getDataList(sheetName, testcaseName, "userToFindReqAccess"));
		setRolesToEnableList(excelRW.getDataList(sheetName, testcaseName, "rolesToEnable"));
		setRejectCommentsList(excelRW.getDataList(sheetName ,testcaseName, "RejectComments"));
		setNonConfigStatusList(excelRW.getDataList(sheetName, testcaseName, "nonConfigStatus"));
		setDatabaseRequestList(excelRW.getDataList(sheetName, testcaseName, "DatabaseRequest"));
		setMapRolesList(excelRW.getDataList(sheetName, testcaseName, "MapRoles"));

//		setPendingRequestCount(
//				excelRW.getData(sheetName,testcaseName, "PendingRequestCount")); 
//		setApprovedRequestCount(
//				excelRW.getData(sheetName,testcaseName, "ApprovedRequestCount"));
//		setRequestedRequestCount(
//				excelRW.getData(sheetName,testcaseName, "RejectedRequestCount"));

	}
	
	public List<String> getDatabaseList() {
		return databaseList;
	}

	public void setDatabaseList(List<String> databaseList) {
		this.databaseList = databaseList;
	}

	public List<String> getDescriptionList() {
		return descriptionList;
	}

	public void setDescriptionList(List<String> descriptionList) {
		this.descriptionList = descriptionList;
	}
	
	public void setDatabaseValuesList(String sheetName ,String testcaseName) {//ManageDatabase_EN
		try {
			excelRW = new ExcelActions(System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDatabaseList(excelRW.getDataList(sheetName, testcaseName, "Database"));
		setDescriptionList(excelRW.getDataList(sheetName, testcaseName, "Description"));
		
		

	}


}
