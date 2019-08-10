package qa.keyword.testng;

import org.testng.annotations.Test;

import qa.keyword.engine.keyWordEngine;

public class TestNG {
	public keyWordEngine keywordengine;
	@Test
	public void LoginTest()
	{
		keywordengine=new keyWordEngine();
		keywordengine.startExecution("login");
	}
	@Test
	public void signinTest()
	{
		keywordengine=new keyWordEngine();
		keywordengine.startExecution("signin");
	}

}
