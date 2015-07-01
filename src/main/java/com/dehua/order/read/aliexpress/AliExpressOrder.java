package com.dehua.order.read.aliexpress;

import java.util.List;

import com.dehua.order.model.Logistics;
import com.dehua.order.model.Order;
import com.dehua.order.model.OrderProduct;
import com.dehua.order.model.User;

public class AliExpressOrder extends Order{
	
	public User orderPerson; //负责人	
	public User buyer; //买家
	public String email; //买家邮箱
	public long orderTime; //下单时间
	public long payTime;//付款时间
	public double amountOfProduct;//产品金额
	public double buyerOrderLogisticsCost; //买家付的订单运费
	public double amountOfOrder;//订单金额
	public double fullMinus;//满立减
	public List<OrderProduct> orderProducts;//产品信息
	public String orderNotes;//订单备注
	public String deliveryAddress;//收货地址
	public String receiverName;//收货人名称
	public String receiverCountry;//收货国家
	public String receiverProvince;//收货州/省
	public String receiveCity;//收货城市
	public String address;//地址
	public String zipCode;//邮编
	public String phone;//联系电话
	public String mobilePhone;//手机
	public Logistics logistics;//买家选择的物流
	public long deliverLimitTime; //发货期限 
	public long deliverTime;//发货时间
	public long confirmDeliveryTime;//确认收货时间
	
}


