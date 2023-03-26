package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        printHeaders(req);
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("--- Headers - start ---");

        req.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": " + headerName));

        req.getHeader("host"); // 단일 조회
    }

    private void printHeaderUtils(HttpServletRequest req) {
        req.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
    }

}
