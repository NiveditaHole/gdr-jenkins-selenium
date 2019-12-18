import org.junit.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {

	@BeforeSuite
	public void setUp()
	{
		System.out.println("set the property");
	}
	@BeforeClass
	public void LuanchBrowser()
	{
		System.out.println("browser is chrome");
	}
	@BeforeTest
	public void login()
	{
		System.out.println("login");	
	}
	@BeforeMethod
	public void verifyLink()
	{
		System.out.println("link verified");
	}
	@Test
	public void VerifyEmail()
	{
		System.out.println("email	");
	}
}
