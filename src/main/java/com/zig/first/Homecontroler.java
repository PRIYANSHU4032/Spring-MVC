package com.zig.first;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zig.first.Model.Alien;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class Homecontroler {
	@Autowired
	AlienRepo repo;
	
	
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	/*@RequestMapping("add")
	public String add(HttpServletRequest req) {
		int n = Integer.parseInt(req.getParameter("num1"));
		int m = Integer.parseInt(req.getParameter("num2"));
		int sum = n+m;
		
		HttpSession session = req.getSession();
		session.setAttribute("sum", sum);
		return "result.jsp";
	}*/
	
	/*@RequestMapping("add")
		public ModelAndView add(@RequestParam("num1") int i,@RequestParam("num2") int j) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		int sum = i+j;
		mv.addObject("sum",sum);
		return mv;
		
	}*/
	@ModelAttribute
	public void addName(Model m) {
		m.addAttribute("name","Priyanshu");
	}
	@RequestMapping("add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j ,Model m) {
		int sum = i+j;
		m.addAttribute("sum",sum);
		return "result";
	}
	//@RequestMapping(value= "addAlien", method=RequestMethod.POST)
	/*@PostMapping("addAlien")
	public String addAlien(@ModelAttribute("geeek") Alien a) {
		
		
		
		return "result";
	}*/
	/*@GetMapping("getAlien")
	public String getAlien(Model m) {
		List<Alien> aliens = Arrays.asList(new Alien(105,"subham"),new Alien(106,"arti"));
		m.addAttribute("result",aliens);
		
		return "showaliens";
	}*/
	
	@GetMapping("getAlien")
	public String getAlien(Model m) {
		m.addAttribute("result", repo.findAll());
		
		return"showaliens";
	}
	
	@GetMapping("getoneAlien")
	public String getoneAlien(@RequestParam("aid") String i,Model m) {
		m.addAttribute("result", repo.getOne(i));
		
		return"showaliens";
	}
	
	@PostMapping("addAlien")
	public String addAlien(@ModelAttribute("result") Alien a) {
		repo.save(a);
		
		
		return "showaliens";
	}
	
	
	@RequestMapping("removeAlien")
	public String removeAlien(@RequestParam("aid") String i) {
		repo.deleteById(i);
		
		return"showaliens";
	}
	
	/*@GetMapping("getAlienName")
	public String getAlienbyName(@RequestParam String aname,Model m) {
		List<Alien> aliens = repo.findByAnameOrderByAidDesc(aname);
		m.addAttribute("result",aliens );
		
		return"showaliens";
	}*/
	
	
	@GetMapping("getAlienName")
	public String getAlienbyName(@RequestParam String aname,Model m) {
		List<Alien> aliens = repo.find(aname);
		m.addAttribute("result",aliens );
		
		return"showaliens";
	}
	
	@RequestMapping("login")
	public String login(@RequestParam String aid, @RequestParam String aname, Model m) {
		if(repo.existsByAidAndAname(aid,aname)) {
			m.addAttribute("result", "success");
			return"showaliens";
		}else {
			m.addAttribute("result", "failed");
			return"showaliens";
		}
	}
	
	
	

}
