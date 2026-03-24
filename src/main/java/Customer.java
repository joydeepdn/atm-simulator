
import java.util.HashMap;
 class Customer{

    HashMap<String,String> customerInfo = new HashMap<>();


    public void setAccountInfo(String cardNumber, String pin){
        customerInfo.put(cardNumber,pin);
    }

    public HashMap<String,String> getCusInfo(){
        return customerInfo;
    }
}

