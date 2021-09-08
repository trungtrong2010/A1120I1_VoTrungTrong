package com.codegym.furama.controller;

import com.codegym.furama.model.entity.contract.ContractDetail;
import com.codegym.furama.model.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ContractDetailController {

    @Autowired
    private IContractDetailService contractDetailService;


}
