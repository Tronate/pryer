package cn.myparser;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.domain.mainpage;
import cn.domain.netRecord;
import cn.domain.userInfo;
import cn.domain.zhangWu;

public class MyParser {
	/**
	 * 解析首页
	 */
	public mainpage parserMainPage(Document doc) {
		mainpage main = new mainpage();
		/**
		 * getElementsByAttributeValue：
		 * 通过属性值获得元素
		 * tr：行 td：列，一个行中包含多个列 解析HTML代码：class:一个标签，名称:ff1bjq
		 * 获得多个内容，因为包含多个ff1bjq标签
		 * */
		Elements elements = doc.getElementsByAttributeValue("class", "ff1bjq");
		/*equalsIgnoreCase:
		 * 将此 String 与另一个 String 比较，不考虑大小写。
		 * 如果两个字符串的长度相同，并且其中的相应字符都相等（忽略大小写），
		 * 则认为这两个字符串是相等的。
		 * Elements接口的实现类的get()方法：
		 * 返回list中参数位置的指定元素
		 * text()方法：
		 * 将元素以String类型返回：(只获得其中的文本内容/将HTML表示格式转换为文字
		 * */
		if (elements.get(0).text().equalsIgnoreCase("正常")) {
			//抓取首页的“周期时间范围行”，账户余额为零时
			if (elements.get(2).text().equalsIgnoreCase("新周期未开通")) {
				//设置用户状态：正常
				main.setStatus(elements.get(0).text());
				//设置计费策略为抓取的计费策略
				main.setAccountway(elements.get(1).text());
				//设置周期时间范围为抓取的周期时间范围：此时为"新周期未开通"
				main.setCycleTime(elements.get(2).text());
				/*以ff1bjy标签抓取内容
				 * 抓取内容为：余额
				 * */
				Elements elements4 = doc.getElementsByAttributeValue("class",
						"ff1bjy");
				main.setBalance(elements4.get(1).text());
				//设置“套餐流量（已用量/总免费量）”
				main.setPackageflow("  ");// 新周期未开,账户余额为0
				//设置“待扣款余额”
				main.setWithhold(elements.get(6).text());
			}
			//如果为新周期未开通就***（以上内容），否则***（还有流量）（以下内容）
			else {
				//str内容
				String str = elements.get(5).text();
//				System.out.println(str);
//				String str1 = str.substring(5);
//				System.out.println(str);
				//以“/”为分隔符将
				String[] flow = str.split("/");
				if (!flow[0].trim().equals(flow[1].trim())) {
					Elements elements3 = doc.getElementsByAttributeValue(
							"class", "ff1bjq");
					main.setStatus(elements3.get(0).text());
					main.setAccountway(elements3.get(1).text());
					main.setCycleTime(elements3.get(2).text());
					Elements elements4 = doc.getElementsByAttributeValue(
							"class", "ff1bjy");
					main.setBalance(elements4.get(1).text());
					Elements elements5 = doc.getElementsByAttributeValue(
							"class", "ff1bjq");
					main.setPackageflow(elements5.get(5).text());
					main.setWithhold("0.00 元");
				} else {
					Elements elements3 = doc.getElementsByAttributeValue(
							"class", "ff1bjq");
					main.setStatus(elements3.get(0).text());
					main.setAccountway(elements3.get(1).text());
					main.setCycleTime(elements3.get(2).text());
					main.setPackageflow(elements3.get(5).text());
					Elements elements4 = doc.getElementsByAttributeValue(
							"class", "ff1bjy");
					main.setBalance(elements4.get(1).text());
					main.setWithhold(elements3.get(9).text());
				}
			}
		} else {
			Elements elements3 = doc.getElementsByAttributeValue("class",
					"ff1bjq");
			main.setStatus(elements3.get(0).text());
			main.setAccountway(elements3.get(1).text());
			main.setCycleTime(elements3.get(2).text());
			Elements elements4 = doc.getElementsByAttributeValue("class",
					"ff1bjy");
			main.setBalance(elements4.get(1).text());
//			main.setWithhold("0.00 元");
			main.setWithhold(elements3.get(9).text());
		}
		return main;
	}

	/**
	 * 解析上网记录
	 */
	public ArrayList<netRecord> parserRecordPage(Document doc1) {
		ArrayList<netRecord> records = new ArrayList<netRecord>();
		Document doc = Jsoup.parse(doc1.toString());
		List<Element> aEles = doc.getElementsByAttributeValue("class", "odd");
		for (Element temp2 : aEles) {
			netRecord record = new netRecord();// /位置非常关键，一定要在for
												// 循环里，否则添加的数据永远会被最后一条替换
			Elements elements3 = temp2.getElementsByTag("td");
			record.setOntime(elements3.get(0).text());// 封装courseId
			record.setOfftime(elements3.get(1).text());
			record.setUserIPv4(elements3.get(2).text());
			record.setService(elements3.get(4).text());
			record.setOffreason(elements3.get(5).text());
			Element links = doc.select("a[href]").last();
			record.setOncost(links.text());
			records.add(record);
		}
		List<Element> aEles1 = doc.getElementsByAttributeValue("class", "even");
		for (Element temp2 : aEles1) {
			netRecord record = new netRecord();
			Elements elements3 = temp2.getElementsByTag("td");
			record.setOntime(elements3.get(0).text());
			record.setOfftime(elements3.get(1).text());
			record.setUserIPv4(elements3.get(2).text());
			record.setService(elements3.get(4).text());
			record.setOffreason(elements3.get(5).text());
			Element links = doc.select("a[href]").last();
			record.setOncost(links.text());
			records.add(record);
		}
		return records;

	}

	/**
	 * 解析账务流水
	 */
	public ArrayList<zhangWu> parserZhangwuPage(Document doc1) {
		ArrayList<zhangWu> zhangwus = new ArrayList<zhangWu>();
		Document doc = Jsoup.parse(doc1.toString());
		List<Element> aEles = doc.getElementsByAttributeValue("class", "odd");
		for (Element temp2 : aEles) {
			zhangWu zhangwu = new zhangWu();
			Elements elements3 = temp2.getElementsByTag("td");
			zhangwu.setUsername(elements3.get(0).text());
			zhangwu.setAccount(elements3.get(1).text());
			zhangwu.setBillsource(elements3.get(2).text());
			zhangwu.setFee(elements3.get(3).text());
			zhangwu.setNowbalance(elements3.get(4).text());
			zhangwu.setNowwithhold(elements3.get(5).text());
			zhangwu.setGeneratedtime(elements3.get(6).text());
			zhangwu.setBusinessvolume(elements3.get(7).text());
			zhangwu.setWithholdrole(elements3.get(8).text());
			zhangwus.add(zhangwu);
		}

		List<Element> aEles1 = doc.getElementsByAttributeValue("class", "even");
		for (Element temp2 : aEles1) {
			zhangWu zhangwu = new zhangWu();
			Elements elements3 = temp2.getElementsByTag("td");
			zhangwu.setUsername(elements3.get(0).text());
			zhangwu.setAccount(elements3.get(1).text());
			zhangwu.setBillsource(elements3.get(2).text());
			zhangwu.setFee(elements3.get(3).text());
			zhangwu.setNowbalance(elements3.get(4).text());
			zhangwu.setNowwithhold(elements3.get(5).text());
			zhangwu.setGeneratedtime(elements3.get(6).text());
			zhangwu.setBusinessvolume(elements3.get(7).text());
			zhangwu.setWithholdrole(elements3.get(8).text());
			zhangwus.add(zhangwu);
		}
		return zhangwus;
	}

	/*
	 * 自助账务
	 */
/*	public selfBill parserSelfBill(Document doc1) {
		Document doc = Jsoup.parse(doc1.toString());
		selfBill selfbill = new selfBill();
		Elements elements3 = doc.getElementsByAttributeValue("class", "ff1bjq");
		selfbill.setUsername(elements3.get(0).text());
		selfbill.setStatus(elements3.get(1).text());
		selfbill.setBillway(elements3.get(2).text());
		selfbill.setPeriod(elements3.get(3).text());
		Elements elements4 = doc.getElementsByAttributeValue("class", "ff1bjy");
		selfbill.setBalance(elements4.get(1).text());
		selfbill.setWithhold(elements3.get(4).text());
		selfbill.setPackageflow(elements3.get(5).text());
		selfbill.setBeginbalance(elements3.get(6).text());
		selfbill.setNowbalance(elements3.get(7).text());
		selfbill.setEnterbill(elements3.get(8).text());
		selfbill.setOutbill(elements3.get(12).text());
		selfbill.setUsedflow(elements3.get(21).text());
		selfbill.setUsableflow(elements3.get(29).text());
		selfbill.setRoledescribe(elements3.get(30).text());
		String a = elements3.get(32).text();
		String b = a.substring(9);
		selfbill.setOffsetexplain(b);
		return selfbill;
	}*/
	/**
	 * 解析个人信息
	 */
	public userInfo parserUserInfoPage(Document doc1) {
		Document doc = Jsoup.parse(doc1.toString());
		Elements elements3 = doc.getElementsByAttributeValue("width", "32%");
		userInfo info = new userInfo();
		info.setAccount(elements3.get(0).text());
		info.setUsername(elements3.get(1).text());
		info.setPassword("********");
		info.setSex(elements3.get(2).text());
		info.setZjh(elements3.get(5).text());
		info.setBalance(elements3.get(22).text());
		info.setWithholding(elements3.get(23).text());
		info.setStatus(elements3.get(24).text());
		Elements elements = doc.getElementsByAttributeValue("class", "whiteBg");
		info.setUserIPv4(elements.get(2).text().substring(0, elements.get(2).text().indexOf("Web")));
		info.setConnway("Web纯准出接入");
		return info;
	}
}
