import java.util.ArrayList;

class CustomerInfo{
    ArrayList<Integer> customerInfo = new ArrayList<>();

    public void setAccountInfo(int cardNumber, int PIN){
        customerInfo.add(cardNumber);
        customerInfo.add(PIN);
    }
    public ArrayList<Integer> getAccountInfo(){
        return customerInfo;
    }
}

