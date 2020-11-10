package com.nakihome.zerochallenge.user;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.nakihome.zerochallenge.Const;
import com.nakihome.zerochallenge.ViewRef;

import com.nakihome.zerochallenge.api.NaverLoginBO;
import com.nakihome.zerochallenge.user.model.SnsUserVO;
import com.nakihome.zerochallenge.user.model.UserPARAM;

@Controller
@RequestMapping("/user")
public class UserController {

	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String n_apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	@Autowired
	private UserService service;

	/* GET */

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		
		/*카카오*/
	
		System.out.println("네이버:" + naverAuthUrl);

		model.addAttribute("naverUrl", naverAuthUrl);
		model.addAttribute(Const.TITLE, "로그인");
		model.addAttribute(Const.VIEW, "user/login");

		return ViewRef.TEMP_DEFAULT;
	}
	
	
	
	

	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException, ParseException {
		System.out.println("여기는 callback");
		
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
//1. 로그인 사용자 정보를 읽어온다.
		n_apiResult = naverLoginBO.getUserProfile(oauthToken); // String형식의 json데이터
		/**
		 * apiResult json 구조 {"resultcode":"00", "message":"success",
		 * "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		 **/
//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = null; 
		
		try { obj = parser.parse(n_apiResult); }
		catch (ParseException e) { e.printStackTrace(); }
		
		JSONObject jsonobj = (JSONObject) obj; 
		JSONObject response = (JSONObject) jsonobj.get("response");
		System.out.println("response : "+response);
				
		
		String nid=(String)response.get("id");
		String nname = (String) response.get("name"); 
		String nemail = (String) response.get("email"); 
		String nbirthday = (String) response.get("birthday");
		String nage = (String) response.get("age");
		
//3. 데이터를 snsuservo에 담음 
		
		UserPARAM param = new UserPARAM();
		param.setUser_id(nid);
		param.setUser_email(nemail);
		param.setUser_nm(nname);
		param.setAge(nage);
		param.setSubscription_path(Const.NAVER);
		
		int result = service.login(param);		
		System.out.println(result);
		if(Const.SUCCESS==result) {
			System.out.println("sns user 로그인");   
			model.addAttribute("sns_loginUser",param);
			return "test/questionReg";	
		}
		
		
		
		
		System.out.println("sns user 회원가입");		
		
		model.addAttribute("naverUser",param);
		model.addAttribute(Const.TITLE, "추가정보입력");
		model.addAttribute(Const.VIEW, "user/join");
		
		return ViewRef.TEMP_DEFAULT;
		
		 }
	
	
	



	@RequestMapping(value = "/join")
	public String join(Model model) {
	
		model.addAttribute(Const.TITLE, "회원가입");
		model.addAttribute(Const.VIEW, "user/join");

		return ViewRef.TEMP_DEFAULT;
	}
	
	/* POST */

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(SnsUserVO param, RedirectAttributes ra) {
		
		int result = service.join(param);
		if(result==Const.SUCCESS) {
			System.out.println("로그인");
			return "redirect:/user/login";
		}
		System.out.println("실패");
		ra.addFlashAttribute("err", result);
		return "user/join";
		
	}


}
