package com.codegym.service;

import com.codegym.model.MailBox;


import java.util.ArrayList;
import java.util.List;

public class FormBindingMailService implements IFormBindingMail{

    private List<MailBox> mailboxList = new ArrayList<>();

    @Override
    public List<MailBox> findAll() {
        return mailboxList;
    }

    @Override
    public void save(MailBox mailBox) {
        mailboxList.add(mailBox);
    }


}
