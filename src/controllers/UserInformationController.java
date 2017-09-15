package controllers;

import com.jfinal.core.Controller;

import common.model.UserInformation;

import org.eclipse.jetty.server.Authentication;

import services.UserInformationServices;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class UserInformationController extends Controller implements BaseController {

	private UserInformationServices userInformationServices = new UserInformationServices();

	public void Userlogin() {
		String user_account = getPara("user_id");
		String user_password = getPara("user_password");
		List<UserInformation> userInformationList = userInformationServices
				.find(user_account, user_password);
		if (isEmptyList(userInformationList))
			render("../loginfail.html");
		else {
			HttpSession session = getSession();
			UserInformation userInformation = userInformationList.get(ZERO_INT);
			userInformation.setUserPassword(null);
			session.setAttribute("user", userInformation);
			session.setMaxInactiveInterval(60);
			render("../loginsuccess.html");
		}
	}

	public void storeuser() {
		boolean saveSuccess = false;
		String userAccount = getPara("user_account");
		String userPassword = getPara("user_password");
		String userTrueName = getPara("user_truename");
		String userPhone = getPara("user_phone");
		String userSex = getPara("user_sex");
		String userDescription = getPara("user_description");
		UserInformation userInformation = new UserInformation();
		userInformation.setUserAccount(userAccount);
		userInformation.setUserPassword(userPassword);
		userInformation.setUserTruename(userTrueName);
		userInformation.setUserPhone(userPhone);
		userInformation.setUserSex(userSex);
		userInformation.setUserDescription(userDescription);
		userInformation.setUserStatus(VALID_USER);
		saveSuccess = userInformationServices.save(userInformation);
		setAttr("status", saveSuccess);
		setAttr("user", userInformation);
		renderJson();
	}

	protected void createValidate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		HttpSession session = request.getSession();
		int width = 60;
		int height = 20;
		//设置浏览器不要缓存此图片
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		//创建内存图像并获得图形上下文
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		/*
				*  * 产生随机验证码
          * 定义验证码的字符表
          */
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] rands = new char[4];
		for (int i = 0; i < 4; i++) {
			int rand = (int) (Math.random() * 36);
			rands[i] = chars.charAt(rand);
		}
			  /*
        * 产生图像
          * 画背景
         */
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, width, height);
              /*
        * 随机产生120个干扰点
         */
		for (int i = 0; i < 120; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			g.setColor(new Color(red, green, blue));
			g.drawOval(x, y, 1, 0);
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
		//在不同高度输出验证码的不同字符
		g.drawString("" + rands[0], 1, 17);
		g.drawString("" + rands[1], 16, 15);
		g.drawString("" + rands[2], 31, 18);
		g.drawString("" + rands[3], 46, 16);
		g.dispose();
		//将图像传到客户端
		ServletOutputStream sos = response.getOutputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "JPEG", baos);
		byte[] buffer = baos.toByteArray();
		response.setContentLength(buffer.length);
		sos.write(buffer);
		baos.close();
		sos.close();
		session.setAttribute("checkcode", new String(rands));
	}

	private void checkCode(HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		String info = null;
        /*获取输入的值*/
		String value1 = request.getParameter("name");
         /*获取图片的值*/
		HttpSession session = request.getSession();
		String value2 = (String) session.getAttribute("checkcode");
        /*对比两个值（字母不区分大小写）*/
		if (value2.equalsIgnoreCase(value1)) {
			info = "验证码输入正确";
		} else {
			info = "验证码输入错误";
		}
		System.out.println(info);
		request.setAttribute("info", info);
	}
}


