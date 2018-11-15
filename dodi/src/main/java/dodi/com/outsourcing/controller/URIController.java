package dodi.com.outsourcing.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class URIController {

	@RequestMapping(value= {"/site/**","/pms/**"})
	public String goPage(HttpServletRequest hreq) {
		String url = hreq.getRequestURL().toString().replaceAll("http://localhost/", "").toString();
		String rootPath = hreq.getContextPath();
		String path = hreq.getRequestURI();
		log.info(url);
		log.info(path);
		log.info(rootPath);
		return url;
	}
}
