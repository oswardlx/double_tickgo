package interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.log.Log;
import com.jfinal.log.Log4jLogFactory;
public class ExceptionIntoLogInterceptor implements Interceptor {
    private  Log4jLogFactory log4jLogFactory = new Log4jLogFactory();

    @Override
    public void intercept(Invocation inv) {
        Log log = log4jLogFactory.getLog(ExceptionIntoLogInterceptor.class);
//        log.debug();
    }
}
