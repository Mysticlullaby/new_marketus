package store.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import store.dao.StoreDao;
import store.dto.StoreDto;

@Controller
public class StoreController {

	private StoreDao storeDao;

	public StoreController() {
	}

	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
	}

	@RequestMapping(value = "/store_info.do") // 어떤 주소를 넣으면 컨트롤러가 작동되는지
	public String storeExecute() {
		return "store_info"; // tiles에 정의된 definition의 이름
	}

	@RequestMapping(value="/searchad.do" , method=RequestMethod.GET) 
	@ResponseBody
	public List<StoreDto> storeSearch(String data){
	  
	 System.out.printf("%s \n", data);	  
	 
	 List<StoreDto> store_area_List = storeDao.sido(data);
	 return store_area_List;
	}

}// end Controller