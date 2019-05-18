package webstore.interceptor;
/*
 * preHandle: This method gets called just before the web request reaches the controller method to be executed
 * postHandle: This method will get called just after the execution of the controller method
 * afterCompletion: This method will get called after the completion of the entire web request cycle
 *  
 * */


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class PerformanceMonitorInterceptor implements HandlerInterceptor {
	
	/*ThreadLocal and StopWatch add only for fallow total time of request*/
    ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
    Logger logger = Logger.getLogger(this.getClass());

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StopWatch stopWatch = new StopWatch(handler.toString());
        stopWatch.start(handler.toString());
        stopWatchLocal.set(stopWatch);

        logger.info("Accessing URL path: " + getURLPath(request));
        logger.info("Request processing started on: " + getCurrentTime());

        return true;
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("Request processing ended on " + getCurrentTime());
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
        StopWatch stopWatch = stopWatchLocal.get();
        
        /* retrieved stopwatch instance from ThreadLocal is immediately stopped; 
         * now, the stopwatch instance will have a record of the total time that was taken 
         * between the preHandle and afterCompletion methods, which is considered as the 
         * total time taken to complete a request.*/
        stopWatch.stop();

        logger.info("Total time taken for processing: " + stopWatch.getTotalTimeMillis() + " ms");
        stopWatchLocal.set(null);

        logger.info("===========================");
    }

    private String getURLPath(HttpServletRequest request) {
        String currentPath = request.getRequestURI();
        String queryString = request.getQueryString();
        queryString = queryString == null ? "" : "?" + queryString;
        return currentPath + queryString;
    }

    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }
}