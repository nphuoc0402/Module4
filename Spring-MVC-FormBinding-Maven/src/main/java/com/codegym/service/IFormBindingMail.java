package com.codegym.service;

import com.codegym.model.MailBox;

import java.util.List;

public interface IFormBindingMail {
    List<MailBox> findAll();

    void save(MailBox mailBox);

}
