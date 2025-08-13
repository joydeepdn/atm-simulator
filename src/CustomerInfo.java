
import java.util.HashMap;

class CustomerInfo{

    HashMap<Integer,Integer> customerInfo = new HashMap<>();


    public void setAccountInfo(int cardNumber, int PIN){
        customerInfo.put(cardNumber,PIN);
    }

    public HashMap<Integer,Integer> getCusInfo(){
        return customerInfo;
    }
}

