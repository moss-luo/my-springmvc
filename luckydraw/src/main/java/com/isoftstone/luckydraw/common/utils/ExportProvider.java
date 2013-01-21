package com.isoftstone.luckydraw.common.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


public class ExportProvider {
	private static final String TAG = ".csv";
	private static final String SIGN = ",";

	public static void export(List<String> list, String title,HttpServletResponse response)
			throws Exception {
		Date nowTime = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
		String num = time.format(nowTime);
		response.setHeader("Content-disposition", "attachment; filename="+num+TAG+"");
		response.setContentType("application/csv;charset=gb18030"); 
		OutputStreamWriter osw = new OutputStreamWriter(response.getOutputStream(), "gb18030"); 
		osw.write(title + "\r\n");   
		for (String i : list) {
			osw.write(i + "\r\n");
		}
		osw.flush();
		osw.close();
	}

	public static void export(File file,HttpServletResponse response) throws Exception {
		String conext = file.getAbsolutePath();
		String fileName = conext.substring(
				conext.lastIndexOf(File.separator) + 1, conext.length());
		response.setCharacterEncoding("utf-8");
		response.addHeader("content-type", "application/csv; charset=utf-8");
		response.setHeader("Content-disposition", "attachment; filename="+ fileName + "");
		OutputStream out = response.getOutputStream();
//		out.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));   
		FileInputStream in = new FileInputStream(file);
		 int i = -1;
		 while((i = in.read()) != -1){
		 out.write(i);
		 }
		 in.close();
		out.close();
		out.close();
	}

	public static String burdenDatum(String str) {
		return str;
	};

	public static String burdenDatum(String str1, String str2) {
		return str1 + SIGN + str2;
	}

	public static String burdenDatum(String str1, String str2, String str3) {
		return str1 + SIGN + str2 + SIGN + str3;
	}

	public static String burdenDatum(String str1, String str2, String str3, String str4) {
		return str1 + SIGN + str2 + SIGN + str3 + SIGN + str4;
	}

	public static String burdenDatum(String str1, String str2, String str3,
			String str4, String str5) {
		return str1 + SIGN + str2 + SIGN + str3 + SIGN + str4 + SIGN + str5;
	}
}

