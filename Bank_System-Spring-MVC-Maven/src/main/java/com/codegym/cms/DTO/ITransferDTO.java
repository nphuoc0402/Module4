package com.codegym.cms.DTO;

public interface ITransferDTO {
    public Long getId();
    public Long getIdSender();
    public String getNameSender();
    public Long getIdReceiver();
    public String getNameReceiver();
    public int getAmount();
    public int getTransaction_fee();
    public int getTotal_amount();

}
