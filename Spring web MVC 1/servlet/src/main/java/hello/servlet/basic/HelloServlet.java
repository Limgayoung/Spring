package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") ///hello가 오면 실행됨
//서블릿 이름과 url 패턴은 겹치면 안됨
public class HelloServlet extends HttpServlet {

    @Override //Ctrl+O 한 후 service 치고 열쇠 클릭
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");

        //여러가지 was 서버들이 servlet 표준 스펙을 구현하는 것
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username"); //쿼리 파라미터(?)를 쉽게 읽어올 수 있음
        System.out.println("username = " + username);

        //헤더 정보에 들어감
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8"); //왠만하면 utf-8 을 써야 함
        response.getWriter().write("hello " + username);
    }
}
