import java.util.*;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VoiceAssistant")

/* 
	VoiceAssistant class contains class variables name,price,image,retailer,condition,discount.

	VoiceAssistant class constructor with Arguments name,price,image,retailer,condition,discount.
	  
	Accessory class contains getters and setters for name,price,image,retailer,condition,discount.

*/

public class VoiceAssistant extends HttpServlet
{
	private String id;
	private String name;
	private double price;
	private String image;
	private String retailer;
	private String condition;
	private double discount;
	private String rebate;
	private String description;
	private boolean hasWarranty;
	private double warrantyPrice;
	
	public VoiceAssistant(String name, double price, String image, String retailer,String condition,double discount, String rebate,
						  String description, boolean hasWarranty, double warrantyPrice)
	{
		this.name=name;
		this.price=price;
		this.image=image;
		this.retailer = retailer;
		this.condition=condition;
		this.discount = discount;
		this.rebate = rebate;
		this.description = description;
		this.hasWarranty = hasWarranty;
		this.warrantyPrice = warrantyPrice;
	}
	
	public VoiceAssistant()
	{
		
	}
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public String getImage()
	{
		return image;
	}
	public void setImage(String image)
	{
		this.image = image;
	}
	
	public String getRetailer()
	{
		return retailer;
	}
	public void setRetailer(String retailer)
	{
		this.retailer = retailer;
	}
	
	public String getCondition()
	{
		return condition;
	}

	public void setCondition(String condition)
	{
		this.condition = condition;
	}

	public double getDiscount()
	{
		return discount;
	}

	public void setDiscount(double discount)
	{
		this.discount = discount;
	}

	public String getRebate() {
		return rebate;
	}

	public void setRebate(String rebate) {
		this.rebate = rebate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getWarrantyPrice() {
		return warrantyPrice;
	}

	public void setWarrantyPrice(double warrantyPrice) {
		this.warrantyPrice = warrantyPrice;
	}

	public boolean isHasWarranty() {
		return hasWarranty;
	}

	public void setHasWarranty(boolean hasWarranty) {
		this.hasWarranty = hasWarranty;
	}
}