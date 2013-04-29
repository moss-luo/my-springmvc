package com.ittbank.restful.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ittbank.restful.util.TemplateResult;
import com.ittbank.restful.vo.Phone;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	
	Phone phone1 = new Phone(0,"motorola-xoom-with-wi-fi","resources/img/phones/motorola-xoom-with-wi-fi.0.jpg",
			"Motorola XOOM\u2122 with Wi-Fi","The Next, Next Generation\r\n\r\nExperience the future with Motorola XOOM with Wi-Fi,"+
			"the worlds first tablet powered by Android 3.0 (Honeycomb,test for query).","Motorola XOOM with Wi-Fi has a super-powerful " +
					"dual-core processor and Android\u2122 3.0 (Honeycomb) \u2014 the Android platform designed specifically for tablets. " +
					"With its 10.1-inch HD widescreen display, you\u2019ll enjoy HD video in a thin, light, powerful and upgradeable tablet.");
	
	
	Phone phone2 = new Phone(1,"motorola-xoom","resources/img/phones/motorola-xoom.0.jpg","MOTOROLA XOOM\u2122",
			"The Next, Next Generation\n\nExperience the future with MOTOROLA XOOM," +
			"the worlds first tablet powered by Android 3.0 (Honeycomb).","MOTOROLA XOOM has a super-powerful dual-core processor and Android");

	@RequestMapping("/phones")
	public List<Phone> phones(){
		
		List<Phone> result = new ArrayList<Phone>();
		result.add(phone1);
		result.add(phone2);
		return result;
	}
	
	@RequestMapping("/{phoneId}")
	public TemplateResult phoneDetail(@PathVariable String phoneId,@RequestParam("name") String name){
		TemplateResult tr = new TemplateResult();
		List<String> images = new ArrayList<String>();
		
		if(phoneId.equals(phone1.getId())){
			images.add("resources/img/phones/motorola-xoom-with-wi-fi.0.jpg"); 
			images.add("resources/img/phones/motorola-xoom-with-wi-fi.1.jpg"); 
			images.add("resources/img/phones/motorola-xoom-with-wi-fi.2.jpg"); 
			images.add("resources/img/phones/motorola-xoom-with-wi-fi.3.jpg"); 
			images.add("resources/img/phones/motorola-xoom-with-wi-fi.4.jpg"); 
			images.add("resources/img/phones/motorola-xoom-with-wi-fi.5.jpg");
			phone1.setImages(images);
			tr.setModel(phone1);
		}else if(phoneId.equals(phone2.getId())){
			images.add("resources/img/phones/motorola-xoom.0.jpg");
			images.add("resources/img/phones/motorola-xoom.1.jpg");
			images.add("resources/img/phones/motorola-xoom.2.jpg");
			phone2.setImages(images);
			tr.setModel(phone2);
		}else{
			tr.setHttpStatus(HttpStatus.SC_NOT_FOUND);
		}
		
		return tr;
	}
}
