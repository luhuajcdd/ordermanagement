package com.dehua.order.model;

public class User {

	public long id; 
	public String name;
	public UserType type;
	public String email;
	public String receiverCountry;//收货国家
	public String receiverProvince;//收货州/省
	public String receiveCity;//收货城市
	public String address;//地址
	public String zipCode;//邮编
	public String phone;//联系电话
	public String mobilePhone;//手机
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public UserType getType() {
		return type;
	}
	public String getEmail() {
		return email;
	}
	public String getReceiverCountry() {
		return receiverCountry;
	}
	public String getReceiverProvince() {
		return receiverProvince;
	}
	public String getReceiveCity() {
		return receiveCity;
	}
	public String getAddress() {
		return address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public String getPhone() {
		return phone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	
	
}

