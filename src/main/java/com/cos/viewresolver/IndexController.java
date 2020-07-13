package com.cos.viewresolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller // IOC
public class IndexController {
	
	
	
	
	
	@GetMapping({"","/"})
	public String index(Model model) {
		String name = "cos";
		model.addAttribute("ttt", name);
		int num = 10;
		String password = "1234";
		model.addAttribute("num", num);
		model.addAttribute("password", "1234");

		// => /viewresolver/src/main/resources/templates/index.mustache
		// viewresolver의 역할 : return하는 것은 파일, prefix와 surfix를 붙여준다. return에 index만 써도 알아서 붙여준다는 뜻
		// 원래 requestDispatcher를 써서 데이터를 보냈는데 스프링에서는 클래스로 Model 이라는것을 만들어놨음
		// Model model  함수안에 파라미터를 적기만하면 DI해줌..  
		
		return "index";
	}
	
	
	
	
	
	@GetMapping("/model")
	public String modelData(Model model){ // DI하기
		Member member = Member.builder()
			.id(1)
			.username("Lee")
			.phone("01022224567")
			.build();
		
		model.addAttribute("member", member);
		
	
		return "modelData";
	}
	
	
	
	
	
	@GetMapping("/model/data")
	public String modelArray(Model model){ // DI하기
		Member member1 = Member.builder()
			.id(1)
			.username("sasar")
			.phone("01022223333")
			.build();
		
		Member member2 = Member.builder()
				.id(2)
				.username("cos")
				.phone("01022223333")
				.build();
		
		
		List<Member> members = new ArrayList<>();
		members.add(member1);
		members.add(member2);
		model.addAttribute("members", members);
		model.addAttribute("user", true);
		return "modelArray";
	}
	
	
	
	
	
	@GetMapping("/layout")
	public String layout() {
		
		return "layout";
	}
	
	
	
	
	
}
