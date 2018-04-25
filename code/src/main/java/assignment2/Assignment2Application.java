package assignment2;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import assignment2.business.service.StudentService;
import assignment2.presentation.controller.MainController;
import assignment2.presentation.view.MainView;

@SpringBootApplication
public class Assignment2Application implements CommandLineRunner{
	@Autowired
	StudentService studentService;
	@Autowired
	MainView mainView;
	@Autowired
	MainController controller;
	public static void main(String[] args) {
		SpringApplication.run(Assignment2Application.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try {
			mainView.getFrame().setVisible(true);
			controller.setMainView(mainView);
		}catch(HibernateException exception){
		     System.out.println("main");
		     exception.printStackTrace();
		}
	}
}
