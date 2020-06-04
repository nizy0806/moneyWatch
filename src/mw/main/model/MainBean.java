package mw.main.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainBean {

	@RequestMapping("siteMap.mw")	
	public String siteMap() {
		return "/siteMap";
	}


	
}
