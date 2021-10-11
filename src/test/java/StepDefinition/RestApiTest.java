
package StepDefinition;

import Model.RestApiModel;
import io.cucumber.java.en.Given;

public class RestApiTest {
    RestApiModel restModel=new RestApiModel();

	
	  @Given("^Name '(.*)', price '(.*)',stock '(.*)' olan urun oldugu kontrol edilir.$") 
	  public void name_price_stock_olan_urun_oldugu_kontrol_edilir(String name,int price,int stock){
		  restModel.checkProduct(name,price,stock); }
	  
	  @Given("Apideki urunlerin varligi kontrol edilir.$") 
	  public void apideki_urunlerin_varligi_kontrol_edilir(){ 
		  restModel.checkAllProductControl(); }
	  
	  @Given("Endpoint bazli kontrol edilir.")
	  public void endpoint_bazli_kontrol_edilir() {
		  restModel.checkProductControl();
	  }  
	  @Given("^id '(.*)', name '(.*)', price '(.*)',stock '(.*)' ozellikli urun eklenir.$") 
	  public void id_name_price_stock_ozellikli_urun_eklenir(int id,String name,int price,int stock){
		  restModel.postProduct(id, name,price,stock); }
	 
    
    
    
}