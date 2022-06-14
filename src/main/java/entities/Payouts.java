package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payouts {
    private String id;
    private String reference;
    private String date;
    private String bankAccountIban;
    private String bankAccountBic;
    private String currency;
    private long amount;
    private long chargedAmount;
    private long numberOfCharges;
    private long refundedAmount;
    private long numberOfRefunds;
    private long fees;
    private long feeVATpercent;
    private long feeTaxRate;
    private long feeTaxAmount;
    private List<TransactionTaxDetails> transactionTaxDetails;
}
