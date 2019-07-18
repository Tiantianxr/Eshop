package com.zy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zy.bean.Good;
import com.zy.dao.GoodDao;

public class GoodService {
	
	private GoodDao goodDao=new GoodDao();
	
	public int addCart(String good_id,int good_number) {
		int result=0;
		
		//处理购物车商品数量的累加
		Good good = goodDao.queryCartGood(good_id);
		if(good!=null) {//原有购物车有该商品，数量累加，修改原有记录
			good_number+=good.getNumber();
			result=goodDao.updateCart(good_id, good_number);
		}else {//原有购物车没有该商品，直接添加记录
			result=goodDao.addCart(good_id, good_number);
		}
		return result;
	}
	
	public Map<String, Object> queryCartGoods(){
		List<Good> goods = goodDao.queryCartGoods();
		double sumPrice=0;
		for(Good good:goods) {
			sumPrice+=good.getSum();
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("goods", goods);
		map.put("sumPrice", sumPrice);
		
		return map;
	}
}
