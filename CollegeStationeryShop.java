package org.example.jsongenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CollegeStationeryShop {
	
	public static void main(String a[]) {
		List<String> clothingList = new ArrayList<String>();
		clothingList.add ("TSHIRT");
		clothingList.add ("JACKET");
		clothingList.add ("CAP");
		
		List<String> stationeryList = new ArrayList<String>();
		stationeryList.add ("NOTEBOOK");
		stationeryList.add ("PENS");
		stationeryList.add ("MARKERS");
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					a[0]));
			String line = reader.readLine();
			String quantity = null;
			
			int iquantity = 0;
			int discount1 = 0;
			int discount2 = 0;
			int discount3 = 0;
			int discount4 = 0;
			int discount5 = 0;
			int discount6 = 0;
			int totalAmount = 0;
			int amount1 = 0;
			int amount2 = 0;
			int amount3 = 0;
			int amount4 = 0;
			int amount5 = 0;
			int amount6 = 0;
			
			while (line != null) {
	
				if(line.startsWith("ADD_ITEM")){
					quantity = line.substring(line.length()-1);
					
					if(null != quantity && quantity.length() > 0 )
						iquantity = Integer.parseInt(quantity);
					
					if(line.contains("TSHIRT")) {
						if(iquantity > 2) {
							System.out.println("ERROR_QUANTITY_EXCEEDED");
						}else {
							System.out.println("ITEM_ADDED");
							discount1 = calculateDiscount("TSHIRT",1000, 10, iquantity);
							amount1 = 1000 * iquantity;
						}
					}else if(line.contains("JACKET")) {
						if(iquantity > 2) {
							System.out.println("ERROR_QUANTITY_EXCEEDED");
						}else {
							System.out.println("ITEM_ADDED");
							discount2 = calculateDiscount("JACKET",2000, 5, iquantity);
							amount2 = 2000 * iquantity;
						}
						
					} else if(line.contains("CAP")) {
						if(iquantity > 2) {
							System.out.println("ERROR_QUANTITY_EXCEEDED");
						}else {
							System.out.println("ITEM_ADDED");
							discount3 = calculateDiscount("CAP",500, 20, iquantity);
							amount3 = 500 * iquantity;
						}
					} else if(line.contains("NOTEBOOK")) {
						if(iquantity > 3) {
							System.out.println("ERROR_QUANTITY_EXCEEDED");
						}else {
							System.out.println("ITEM_ADDED");
							discount4 = calculateDiscount("NOTEBOOK",200, 20,iquantity);
							amount4 = 200 * iquantity;
						}
					} else if(line.contains("PENS")) {
						if(iquantity > 3) {
							System.out.println("ERROR_QUANTITY_EXCEEDED");
						}else {
							System.out.println("ITEM_ADDED");
							discount5 = calculateDiscount("PENS",300,10,iquantity);
							amount5 = 300 * iquantity;
						}
					} else if(line.contains("MARKERS")) {
						if(iquantity > 3) {
							System.out.println("ERROR_QUANTITY_EXCEEDED");
						}else {
							System.out.println("ITEM_ADDED");
							discount6 = calculateDiscount("MARKERS",500, 5,iquantity);
							amount6 = 500 * iquantity;
						}
					} 
					
				}

				line = reader.readLine();
			}
			
			double totalDiscount = discount1 + discount2 + discount3 + discount4 + discount5 + discount6;
			totalAmount = amount1 + amount2 + amount3 + amount4 + amount5 + amount6;
			
			if(totalAmount > 1000) {
				System.out.println("TOTAL_DISCOUNT " + totalDiscount);
			}else if(totalAmount > 3000) {
				System.out.println("TOTAL_DISCOUNT " + (totalDiscount * 5)/100);
			}
			totalAmount = totalAmount + calculateSalesTax(totalAmount);
			System.out.println("TOTAL_AMOUNT_TO_PAY "+totalAmount);
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int calculateDiscount(String itemType, int originalPrice, int discountPercentage, int quantity) {
		int totalAmt = originalPrice * quantity;
		int discount = ((originalPrice*quantity) * discountPercentage)/100;
		
		return discount;
	}
	
	private static int calculateSalesTax(int totalAmount) {
		int salesTax = totalAmount * 10 / 100;
		return salesTax;
	}

}
