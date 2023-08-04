package models;

import enums.PaymentType;
import lombok.Data;

@Data
public class Wallet {
    private String id;
    private User user;
    private PaymentType paymentType;
    private Long amount = 0L;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long loadAmount(Long amountLoaded){
        return this.getAmount() + amountLoaded;
    }

    public Long deductAmount(Long amountDeducted) throws Exception {
        if(this.getAmount() < amountDeducted) throw new Exception("Insufficient Balance");
        return this.getAmount() - amountDeducted;
    }
}
