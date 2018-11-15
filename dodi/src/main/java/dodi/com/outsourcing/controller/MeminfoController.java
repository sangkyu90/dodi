package dodi.com.outsourcing.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import dodi.com.outsourcing.service.MeminfoService;
import dodi.com.outsourcing.vo.MemberInfo;

@Slf4j
@Controller
public class MeminfoController {
	//login,logout,join,find id-pwd
	@Autowired
	private MeminfoService ss;
	
	@ResponseBody
	@RequestMapping(value="/sign", method=RequestMethod.POST) //LOGIN
	public Integer selectSignIn(@RequestBody MemberInfo memInfo,HttpSession session) {
		//login
		int suc = ss.loginGet(memInfo);
		if(suc==1) {
			if(session.getAttribute("id")==null) {//세션에 id저장값이 널일 경우만
				session.setAttribute("id", memInfo.getMemberid());
				return suc;
			}
			suc = -2; //이미 로그인된 상태일 때
		}
		return suc;
	}
	
	@ResponseBody
	@RequestMapping(value="/sign", method=RequestMethod.GET)//LOGOUT
	public Integer selectSignIn(HttpSession session) {
		//logout
		int cnt =-1;
		if(session!=null) {
			session.removeAttribute("id");
			cnt=1;
		}
		return cnt;
	}
	
	@ResponseBody
	@RequestMapping(value="/signup", method=RequestMethod.POST) //JOIN
	public Integer selectSignUp(@RequestBody MemberInfo memInfo) {
		return ss.join(memInfo);
	}
	

	
}
