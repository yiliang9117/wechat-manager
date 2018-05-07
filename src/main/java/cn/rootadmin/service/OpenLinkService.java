package cn.rootadmin.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import cn.rootadmin.pojo.OpenLink;
import cn.rootadmin.utils.HttpGet;

@Service
public class OpenLinkService extends BaseService<OpenLink> {




	public String getTicketFromWeGameByTopicId(String wxGameTopicId) {
		String wxGameUrl = "https://game.weixin.qq.com/cgi-bin/comm/openlink?noticeid=90070127&appid=wx58164a91f1821369&url=https%3a%2f%2fgame.weixin.qq.com%2fcgi-bin%2fh5%2fstatic%2fcommunity%2fclub_detail.html%3fappid%3dwx95a3a4d7c627e0xx%26topic_id%3d"
				+ wxGameTopicId
				+ "%26key%3d7dc869ac8a00de992f27241f3346bb9bfc948223e63523e60f3c4fb27f190e9cd44b53168bb3e8b76ab961e687a7fc698ec8f07a1c159b522eec9d3e6cc652c97a5bf34813855e27f55cad1ce0728783%26uin%3dMzMxOTMwNTgzNQ%253D%253D%26abtest_cookie%3dAwABAAoADAANAAgAZIgeANWIHgDhiB4A%252FIgeALOJHgD4iR4AGYoeAEyKHgAAAA%253D%253D%26pass_ticket%3dZv88n7fo%252Bw%252By0AlUMhzpKr7nhgDjC63IzRX4opH%252B9t8gTnA5WINVHxQ%252BEWTicx3Iwechat_redirect";

		HttpGet httpGet = new HttpGet();
		String doGetHtml = httpGet.doGet(wxGameUrl);
		Matcher m = Pattern.compile("ket=(.*?)#").matcher(doGetHtml);
		while (m.find()) {
			String wxUrl = m.group(1);
			return wxUrl;
		}
		return getTicketFromWeGameByTopicId(wxGameTopicId);

	}


	

}
