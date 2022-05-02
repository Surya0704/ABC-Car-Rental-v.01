package asses;

class TransactionParty {
    String seller;
    String buyer;
    public TransactionParty(String seller, String buyer){
      this.seller = seller;
      this.buyer = buyer;
    }
}

class Receipt{
    TransactionParty transactionParty;
    String productsQR;
    public Receipt(TransactionParty transactionParty, String productsQR){
      this.transactionParty = transactionParty;
      this.productsQR = productsQR;
    }
}


class GenerateReceipt{
    public int verifyParty(Receipt r){
      int rtnValue = 0;
      
      if((""+r.transactionParty.seller.charAt(0)).matches("^[a-zA-Z]") && (""+r.transactionParty.seller.charAt(r.transactionParty.seller.length()-1)).matches("^[a-zA-Z]")){
        rtnValue++;
      }
      if ((""+r.transactionParty.buyer.charAt(0)).matches("^[a-zA-Z]") && (""+r.transactionParty.buyer.charAt(r.transactionParty.buyer.length() - 1)).matches("^[a-zA-Z]")){
        rtnValue++;
      }
      return rtnValue;
    }
    public String calcGST(Receipt r){
        double GST_Rate = 12.0 / 100;
        String []product = r.productsQR.split("@",3);
        String []rateQty = product[0].split(",", 2);
        int Rate1 = Integer.parseInt(rateQty[0]);
        int Quantity1 = Integer.parseInt(rateQty[1]);
        rateQty = product[1].split(",", 2);
        int Rate2 = Integer.parseInt(rateQty[0]);
        int Quantity2 = Integer.parseInt(rateQty[1]);
        rateQty = product[2].split(",", 2);
        int Rate3 = Integer.parseInt(rateQty[0]);
        int Quantity3 = Integer.parseInt(rateQty[1]);
        int GST =(int)( ((Rate1 * Quantity1) + (Rate2 * Quantity2) + (Rate3 * Quantity3)) * GST_Rate);
        return new Integer(GST).toString();
    }
}
public class TransactionSource{
  public static void main(String[] args){
    TransactionParty transactionParty = new TransactionParty("Seller", "buyer");
    Receipt receipt = new Receipt(transactionParty, "250,10@100,3@50,7");
    GenerateReceipt generateReceipt = new GenerateReceipt();
    System.out.println(generateReceipt.verifyParty(receipt));
    System.out.println(generateReceipt.calcGST(receipt));
    System.out.println(cipher("HelloWorld",3));
  }
  static String cipher(String msg, int shift){
	    String s = "";
	    int len = msg.length();
	    for(int x = 0; x < len; x++){
	        char c = (char)(msg.charAt(x) + shift);
	        if (c > 'z')
	            s += (char)(msg.charAt(x) - (26-shift));
	        else
	            s += (char)(msg.charAt(x) + shift);
	    }
	    return s;
	}
}