package interpeter;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

import common.model.UserInformation;

public class Checklogin implements Interceptor {

	public void intercept(Invocation inv) {
		Controller controller = inv.getController();
		UserInformation userInformation = controller.getSessionAttr("user");
		//判断登录条件是否成立
		if (null == userInformation) {
			//这里返回登录页面
			controller.render("../nologin.html");
		} else {
			inv.invoke();
		}
	}
}
