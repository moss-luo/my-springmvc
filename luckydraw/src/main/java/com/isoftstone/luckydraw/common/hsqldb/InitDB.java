package com.isoftstone.luckydraw.common.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class InitDB {
	private JdbcTemplate jdbcTemplate;
	
	public void execute() {
		createTables();
		initData();
		/**
		try {
			testSql();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		**/
	}

	private void initData() {
		
		String[] str= {"杨元朴","郭海洲","朱腾得","张海波","刘俊","王亚洲","唐祁斌","王涛","李凯","卢赛","雷燕军",
						"徐助乾","何志刚","余睿","周军芳","谭冲","童琼元","付媛","张幼林","李贵龙","刘沛奇","周明",
						"荣成武","董虎","杨腾","孙明","张曼丽","易蕾","李新文","郝自领","张阳","李俊（40679）","姚杰文",
						"蒋艳云","黄宏","孙青","江智慧","陈平","易定叶","郭亚","莫勇强","肖旋","胡志刚","黄斌",
						"张杰","吴岳辉","卜凡","曾媛媛","徐波","周瑾","朱磊","段华荣","刘青","蒋金石","黄梅",
						"林春","李侠影","吴亮亮","陈克红","李良春","龚亮","吕志祥","夏青云","杨文帅","张登科","阳小平",
						"刘军","郭祚文","白家迎","杨永康","陈军军","易辉","王忠川","扶芳梅","何欣","欧阳光明","徐红伟",
						"贺良荣","唐彪","刘永红","张启忠","童怿春","黄登辉","张静雅","王康","薛乐","黄磊","姜锐锋",
						"徐永","王辉","陈坤","谢树丹","王景林","朱娟","王珍","宋林","李璐","唐雄飞","张新宇",
						"卞志成","钟锐","谢伟群","唐云鄂","邓思思","乐辉","宋晓冬","郭志刚","夏职琴","吴媛","刘芳",
						"陶桃","尹媚","陈晓洁","刘美芳","张丽莉","王文卓","李建婵","王诗卉","朱焕国","罗凤","张凡",
						"王晓龙","刘晔","朱强","海欢","王意","龚涛","沈欢欢","张华生","李萌","李日旭","李春梅",
						"李上贵","陈小玲","邵福兴","敬洋","戴子彭","吕曦琳","王允","杨琛","张洪超","黄宇","杨莞武",
						"陈巍","胡晓龙","向伟","许晓华","王群","吴珊珊","李勇伯","唐小兰","易能华","杨飞","黄科源",
						"刘乐","李玉鑫","曾俊炜","毛远波","马泽洪","徐红艳","彭明","曾凡","唐永乐","杨明","黄明生",
						"徐剑","娄志东","张雷","雷铮","刘坤","霍永红","李广业","熊建权","王洋（23739）","曾宪益","曹倩倩",
						"陈佳益","李晓丽","徐秋容","梁叶","鲁文婷","王洋（39513）","温清廉","戴贞虹","曾金锦","伍晨","马潇",
						"易劲波","蒋勇","石冰鑫","黄贤光","黄光良","游永华","胡安明","郭容华","李盼盼","闫家玮","高文坚",
						"刘书妍","柏文","张黎","陈凯鹏","李青云","任宝军","庄坚发","杜丹","谷文田","张峰","李悦",
						"黄子靖","唐根","赵志飞","吴毅华","潘峰","何云华","张智","李少敏","翟锐","黄瑞东","罗挺",
						"蒲晓伟","刘舒杰","李红勤","彭胜容","杨井","曾鹏飞","李清","李俊（38729）","周继绪","陈俊涛","郑婷",
						"许瑞","许亮","练燕妮","宋洁","方静","许艳","巫建平","李涛","杨杰","刘虎成","付平",
						"黄政","龚海生","程飞虎","余泳","张文","郭玉壮","张忠国","钱远鹏","王浩","庄龙","刘文璟",
						"戴玲","黄振","熊杰","成清菊","方志锋","陈俊梅","郑晓晓","郁红玲","闫肃","朱振球","何威云",
						"潘柏宇","马雪娅","周秋阳","李焱","曾丹奇","梁家章","刘婷婷","刘多多","吴武钢","张洪武","谭军红",
						"刘克进","李勉","黄晓莉","朱玲","李进","周毅","谢艳丽","张月娇","黄玩娇","马琳","陈烈维",
						"唐波","王亚丽","魏志勇","蒋长春","唐黎","梁苑","黄敏"};
		
		for (int i = 0; i < str.length; i++) {
			jdbcTemplate.execute(String.format("insert into PERSONS(NAME,STATUS)values('%s',0)",str[i]));
		}

	}

	private void createTables() {
		jdbcTemplate.execute("CREATE TABLE PERSONS(id INTEGER IDENTITY PRIMARY KEY,name CHAR(25),status INTEGER DEFAULT 0)");
	}
	
	@Resource
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * 测试SQL
	private void testSql() throws Exception{
		 Class.forName("org.hsqldb.jdbcDriver");  
		 Connection conn2 = DriverManager.getConnection("jdbc:hsqldb:mem:luckydraw","sa","");  
        //查询数据  
        PreparedStatement pstmt = conn2.prepareStatement("SELECT * FROM persons");  
        ResultSet rs = pstmt.executeQuery();  
        while(rs.next()) {  
            String s = null;  
            s = rs.getString(1) + "," + rs.getString(2)+ "," + rs.getString(3);  
            System.out.println(s);  
        }  
        System.out.println("select data OK");  
	}
	 **/
}
