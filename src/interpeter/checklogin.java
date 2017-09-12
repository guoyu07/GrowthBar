package interpeter;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class checklogin implements Interceptor {
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        String a=controller.getSessionAttr("user");
        //判断登录条件是否成立
        if(a==null){
            //这里返回登录页面
            controller.render("../nologin.html");
        }else{
            inv.invoke();
        }
    }
}
