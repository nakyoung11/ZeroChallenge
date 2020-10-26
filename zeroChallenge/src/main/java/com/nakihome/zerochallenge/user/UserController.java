package com.nakihome.zerochallenge.user;

import java.io.IOException;

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

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.nakihome.zerochallenge.Const;
import com.nakihome.zerochallenge.ViewRef;
import com.nakihome.zerochallenge.api.NaverLoginBO;
import com.nakihome.zerochallenge.test.model.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

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
		System.out.println("네이버:" + naverAuthUrl);
//네이버
		model.addAttribute("url", naverAuthUrl);

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
		apiResult = naverLoginBO.getUserProfile(oauthToken); // String형식의 json데이터
		/**
		 * apiResult json 구조 {"resultcode":"00", "message":"success",
		 * "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		 **/
//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = null; 
		
		try { obj = parser.parse(apiResult); }
		catch (ParseException e) { e.printStackTrace(); }
		
		JSONObject jsonobj = (JSONObject) obj; 
		JSONObject response = (JSONObject) jsonobj.get("response");
		System.out.println("response : "+response);
		String nid=(String)response.get("id");
		String nname = (String) response.get("name"); 
		String nemail = (String) response.get("email"); 
		String ngender = (String) response.get("gender"); 
		String nbirthday = (String) response.get("birthday");
		String nimage = (String) response.get("profile_image");
		System.out.println(nname);                  
		
		if(1==service.snsLogin(nid)) {
			model.addAttribute("name", nname);
			model.addAttribute("email", nemail);
			model.addAttribute("id", nid );
			model.addAttribute(Const.VIEW, "test/questionReg");

			return ViewRef.TEMP_DEFAULT;
		}
		
		
		
		model.addAttribute("name", nname);
		model.addAttribute("email", nemail);
		model.addAttribute("id", nid );
		System.out.println(nname);
		System.out.println(nemail);
		

		model.addAttribute(Const.TITLE, "추가정보입력");
		model.addAttribute(Const.VIEW, "user/join");

		return ViewRef.TEMP_DEFAULT;
		
		 }// end naverLogin()


		// 로그인&아웃 하기위한 세션값 주기 	session.setAttribute("nname", nname);session.setAttribute("nemail", nemail); session.setAttribute("ngender", ngender); session.setAttribute("nbirthday", nbirthday); session.setAttribute("nage", nage); session.setAttribute("nimage", nimage); // 네이버 로그인 성공 페이지 View 호출 mav.setViewName("main"); return mav; }// end naverLogin()

	@RequestMapping(value = "/join")
	public String join(Model model) {

		model.addAttribute(Const.TITLE, "회원가입");
		model.addAttribute(Const.VIEW, "user/join");

		return ViewRef.TEMP_DEFAULT;
	}
	
	/* POST */

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO param) {
		int result = service.join(param);

		return "";
	}

	
	@RequestMapping(value = "/snsjoin", method = RequestMethod.POST)
	public String snsJoin(UserVO param) {
		int result = service.join(param);

		return "";
	}
}
