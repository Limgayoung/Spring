package hello.servlet;

		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //서블릿 자동 등록
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

	//이 밑에 일을 application.properties에서 스프링이 다 해줌.
//	@Bean
//	InternalResourceViewResolver internalResourceViewResolver(){
//		return new InternalResourceViewResolver("/WEB-INF/views", ".jsp");
//	}
}

