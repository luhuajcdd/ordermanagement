package com.dehua.order.model.pojo;

public class WayBillNumber {

	public long deliveryId;//快递单号
	public long orderId;
	public Logistics logistics;//发货方式
	public int weight;//重量(g)
	public Currency currency;//币种
	public int declardValue;//申报价值
	public int number;//件数
	public Product product;//中文名，英文名，多品名
	public String notes;//备注
	public String hscode;//商品海关编码
	
}
