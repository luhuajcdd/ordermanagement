package com.dehua.order.read.aliexpress;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.dehua.order.constants.StringConstants.LogisticsCon;
import com.dehua.order.constants.StringConstants.OrderStatusCon;
import com.dehua.order.constants.StringConstants.ProductCon;
import com.dehua.order.model.Logistics;
import com.dehua.order.model.OrderProduct;
import com.dehua.order.model.OrderStatus;
import com.dehua.order.model.User;
import com.dehua.order.model.UserType;
import com.dehua.order.read.ExcelRead;
import com.dehua.util.TimeUtil;

public class AliExpressExcelRead extends ExcelRead<AliExpressOrder> {

	@Override
	public AliExpressOrder get(Row row) {
		AliExpressOrder ae = new AliExpressOrder();

		if (row instanceof HSSFRow) {
			HSSFRow hssfRow = (HSSFRow) row;

			HSSFCell orderNumber = hssfRow.getCell(0);
			HSSFCell orderStatus = hssfRow.getCell(1);
			HSSFCell orderPerson = hssfRow.getCell(2);
			HSSFCell buyerName = hssfRow.getCell(3);
			HSSFCell email = hssfRow.getCell(4);
			HSSFCell orderTime = hssfRow.getCell(5);
			HSSFCell payTime = hssfRow.getCell(6);
			HSSFCell amountOfProduct = hssfRow.getCell(7);
			HSSFCell buyerOrderLogisticsCost = hssfRow.getCell(8);
			HSSFCell amountOfOrder = hssfRow.getCell(9);
			HSSFCell fullMinus = hssfRow.getCell(10);
			HSSFCell productInfo = hssfRow.getCell(11);
			HSSFCell orderNotes = hssfRow.getCell(12);
			HSSFCell deliveryAddress = hssfRow.getCell(13);
			HSSFCell receiverName = hssfRow.getCell(14);
			HSSFCell receiverCountry = hssfRow.getCell(15);
			HSSFCell receiverProvince = hssfRow.getCell(16);
			HSSFCell receiveCity = hssfRow.getCell(17);
			HSSFCell address = hssfRow.getCell(18);
			HSSFCell zipCode = hssfRow.getCell(19);
			HSSFCell phone = hssfRow.getCell(20);
			HSSFCell mobilePhone = hssfRow.getCell(21);
			HSSFCell logistics = hssfRow.getCell(22);
			HSSFCell deliverLimitTime = hssfRow.getCell(23);
			HSSFCell deliverTime = hssfRow.getCell(25);
			HSSFCell confirmDeliveryTime = hssfRow.getCell(26);

			try {
				ae.orderId = getLongValue(orderNumber);
				String status = getStringValue(orderStatus);
				ae.status = getOrderStatus(status);
				String orderPersonStr = getStringValue(orderPerson);
				User userOrderPerson = new User();
				userOrderPerson.name = orderPersonStr;
				userOrderPerson.type = UserType.ORDER_PERSON;
				ae.orderPerson = userOrderPerson;
				String buyerNameStr = getStringValue(buyerName);
				User userBuyer = new User();
				userBuyer.name = buyerNameStr;
				userBuyer.type = UserType.BUYER;
				ae.buyer = userBuyer;
				ae.email = getStringValue(email);
				String ordTime = getStringValue(orderTime);
				ae.orderTime = TimeUtil
						.stringToLong(ordTime, TimeUtil.FORMAT_1);
				String pTime = getStringValue(payTime);
				ae.payTime = TimeUtil
						.stringToLong(pTime, TimeUtil.FORMAT_1);
				ae.amountOfProduct = getIntValue(amountOfProduct);
				ae.buyerOrderLogisticsCost = getIntValue(buyerOrderLogisticsCost);
				ae.amountOfOrder = getIntValue(amountOfOrder);
				ae.fullMinus = getIntValue(fullMinus);
				String orderProductInfo = getStringValue(productInfo);
				List<OrderProduct> ops = getOrderProduct(orderProductInfo);
				ae.orderProducts = ops;
				ae.orderNotes = getStringValue(orderNotes);
				ae.deliveryAddress = getStringValue(deliveryAddress);
				ae.receiverName = getStringValue(receiverName);
				ae.receiverCountry = getStringValue(receiverCountry);
				ae.receiverProvince = getStringValue(receiverProvince);
				ae.receiveCity = getStringValue(receiveCity);
				ae.address = getStringValue(address);
				ae.zipCode = getStringValue(zipCode);
				ae.phone = getStringValue(phone);
				ae.mobilePhone = getStringValue(mobilePhone);
				ae.logistics = getLogistics(getStringValue(logistics));
				String dLTime = getStringValue(deliverLimitTime);
				ae.deliverLimitTime = TimeUtil.stringToLong(dLTime, TimeUtil.FORMAT_2);
				String dTime = getStringValue(deliverTime);
				ae.deliverTime = TimeUtil.stringToLong(dTime, TimeUtil.FORMAT_2);
				String cDTime = getStringValue(confirmDeliveryTime);
				ae.confirmDeliveryTime = TimeUtil.stringToLong(cDTime, TimeUtil.FORMAT_2);

				userBuyer.email = ae.email;
				userBuyer.phone = ae.phone;
				userBuyer.mobilePhone = ae.mobilePhone;
				userBuyer.zipCode = ae.zipCode;
				userBuyer.receiverCountry = ae.receiverCountry;
				userBuyer.receiverProvince = ae.receiverProvince;
				userBuyer.receiveCity = ae.receiveCity;
				userBuyer.address = ae.address;
			} catch (ParseException e) {
				Logger.getGlobal().log(Level.WARNING, null, e);
			}
		} else if (row instanceof XSSFRow) {
			XSSFRow hssfRow = (XSSFRow) row;

			XSSFCell orderNumber = hssfRow.getCell(0);
			XSSFCell orderStatus = hssfRow.getCell(1);
			XSSFCell orderPerson = hssfRow.getCell(2);
			XSSFCell buyerName = hssfRow.getCell(3);
			XSSFCell email = hssfRow.getCell(4);
			XSSFCell orderTime = hssfRow.getCell(5);
			XSSFCell payTime = hssfRow.getCell(6);
			XSSFCell amountOfProduct = hssfRow.getCell(7);
			XSSFCell buyerOrderLogisticsCost = hssfRow.getCell(8);
			XSSFCell amountOfOrder = hssfRow.getCell(9);
			XSSFCell fullMinus = hssfRow.getCell(10);
			XSSFCell productInfo = hssfRow.getCell(11);
			XSSFCell orderNotes = hssfRow.getCell(12);
			XSSFCell deliveryAddress = hssfRow.getCell(13);
			XSSFCell receiverName = hssfRow.getCell(14);
			XSSFCell receiverCountry = hssfRow.getCell(15);
			XSSFCell receiverProvince = hssfRow.getCell(16);
			XSSFCell receiveCity = hssfRow.getCell(17);
			XSSFCell address = hssfRow.getCell(18);
			XSSFCell zipCode = hssfRow.getCell(19);
			XSSFCell phone = hssfRow.getCell(20);
			XSSFCell mobilePhone = hssfRow.getCell(21);
			XSSFCell logistics = hssfRow.getCell(22);
			XSSFCell deliverLimitTime = hssfRow.getCell(23);
			XSSFCell deliverTime = hssfRow.getCell(25);
			XSSFCell confirmDeliveryTime = hssfRow.getCell(26);

			try {
				ae.orderId = getLongValue(orderNumber);
				String status = getStringValue(orderStatus);
				ae.status = getOrderStatus(status);
				String orderPersonStr = getStringValue(orderPerson);
				User userOrderPerson = new User();
				userOrderPerson.name = orderPersonStr;
				userOrderPerson.type = UserType.ORDER_PERSON;
				ae.orderPerson = userOrderPerson;
				String buyerNameStr = getStringValue(buyerName);
				User userBuyer = new User();
				userBuyer.name = buyerNameStr;
				userBuyer.type = UserType.BUYER;
				ae.buyer = userBuyer;
				ae.email = getStringValue(email);
				String ordTime = getStringValue(orderTime);
				ae.orderTime = TimeUtil
						.stringToLong(ordTime, TimeUtil.FORMAT_1);
				String pTime = getStringValue(payTime);
				ae.payTime = TimeUtil
						.stringToLong(pTime, TimeUtil.FORMAT_1);
				ae.amountOfProduct = getIntValue(amountOfProduct);
				ae.amountOfProduct = getIntValue(amountOfProduct);
				ae.buyerOrderLogisticsCost = getIntValue(buyerOrderLogisticsCost);
				ae.amountOfOrder = getIntValue(amountOfOrder);
				ae.fullMinus = getIntValue(fullMinus);
				String orderProductInfo = getStringValue(productInfo);
				List<OrderProduct> ops = getOrderProduct(orderProductInfo);
				ae.orderProducts = ops;
				ae.orderNotes = getStringValue(orderNotes);
				ae.deliveryAddress = getStringValue(deliveryAddress);
				ae.receiverName = getStringValue(receiverName);
				ae.receiverCountry = getStringValue(receiverCountry);
				ae.receiverProvince = getStringValue(receiverProvince);
				ae.receiveCity = getStringValue(receiveCity);
				ae.address = getStringValue(address);
				ae.zipCode = getStringValue(zipCode);
				ae.phone = getStringValue(phone);
				ae.mobilePhone = getStringValue(mobilePhone);
				ae.logistics = getLogistics(getStringValue(logistics));
				String dLTime = getStringValue(deliverLimitTime);
				ae.deliverLimitTime = TimeUtil.stringToLong(dLTime, TimeUtil.FORMAT_2);
				String dTime = getStringValue(deliverTime);
				ae.deliverTime = TimeUtil.stringToLong(dTime, TimeUtil.FORMAT_2);
				String cDTime = getStringValue(confirmDeliveryTime);
				ae.confirmDeliveryTime = TimeUtil.stringToLong(cDTime, TimeUtil.FORMAT_2);

				userBuyer.email = ae.email;
				userBuyer.phone = ae.phone;
				userBuyer.mobilePhone = ae.mobilePhone;
				userBuyer.zipCode = ae.zipCode;
				userBuyer.receiverCountry = ae.receiverCountry;
				userBuyer.receiverProvince = ae.receiverProvince;
				userBuyer.receiveCity = ae.receiveCity;
				userBuyer.address = ae.address;
			} catch (ParseException e) {
				Logger.getGlobal().log(Level.WARNING, null, e);
			}
		}

		return ae;
	}

	private Logistics getLogistics(String stringValue) {

		if (stringValue == null) {
			return null;
		} else if (stringValue.equals(LogisticsCon.ePacket)) {
			return Logistics.ePacket;
		} else if (stringValue.equals(LogisticsCon.HongKong_Post_Air_Mail)) {
			return Logistics.HongKong_Post_Air_Mail;
		} else if (stringValue
				.equals(LogisticsCon.China_Post_Registered_Air_Mail)) {
			return Logistics.China_Post_Registered_Air_Mail;
		}
		return null;
	}

	private List<OrderProduct> getOrderProduct(String orderProductInfo) {

		List<OrderProduct> opList = new ArrayList<>();
		String[] subArr = orderProductInfo.split("【[0-9]{1,}】");
		for (String sub : subArr) {
			if (sub == null || "".equals(sub)) {
				continue;
			}
			OrderProduct op = getProduct(sub);
			if (op == null) {
				Logger.getGlobal().log(Level.WARNING, "product info is null");
				continue;
			}
			opList.add(op);
		}

		return opList;
	}

	private OrderProduct getProduct(String sub) {
		if (sub == null || "".equals(sub)) {
			return null;
		}
		OrderProduct op = new OrderProduct();
		String[] infos = sub.split("[(]");
		for (String info : infos) {
			if (info == null || "".equals(info)) {
				continue;
			}
			info = info.replace(")", "");
			if (info.contains(ProductCon.Property)) {
				op.property = info.replace(ProductCon.Property, "");
			} else if (info.contains(ProductCon.count)) {
				// 替换所有的非数字字符
				op.count = Integer.parseInt(info.replaceAll("\\D", ""));
			} else {
				op.detail = info;
			}
		}
		return op;
	}

	private OrderStatus getOrderStatus(String status) {
		if (status.equalsIgnoreCase(OrderStatusCon.wait_to_delivery)) {
			return OrderStatus.WAIT_TO_DELIVER;
		}
		return null;
	}

}
