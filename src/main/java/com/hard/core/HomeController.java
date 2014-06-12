package com.hard.core;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private MessagePrinter printer;


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/kam", method = RequestMethod.GET)
	public String kam(Locale locale, Model model, @RequestParam("name") String name) {
		logger.info("Welcome to kam! The client locale is {}.", locale);
		
		hibernate();
		model.addAttribute("name", printer.printMessage() + name);
		
		return "kam";
	}
	
	public void hibernate()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Message p1 = new Message();
        p1.setFirstName("kam");
        p1.setLastName("rb");
        p1.setAge(25);
        long personId = (Long) session.save(p1);
        session.getTransaction().commit();
        
        Message person = (Message) session.get(Message.class, personId);        
        System.out.println(person);
                
        session.close();
	}
	
	
    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }
    
    
	public MessagePrinter getPrinter() {
		return printer;
	}

	@Autowired
	public void setPrinter(MessagePrinter printer) {
		this.printer = printer;
	}
}
