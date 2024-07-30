package com.jsp.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.ProductDao;
import com.jsp.foodapp.entities.FoodOrder;
import com.jsp.foodapp.entities.Item;
import com.jsp.foodapp.entities.Product;

@Controller
public class ItemController {

	@Autowired
	ProductDao dao;

	@RequestMapping("/additem")
	public ModelAndView addItem(HttpSession session, @RequestParam("id") int id) {
		if (session.getAttribute("itemsList") == null) {
			session.setAttribute("itemsList", new ArrayList<Item>());
		}

		ModelAndView mav = new ModelAndView("itemform");
		Product p = dao.viewProductById(id);
		Item item = new Item();
		item.setName(p.getName());
		item.setCost(p.getCost());
		item.setType(p.getType());
		mav.addObject("itemobj", item);

		return mav;
	}

	@RequestMapping("/additemtofoodorder")
	public ModelAndView additems(@ModelAttribute("itemobj") Item item, HttpSession session) {
		item.setCost(item.getCost() * item.getQuantity());
		
		FoodOrder order = (FoodOrder) session.getAttribute("userfoodorder");
		item.setFoodorder(order);

		List<Item> items = (List<Item>) session.getAttribute("itemsList");
        items.add(item) ;
        
        ModelAndView mav = new ModelAndView("redirect:/viewallproduct") ;
        return mav ;
	}

}
