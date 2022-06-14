package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAction {
    private String id;
    private String paymentId;
    private String paymentAction;
    private String paymentMethod;
    private String paymentType;
    private String timestamp;
    private String reference;
    private String invoiceNumber;
    private long amount;
    private long vatAmount;
    private String currency;
    private long fee;
    private long flexibleFee;
    private long fixedFee;
    private long feeVATpercent;
    private long feeTaxRate;
    private long feeTaxAmount;
    private List<TransactionTaxDetails> transactionTaxDetails;
    private String subscriptionId;
}
