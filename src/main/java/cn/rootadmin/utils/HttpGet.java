package cn.rootadmin.utils;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 * 模拟http请求
 *
 */
public class HttpGet {
	
	
	
	
	public String doGet(String url) {
		
		try {

            URL u = new URL(url);
            HttpURLConnection con = (HttpURLConnection) u.openConnection();
            InputStream in = con.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len = 0 ;
            while((len = in.read(buf)) != -1){
                baos.write(buf,0,len);
            }
            in.close();
            baos.close();
            String pageStr = new String(baos.toByteArray());
            
            
            //这里返回的就是真个页面html
            return pageStr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	

	
	 /**
    * post方式请求数据
    * @param url 请求链接
    * @param data post数据体
    * @return
    */
   public  String doPost(String url, Map<String,String> data){
   	
   	
   	  CloseableHttpClient httpClient = HttpClientBuilder.create().build();
       StringBuffer sb = new StringBuffer();
       HttpPost httpPost = new HttpPost(url);
       List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
       if(null != data) {
           for (String key : data.keySet()) {
               valuePairs.add(new BasicNameValuePair(key, data.get(key)));
           }
       }
       try {
           httpPost.setEntity(new UrlEncodedFormEntity(valuePairs));
           HttpResponse response = httpClient.execute(httpPost);
           HttpEntity httpEntity = response.getEntity();
           BufferedInputStream bis = new BufferedInputStream(httpEntity.getContent());
           byte [] buffer;
           while (0<bis.read(buffer=new byte[128])){
               sb.append(new String(buffer,"gbk"));
           }
       }catch (UnsupportedEncodingException e){//数据格式有误
           e.printStackTrace();
       }catch (IOException e){//请求出错
           e.printStackTrace();
       }finally {
           httpPost.releaseConnection();
       }
       return sb.toString();
   }
	
	
	
}
