import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SmartWatchList")
public class SmartWatchList extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = null;
		String CategoryName = request.getParameter("maker");

		HashMap<String, SmartWatch> allSmartWatches = new HashMap<>();
		HashMap<String, SmartWatch> hm = new HashMap<>();

		try
		{
			allSmartWatches = MySqlDataStoreUtilities.getSmartWatches();
			System.out.println("All Phones: " + allSmartWatches.size());
		}
		catch(Exception e)
		{

		}

		if(CategoryName==null)
		{
			//hm.putAll(SaxParserDataStore.phones);
			hm.putAll(allSmartWatches);
			name = "";
		}
		else
		{
			if(CategoryName.equals("apple"))
			{
				//for(Map.Entry<String,Phone> entry : SaxParserDataStore.phones.entrySet())
				for(Map.Entry<String,SmartWatch> entry : allSmartWatches.entrySet())
				{
					if(entry.getValue().getRetailer().equals("Apple"))
					{
						hm.put(entry.getValue().getId(),entry.getValue());
					}
				}
				name = "Apple";
			}
			else if(CategoryName.equals("samsung"))
			{
				for(Map.Entry<String,SmartWatch> entry : allSmartWatches.entrySet())
				{
					if(entry.getValue().getRetailer().equals("Samsung"))
					{
						hm.put(entry.getValue().getId(),entry.getValue());
					}
				}
				name = "Samsung";
			}
			else if(CategoryName.equals("google"))
			{
				for(Map.Entry<String,SmartWatch> entry : allSmartWatches.entrySet())
				{
					if(entry.getValue().getRetailer().equals("Google"))
					{
						hm.put(entry.getValue().getId(),entry.getValue());
					}
				}
				name = "Google";
			}
			else if(CategoryName.equals("huawei"))
			{
				for(Map.Entry<String,SmartWatch> entry : allSmartWatches.entrySet())
				{
					if(entry.getValue().getRetailer().equals("Huawei"))
					{
						hm.put(entry.getValue().getId(),entry.getValue());
					}
				}
				name = "Huawei";
			}
			else if(CategoryName.equals("oneplus"))
			{
				for(Map.Entry<String,SmartWatch> entry : allSmartWatches.entrySet())
				{
					if(entry.getValue().getRetailer().equals("OnePlus"))
					{
						hm.put(entry.getValue().getId(),entry.getValue());
					}
				}
				name = "OnePlus";
			}
		}

		/* Header, Left Navigation Bar are Printed.

		All the Phone and Phone information are dispalyed in the Content Section

		and then Footer is Printed*/

		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>"+name+" SmartWatches</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1; int size= hm.size();
		System.out.println("Size: " + size);
		for(Map.Entry<String, SmartWatch> entry : hm.entrySet())
		{
			SmartWatch smartWatch = entry.getValue();
			if(i%3==1) pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>"+smartWatch.getName()+"</h3>");
			pw.print("<h4>" + smartWatch.getDescription() + "</h5>");
			pw.print("<strong>$"+smartWatch.getPrice()+"</strong>");
			pw.print("<h4> Discount: $" + smartWatch.getDiscount() + "</h4><ul>");
			pw.print("<li id='item'><img src='images/wearables/"+smartWatch.getImage()+"' alt='' /></li>");

			pw.print("<li><form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='phones'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>" +
					warrantyCheckbox(smartWatch) +
					"<input type='submit' class='btnbuy' value='Buy Now'></form></li>");
			pw.print("<div style='display:flex; justify-content:space-evenly'><li><form method='post' action='WriteReview'>"+
					"<input type='hidden' name='type' value='Phone'>"+
					"<input type='hidden' name='name' value='" + smartWatch.getName() +"'>"+
					"<input type='hidden' name='maker' value='"+smartWatch.getRetailer()+"'>"+
					"<input type='hidden' name='price' value='"+smartWatch.getPrice()+"'>"+
					"<input type='submit' value='WriteReview' class='btnreview'></form></li>");
			pw.print("<li><form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='" + smartWatch.getName() + "'>"+
					"<input type='hidden' name='type' value='Phone'>"+
					"<input type='hidden' name='maker' value='"+smartWatch.getRetailer()+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' value='ViewReview' class='btnreview'></form></li></div>");

			if (utility.usertype() != null && utility.usertype().equals("storeManager")) {

				pw.print("<div style='display:flex; justify-content:space-evenly'><li><form method='post' action='ProductModify'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
						"<input type='hidden' name='productId' value='" + smartWatch.getId() + "'>"+
						"<input type='hidden' name='productManufacturer' value='"+ name +"'>"+
						"<input type='hidden' name='productType' value='Phone'>"+
						"<input type='hidden' name='productName' value='" + smartWatch.getName() + "'>"+
						"<input type='hidden' name='productPrice' value='" + smartWatch.getPrice() + "'>"+
						"<input type='hidden' name='productWarranty' value='" + smartWatch.getWarrantyPrice() + "'>"+
						"<input type='hidden' name='productDiscount' value='" + smartWatch.getDiscount() + "'>"+
						"<input type='hidden' name='productRebate' value='" + smartWatch.getRebate() + "'>"+
						"<input type='hidden' name='productCondition' value='" + smartWatch.getCondition() + "'>"+
						"<input type='hidden' name='productDescription' value='" + smartWatch.getDescription() + "'>"+
						"<input type='submit' name='button' value='Update' class='btnreview'></form></li>");
				pw.print("<li><form method='post' action='ProductCrud'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
						"<input type='hidden' name='productId' value='" + smartWatch.getId() + "'>"+
						"<input type='submit' name='button' value='Delete' class='btnreview'></form></li></div>");
			}

			pw.print("</ul></div></td>");
			if(i%3==0 || i == size) pw.print("</tr>");
			i++;
		}
		pw.print("</table></div></div></div>");

		utility.printHtml("Footer.html");
	}

	private String warrantyCheckbox(SmartWatch smartWatch) {
		return smartWatch.isHasWarranty()
				? "<input type='checkbox' name='productWarranty' value='yes'><label> Life Time Warranty: $" + smartWatch.getWarrantyPrice() + "</label>"
				: "<p>Warranty not available</p>";
	}
}