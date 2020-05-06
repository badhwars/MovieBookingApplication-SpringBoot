package com.prog39599.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prog39599.beans.Account;
import com.prog39599.beans.Booking;
import com.prog39599.beans.Customer;
import com.prog39599.beans.Movie;
import com.prog39599.beans.Payment;
import com.prog39599.beans.User;
import com.prog39599.repositories.AccountRepository;
import com.prog39599.repositories.BookingRepository;
import com.prog39599.repositories.CustomerRepository;
import com.prog39599.repositories.MovieRepository;
import com.prog39599.repositories.PaymentRepository;
import com.prog39599.repositories.RolesRepository;
import com.prog39599.repositories.UserRepository;

import lombok.AllArgsConstructor;




@Controller
@AllArgsConstructor
public class HomeController  {
	
	private CustomerRepository customerRepository;
	private RolesRepository roleRepository;
	private UserRepository userRepository;
	private MovieRepository movieRepository;
	private BookingRepository bookingRepository;
	private PaymentRepository paymentRepository;
	private AccountRepository accountRepository;
	

	
	@GetMapping("/")
	public String index(Model model) {
		
	//	movieRepository.save(movie1);
		model.addAttribute("movieList",movieRepository.findAll());
		//model.addAttribute("movie",new Movie());
		model.addAttribute("bookingList",bookingRepository.findAll());
		model.addAttribute("booking",new Booking());
		model.addAttribute("payment",new Payment());
		model.addAttribute("paymentList",paymentRepository.findAll());
		model.addAttribute("tuesday","false");
		//model.addAttribute("Mo", new User());
		
		return "index";
	}
	
	//boolean isTuesday = false;
	@PostMapping("/booking")
	public String createMovie(Model model, @ModelAttribute Booking booking) {
	
	
	bookingRepository.save(booking);
	
	if(booking.getDay().equalsIgnoreCase("Tuesday")) {
		model.addAttribute("price",5);
	//	isTuesday =true;
//		model.addAttribute("tuesday","true");
	}
	else {
//		model.addAttribute("tuesday","false");
	}
	if(booking !=null) {
		System.out.println(booking.getMovie());
		//movieName = booking.getMovie();
	}
	
	
	
	if(booking.getMovie().contains("18")) {
		model.addAttribute("rating","adult");
	}
	else {
		model.addAttribute("rating","normal");
	}
	//model.addAttribute("movieGenre",());
	
	//bookingInfo = booking;
	return "booking";
		
		
		}
	
	@PostMapping("/booking1")
	public String createMovie1(Model model, @ModelAttribute Booking booking) {
	
	
	bookingRepository.save(booking);
	
	if(booking.getDay().equalsIgnoreCase("Tuesday")) {
		model.addAttribute("price",5);
	//	isTuesday =true;
//		model.addAttribute("tuesday","true");
	}
	else {
//		model.addAttribute("tuesday","false");
	}
	if(booking !=null) {
		System.out.println(booking.getMovie());
		//movieName = booking.getMovie();
	}
	
	
	
	if(booking.getMovie().contains("18")) {
		model.addAttribute("rating","adult");
	}
	else {
		model.addAttribute("rating","normal");
	}
	//model.addAttribute("movieGenre",());
	
	//bookingInfo = booking;
	return "user/booking";
		
		
		}
	
	@PostMapping("/paid")
	public String payment(Model model, @ModelAttribute Payment payment ) {
		paymentRepository.save(payment);
		System.out.println("paymenh"+payment.getGeneralTickets());
		System.out.println("paymenh"+payment.getSeniorTickets());
		System.out.println("paymenh"+payment.getChildTickets());

		String day = bookingRepository.findFirstByOrderByIdDesc().getDay();
		System.out.print("Day"  +day);
		
		if(day.equalsIgnoreCase("Tuesday")) {
			model.addAttribute("total",payment.total(true));
		}
		
		else {
			model.addAttribute("total","$ "+payment.total(false));
			
		}

		
		return "paid";
	}
	
	@PostMapping("/paid1")
	public String payment1(Model model, @ModelAttribute Payment payment ) {
		paymentRepository.save(payment);
		System.out.println("paymenh"+payment.getGeneralTickets());
		System.out.println("paymenh"+payment.getSeniorTickets());
		System.out.println("paymenh"+payment.getChildTickets());
		//System.out.println(cTickets);
		String day = bookingRepository.findFirstByOrderByIdDesc().getDay();
		System.out.print("Day"  +day);
		
		
		if(day.equalsIgnoreCase("Tuesday")) {
			model.addAttribute("total",payment.total(true));
			double total = payment.total(true);
			double discount = 0.2 * total;
			double DTotal = total - discount;
			model.addAttribute("Dtotal",DTotal);
			System.out.println("Dtoa" + DTotal);
		}
		
		else {
			model.addAttribute("total","$ "+payment.total(false));
			double total = payment.total(false);
			double discount = 0.2 * total;
			double DTotal = total - discount;
			model.addAttribute("Dtotal",DTotal);
		}

		
		return "user/paid";
	}
	@GetMapping("/guestCheckout")
	public String guestCheckout() {
		
		
		return "guestCheckout";
	}
	
	@PostMapping("/accountCreated")
	public String accountCreated(Model model, @ModelAttribute Account account) {
		accountRepository.save(account);
		
		model.addAttribute("name",account.getName());
		
		
		return "accountCheckOut";
		
		
	
	}
	@PostMapping("/accountCheckout")
	public String accountCheckout(Model model) {
		//String name = auth.getName();
		Booking booking = bookingRepository.findFirstByOrderByIdDesc();
		model.addAttribute("movie",": "+booking.getMovie());
		model.addAttribute("time",": "+booking.getTime());
		model.addAttribute("name",": name");
		model.addAttribute("day",": "+booking.getDay());
		Payment payment = paymentRepository.findFirstByOrderByPaymentIdDesc();
		model.addAttribute("genTickets" ,": "+payment.getGeneralTickets());
		model.addAttribute("seniorTickets",": "+ payment.getSeniorTickets());
		model.addAttribute("childTickets",": "+payment.getChildTickets());
		
		return "user/checkout";
	
	}

	@GetMapping("/createAccount1")
	public String createAccount() {
		
		
		return "createAccount1";
		
		
	
	}

	
	
@PostMapping("/sendEmail")
public String thankYou(Model model, @RequestParam String name){
	Booking booking = bookingRepository.findFirstByOrderByIdDesc();
	model.addAttribute("movie",": "+booking.getMovie());
	model.addAttribute("time",": "+booking.getTime());
	model.addAttribute("name",": "+name);
	model.addAttribute("day",": "+booking.getDay());
	Payment payment = paymentRepository.findFirstByOrderByPaymentIdDesc();
	model.addAttribute("genTickets" ,": "+payment.getGeneralTickets());
	model.addAttribute("seniorTickets",": "+ payment.getSeniorTickets());
	model.addAttribute("childTickets",": "+payment.getChildTickets());
	return "thankyou";
}
	@GetMapping("/login")
	public String login() {
		return "login";
		
	}
	@GetMapping("/user")
		public String userIndex(Model model, Authentication auth) {
		String name = auth.getName();
		List<String> roles = new ArrayList<String>();
		for(GrantedAuthority ga: auth.getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		
		model.addAttribute("movieList",movieRepository.findAll());
		//model.addAttribute("movie",new Movie());
		model.addAttribute("bookingList",bookingRepository.findAll());
		model.addAttribute("booking",new Booking());
		model.addAttribute("payment",new Payment());
		model.addAttribute("paymentList",paymentRepository.findAll());
		model.addAttribute("tuesday","false");
		//model.addAttribute("Mo", new User());
		
		
		model.addAttribute("name",name);
		model.addAttribute("roles",roles);
		
	return "user/index";
	}
	@GetMapping("/admin")
	public String adminIndex(Model model, Authentication auth) {
	String name = auth.getName();
	List<String> roles = new ArrayList<String>();
	for(GrantedAuthority ga: auth.getAuthorities()) {
		roles.add(ga.getAuthority());
	}
	
	model.addAttribute("users",userRepository.findAll());
	//model.addAttribute("movie",new Movie());

	//model.addAttribute("Mo", new User());
	
	
	model.addAttribute("bookings",bookingRepository.findAll());

	
return "admin/index";
}
	


	
	@GetMapping("/register")
	public String goRegisteration(){
		return "register";
		
	}
	
	
	@PostMapping("/createAdminMovie")
	public String createMovie(){
		
		
		return "admin/createAdminMovie";
		
	}
	@PostMapping("/adminCreateMovieEntry")
	public String createMovieEntry(Model model, @ModelAttribute Movie movie){
		model.addAttribute("users",userRepository.findAll());
		//model.addAttribute("movie",new Movie());

		//model.addAttribute("Mo", new User());
		
		
		model.addAttribute("bookings",bookingRepository.findAll());
		movieRepository.save(movie);
		return "admin/index";
		
	}
	
	
	@PostMapping("/register")
	public String doRegisteration(@RequestParam String username, @RequestParam String password) {
		User user = new User(username, encodePassword(password), Byte.valueOf("1"));
		user.getRoles().add(roleRepository.findByRolename("ROLE_USER"));
		userRepository.save(user);
		return "redirect:/";
	}
	
	@PostMapping("/deleteMovie")
	public String deleteMovie(Model model) {
		model.addAttribute("movieList",movieRepository.findAll());
		return "admin/deleteMovie";
	}
	@Transactional
	@PostMapping("/deleteMovieEntry")
	public String deleteMovieEntry(@RequestParam String moviename, Model model) {
		System.out.println(moviename);
        movieRepository.deleteByName(moviename);
    	model.addAttribute("users",userRepository.findAll());
    	//model.addAttribute("movie",new Movie());

    	//model.addAttribute("Mo", new User());
    	
    	
    	model.addAttribute("bookings",bookingRepository.findAll());
		return "admin/index";
	}
	
//	@PostMapping("/register")
//	public String doRegisteration(@RequestParam String username, @RequestParam String password){
//		
//	
//	User user = new User(username, encodePassword(password), Byte.valueOf("1"));
//	user.getRoles().add(rolesRepository.findByRolename("ROLE_User"));
//	userRepository.save(user);
//	
//		return "redirect:/";
//	}
	private String encodePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	
	
}
