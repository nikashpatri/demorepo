package page_object_model;

import org.testng.annotations.Test;

public class Spicejet_2waysearch_testscript1 {
	Spicejet_2waysearch_Components roundtripcomponents=new Spicejet_2waysearch_Components();
	
  @Test(description="verify the roundway functionalty of spicejet")
  public void test1() throws Exception 
  {
	  
	  roundtripcomponents.launchapp();
	  roundtripcomponents.roundtrip();
	  roundtripcomponents.selectflight();
  }

}
