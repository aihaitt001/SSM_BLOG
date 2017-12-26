package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springmvc.model.Reporte;

@Controller
public class ContactController {
	@ResponseBody
	@RequestMapping("/report")
	public String report(@RequestBody Reporte reporte) {
		String msg = "成功";

		return msg;
	}
}
