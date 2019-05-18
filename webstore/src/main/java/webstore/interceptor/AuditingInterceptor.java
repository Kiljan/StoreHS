package webstore.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuditingInterceptor extends HandlerInterceptorAdapter {
    Logger logger = Logger.getLogger("AuditLogger");
    private String user;
    private String productName;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object handler) throws Exception {
        if(request.getRequestURI().endsWith("products/add") && request.getMethod().equals("POST")) {
            
        	user = request.getRemoteUser();
            /* request.getParameterValues can have several values, therefore it is a list. 
             * We are only interested in the first value found ==> [0]*/
            productName = request.getParameterValues("name")[0];
        }
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3) throws Exception {
        if(request.getRequestURI().endsWith("products/add") && response.getStatus() == 302) {
            logger.info(String.format("A new product[%s] Added by %s on %s", productName, user, getCurrentTime()));
        }
    }

    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy ' at ' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        return formatter.format(calendar.getTime());
    }

}
