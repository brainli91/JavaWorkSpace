package com.fdmgroup.ranking;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mcavallo.opencloud.Cloud;
import org.mcavallo.opencloud.Tag;

public class ResumeRank {

	private Map<String, List<String>> keywordDependencies;
	private List<String> excludedTags;
	private List<Keyword> keywords;
	private File resumePath;
	private String content;
	
	public ResumeRank() {
		initExcludedTags();
		initKeywordDependencies();
	}
	
	public ResumeRank(List<Keyword> keywords, String content) {
		super();
		this.keywords = keywords;
		this.content = content;
		initExcludedTags();
		initKeywordDependencies();
	}
	
	public ResumeRank(List<Keyword> keywords, File resumePath) {
		super();
		this.keywords = keywords;
		this.resumePath = resumePath;
		initExcludedTags();
		initKeywordDependencies();
		content = readFile();
	}

	public List<Keyword> getKeywords() {
		return keywords;
	}
	
	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}
	
	public File getResumePath() {
		return resumePath;
	}

	public void setResumePath(File resumePath) {
		this.resumePath = resumePath;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float rankResumeByPercent(){
		float rank = 0.0f;
		if (content != null && !content.equals("")){
			content = modifyContent(content);
			Cloud cloud = new Cloud();
			cloud.setMaxTagsToDisplay(-1);
			cloud.addText(content);
			calculateWeights(cloud);
			rank = calcRankPercent();
		}
		
		return rank;
	}
	
	public float rankResume(){
		float rank = 0.0f;
		if (content != null && !content.equals("")){
			content = modifyContent(content);
			Cloud cloud = new Cloud();
			cloud.setMaxTagsToDisplay(-1);
			cloud.addText(content);
			calculateWeights(cloud);
			rank = calcRank();
		}
		
		return rank;
	}

	private String readFile() {
		ResumeFileReader rfr = ResumeFileReader.getInstance();
		
		if (resumePath.getAbsolutePath().endsWith("pdf"))
			return rfr.readPDF(resumePath.getAbsolutePath());
		else if (resumePath.getAbsolutePath().endsWith("doc"))
			return rfr.readDoc(resumePath.getAbsolutePath());
		else if (resumePath.getAbsolutePath().endsWith("docx"))
			return rfr.readDocx(resumePath.getAbsolutePath());
		else if (resumePath.getAbsolutePath().endsWith("txt"))
			return rfr.readTXT(resumePath.getAbsolutePath());
		else
			return null;
	}
	
	private void calculateWeights(Cloud cloud){
		List<Tag> tags = cloud.tags();
		tags = trimTags(tags);
		double min = cloud.getMinWeight();
		double max = cloud.getMaxWeight();
		normalizeTags(tags, min, max);
		for (Tag tag : tags) {
			for (Keyword keyword : keywords) {
				if (keyword.getName().equalsIgnoreCase(tag.getName())){
					keyword.setWeight(tag.getWeight());
					System.out.println(keyword);
				}
			}
		}
	}
	
	private List<Tag> trimTags(List<Tag> tags) {
		List<Tag> newTags = new ArrayList<>();
		for (Tag tag : tags) {
			if (!excludedTags.contains(tag.getName())){
				newTags.add(tag);
			}
		}
		
		return newTags;
	}
	
	private void normalizeTags(List<Tag> tags, double min, double max) {
		for (Tag tag : tags) {
			double newWeight = (tag.getWeight() - min) / (max - min); 
			tag.setWeight(newWeight);
		}
	}
	
	private float calcRankPercent() {
		float sum = 0.0f;
		for (Keyword keyword : keywords) {
			sum += keyword.getWeight();
		}
		
		return (sum / keywords.size()) * 100;
	}
	
	private float calcRank() {
		float sum = 0.0f;
		for (Keyword keyword : keywords) {
			sum += keyword.getWeight();
		}
		
		return ((sum / keywords.size()) * 10) / 2;
	}
	
	private String modifyContent(String content) {
		Set<String> keys = keywordDependencies.keySet();
		
		for (String key : keys) {
			List<String> listOfWords = keywordDependencies.get(key);
			for (String word : listOfWords) {
				content = content.replaceAll(word, key);
			}
		}
		
		return content;
	}
	
	private void initExcludedTags() {
		excludedTags = new ArrayList<>();
		excludedTags.add("as");
		excludedTags.add("also");
		excludedTags.add("at");
		excludedTags.add("among");
		excludedTags.add("around");
		excludedTags.add("and");
		excludedTags.add("for");
		excludedTags.add("to");
		excludedTags.add("from");
		excludedTags.add("on");
		excludedTags.add("onto");
		excludedTags.add("in");
		excludedTags.add("or");
		excludedTags.add("of");
		excludedTags.add("off");
		excludedTags.add("with");
		excludedTags.add("within");
		excludedTags.add("without");
		excludedTags.add("which");
		excludedTags.add("via");
		excludedTags.add("versus");
		excludedTags.add("up");
		excludedTags.add("down");
		excludedTags.add("toward");
		excludedTags.add("towards");
		excludedTags.add("through");
		excludedTags.add("that");
		excludedTags.add("this");
		excludedTags.add("into");
		excludedTags.add("over");
		excludedTags.add("since");
		excludedTags.add("than");
		excludedTags.add("more");
		excludedTags.add("until");
		excludedTags.add("upon");
		excludedTags.add("by");
		excludedTags.add("but");
		excludedTags.add("during");
		excludedTags.add("the");
		excludedTags.add("a");
		excludedTags.add("no");
		excludedTags.add("&");
	}
	
	private void initKeywordDependencies() {
		keywordDependencies = new Hashtable<>();
		
		List<String> javaList = new ArrayList<>();
		List<String> sqlList = new ArrayList<>();
		List<String> unixList = new ArrayList<>();
		List<String> appsuportList = new ArrayList<>();
		
		javaList.add("JavaEE");
		javaList.add("J2EE");
		javaList.add("JEE");
		javaList.add("Maven");
		javaList.add("Tomcat");
		javaList.add("Spring");
		javaList.add("Servlet");
		javaList.add("JSP");
		javaList.add("JPA");
		javaList.add("JDBC");
		javaList.add("Hibernate");
		javaList.add("EJB");
		javaList.add("JSF");
		javaList.add("Struts");
		javaList.add("log4j");
		javaList.add("JNDI");
		javaList.add("RMI");
		javaList.add("SOAP");
		javaList.add("SVN");
		javaList.add("GIT");
		javaList.add("Ant");
		javaList.add("Pattern");
		javaList.add("Patterns");
		javaList.add("MVC");
		javaList.add("Portal");
		javaList.add("Multithreading");
		javaList.add("JBoss");
		javaList.add("Axis");
		javaList.add("Eclipse");
		javaList.add("Intellij");
		javaList.add("NetBeans");
		javaList.add("Beans");
		javaList.add("SOA");
		javaList.add("JNI");
		javaList.add("OCJP");
		javaList.add("SCJP");

		sqlList.add("Oracle");
		sqlList.add("MySQL");
		sqlList.add("PostgreSQL");
		sqlList.add("DBMS");
		sqlList.add("RDBMS");
		sqlList.add("PL/SQL");
		
		unixList.add("Linux");
		unixList.add("Ubuntu");
		unixList.add("Fedora");
		unixList.add("RedHat");
		unixList.add("Debian");
		unixList.add("Suse");
		unixList.add("Bash");
		unixList.add("SSH");
		unixList.add("Shell");
		unixList.add("Kernel");
		unixList.add("Bourne");
		
		appsuportList.add("Support");
		appsuportList.add("QA");
		appsuportList.add("ITIL");
		appsuportList.add("VBA");
		appsuportList.add("Excel");
		appsuportList.add("PMO");
		appsuportList.add("BA");
		
		keywordDependencies.put("Java", javaList);
		keywordDependencies.put("SQL", sqlList);
		keywordDependencies.put("Unix", unixList);
		keywordDependencies.put("Unix", appsuportList);
	}
}