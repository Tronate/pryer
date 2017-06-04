package cn.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import cn.domain.User;
import cn.domain.mainpage;
import cn.domain.netRecord;
import cn.domain.userInfo;
import cn.domain.zhangWu;
import cn.myparser.MyParser;
import cn.service.Userservice;
import cn.service.model;
import cn.utils.DES;
import cn.utils.VerifyUtils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

@SuppressWarnings("serial")
public class Simulogin extends HttpServlet {

	protected WebClient client;

	public Simulogin() {
		client = new WebClient(BrowserVersion.CHROME);
		// htmlunit 对css和javascript的支持不好，所以请关闭之
		client.getOptions().setJavaScriptEnabled(false);
		client.getOptions().setCssEnabled(false);
		client.getOptions().setTimeout(10000);
	}

	/**
	 * 登录
	 * 
	 * @param account
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private boolean login(String account, String password, HttpSession session) throws Exception {
		String verifyUrl = "http://210.47.160.36:8080/selfservice/common/web/verifycode.jsp"; // 验证码图片
		String judgeUrl = "http://210.47.160.36:8080/selfservice/module/scgroup/web/login_judge.jsf"; // 登录验证页面
		try {
			// 获取验证码图片并解析，与此同时，验证码图片对应的cookie会自动保存在client对象中
			InputStream stream = client.getPage(verifyUrl).getWebResponse()
					.getContentAsStream();
			BufferedImage bi = null;
			try {
				bi = ImageIO.read(stream); // 读取文件，生成对应的输入流
				// ImageIO.write(bi,"jpg",new File("C:/p1.jpg"));
				// 将字节写入文件
			} catch (Exception e) {
				e.printStackTrace();
			}
			String verifyCode = VerifyUtils.parserVerifyCodeImage(bi);
			// 通过POST请求，提交表单到验证登录的界面中
			URL url = new URL(judgeUrl);
			WebRequest webRequest = new WebRequest(url, HttpMethod.POST);
			List<NameValuePair> reqParam = new ArrayList<NameValuePair>();
			reqParam.add(new NameValuePair("act", "add"));
			reqParam.add(new NameValuePair("name", account));
			reqParam.add(new NameValuePair("password", password));
			reqParam.add(new NameValuePair("verify", verifyCode));
			// System.out.println(account+password+verifyCode);
			webRequest.setRequestParameters(reqParam);
			/**
			 * 这句代码坑了我无数次： 因为是模拟的客户端， 所以必须有这个提交表单并登录的过程， 即使返回的界面并没有变量接收 所以这句千万别删
			 * */
			client.getPage(webRequest);
			// 定义一个解析类的对象，解析四个页面，并将数据存入数据库
			MyParser parser = new MyParser();
			// 个人信息，包含了登录成功判断
			String personUrl = "http://210.47.160.36:8080/selfservice/module/userself/web/regpassuserinfo_login.jsf";
			HtmlPage personPage = client.getPage(personUrl);
			Document doc = Jsoup.parse(personPage.asXml());
			// System.out.println(doc);
			// 判断是否登录成功
			Elements elements = doc
					.getElementsByAttributeValue("action",
							"/selfservice/module/userself/web/regpassuserinfo_login.jsf");
			// 判断模拟登录用的用户名密码是否正确
			// System.out.println("elements"+elements.attr("id"));
			if (!elements.attr("id").equalsIgnoreCase("RegUserinfoForm")) {
				session.setAttribute("flag", false);
				return false;
			}
			session.setAttribute("flag", true);
			userInfo userinfo = parser.parserUserInfoPage(doc);
			//如果用户个人信息存在
			if (model.checkPersonPageExist(account, userinfo.getUserIPv4())) {
			} else {
				userInfo user = new userInfo();
				user.setAccount(userinfo.getAccount());
				user.setUsername(userinfo.getUsername());
				user.setPassword(userinfo.getPassword());
				user.setZjh(userinfo.getZjh());
				user.setSex(userinfo.getSex());
				user.setUserIPv4(userinfo.getUserIPv4());
				user.setConnway(userinfo.getConnway());
				user.setBalance(userinfo.getBalance());
				user.setStatus(userinfo.getStatus());
				user.setWithholding(userinfo.getWithholding());
				model userInfo = new model();
				userInfo.userInfo(user);
			}

			// 首页界面
			String mainUrl = "http://210.47.160.36:8080/selfservice/module/webcontent/web/content_self.jsf"; // 登录之后主界面
			HtmlPage mainPage = client.getPage(mainUrl);
			doc = Jsoup.parse(mainPage.asXml());
			mainpage main = parser.parserMainPage(doc);
			if (model.checkMainPageExist(account)) {
				if (!main.getPackageflow().equals(
						Userservice.findPackageflow(account))
						|| !main.getCycleTime().equals(
								Userservice.findCycleTime(account))) {
					Userservice.updateMainPage(account, main.getStatus(),
							main.getAccountway(), main.getCycleTime(),
							main.getBalance(), main.getPackageflow(),
							main.getWithhold());
				}
			} else {
				mainpage main1 = new mainpage();
				main1.setAccount(account);
				main1.setStatus(main.getStatus());
				main1.setAccountway(main.getAccountway());
				main1.setCycleTime(main.getCycleTime());
				main1.setBalance(main.getBalance());
				main1.setPackageflow(main.getPackageflow());
				main1.setWithhold(main.getWithhold());
				model userInfo = new model();
				userInfo.addMainpage(main1);
			}

			// 上网记录界面
			String recordUrl = "http://210.47.160.36:8080/selfservice/module/onlineuserself/web/onlinedetailself_list.jsf";
			HtmlPage recordPage = client.getPage(recordUrl);
			doc = Jsoup.parse(recordPage.asXml());
			ArrayList<netRecord> records = parser.parserRecordPage(doc);
			for (int i = 0; i < records.size(); i++) {
				netRecord record = records.get(i);
				if (model.checkRecordPageExist(account, record.getOntime())) {
				} else {
					netRecord record1 = new netRecord();
					record1.setAccount(account);
					record1.setOntime(record.getOntime());
					record1.setOfftime(record.getOfftime());
					record1.setUserIPv4(record.getUserIPv4());
					record1.setService(record.getService());
					record1.setOffreason(record.getOffreason());
					record1.setOncost(record.getOncost());
					model Record = new model();
					Record.addRecordpage(record1);
				}
			}

			// 账务流水界面
			String zhangwuUrl = "http://210.47.160.36:8080/selfservice/module/billself/web/accountflowself_list.jsf";
			HtmlPage zhangwuPage = client.getPage(zhangwuUrl);
			doc = Jsoup.parse(zhangwuPage.asXml());
			ArrayList<zhangWu> zhangWus = parser.parserZhangwuPage(doc);
			for (int i = 0; i < zhangWus.size(); i++) {
				zhangWu zhangwu = zhangWus.get(i);
				if (model.checkZhangwuPageExist(account,
						zhangwu.getGeneratedtime())) {
				} else {
					zhangWu zhangwu1 = new zhangWu();
					zhangwu1.setUsername(zhangwu.getUsername());
					zhangwu1.setAccount(zhangwu.getAccount());
					zhangwu1.setBillsource(zhangwu.getBillsource());
					zhangwu1.setFee(zhangwu.getFee());
					zhangwu1.setNowbalance(zhangwu.getNowbalance());
					zhangwu1.setNowwithhold(zhangwu.getNowwithhold());
					zhangwu1.setGeneratedtime(zhangwu.getGeneratedtime());
					zhangwu1.setBusinessvolume(zhangwu.getBusinessvolume());
					zhangwu1.setWithholdrole(zhangwu.getWithholdrole());
					model Zhangwu = new model();
					Zhangwu.addZhangWupage(zhangwu1);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		long begin = System.currentTimeMillis();
		// 获取前端传递的账号密码用来抓取数据
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		// 判断是否登录如果尚未登录则跳转到首页
		if (account != null && password != null) {
			try {
				HttpSession session = request.getSession();
//				boolean flag = login(account, password);
				if (login(account, password, session)) {// 判断模拟登陆是否成功
					// 将新的密码账号存储在session
					session.setAttribute("account", account);
					model userService = new model();
					// 加密密码
					String key = "3hxcgsrt3sxhs4zg"; // 秘钥
					DES des = new DES();
					password = des.authcode(password, "ENCODE", key);
					// System.out.println(password);
					// System.out.println(des.authcode(password, "DECODE",
					// key));
					// 判断账号是否在数据库里面，不存在则保存用户的账号密码
					if (userService.checkAccountExist(account)) {
						// 判断密码是否发生变化
						if (!password.equals(userService.findPassword(account))) {
							// 密码发生变化说明用户修改过密码
							userService.updatePassword(account, password);
							// System.out.println("密码修改完成！");
						}
					} else {
						User user = new User();
						user.setAccount(account);
						user.setPassword(password);
						userService.addUser(user);
					}
				} else {
					request.getRequestDispatcher("index.html").forward(request,
							response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			long end =System.currentTimeMillis();
			long total = end-begin;
			
			System.out.println("total time ="+total);
		} else {
			request.getRequestDispatcher("index.html").forward(request,
					response);
		}
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
