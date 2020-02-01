package com.coleman.randomizer.domain;

public class Model {
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer employeeId;
    private String homeAddress;
    private String dateStarted;
    private String dateLastUpdated;
    private Integer managersId;
    private String managersName;
    private String storeAddress;
    private String dataset;

    public Model() {
    }

    public Model(String firstName, String middleName, String lastName, Integer employeeId, String homeAddress, String dateStarted, String dateLastUpdated, Integer managersId, String managersName, String storeAddress, String dataset) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.homeAddress = homeAddress;
        this.dateStarted = dateStarted;
        this.dateLastUpdated = dateLastUpdated;
        this.managersId = managersId;
        this.managersName = managersName;
        this.storeAddress = storeAddress;
        this.dataset = dataset;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(String dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public Integer getManagersId() {
        return managersId;
    }

    public void setManagersId(Integer managersId) {
        this.managersId = managersId;
    }

    public String getManagersName() {
        return managersName;
    }

    public void setManagersName(String managersName) {
        this.managersName = managersName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }
}
