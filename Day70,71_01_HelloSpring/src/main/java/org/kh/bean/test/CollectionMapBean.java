package org.kh.bean.test;

import java.util.Map;

public class CollectionMapBean {
	private Map<String, String> addressList;

	public CollectionMapBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollectionMapBean(Map<String, String> addressList) {
		super();
		this.addressList = addressList;
	}

	public Map<String, String> getAddressList() {
		return addressList;
	}

	public void setAddressList(Map<String, String> addressList) {
		this.addressList = addressList;
	}
}
