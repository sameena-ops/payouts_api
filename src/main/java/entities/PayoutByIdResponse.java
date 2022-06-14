package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PayoutByIdResponse  {
    private String id;
    private String reference;
    private String date;
    private String bankAccountIban;
    private String bankAccountBic;
    private String currency;
    private long amount;
    private long chargedAmount;
    private long refundedAmount;
    private long fees;
    private long feeVATpercent;
    private long feeTaxRate;
    private long feeTaxAmount;
    private List<TransactionTaxDetails> transactionTaxDetails;
    private int numberOfPaymentActions;
    private List<PaymentAction> paymentActions;
}





