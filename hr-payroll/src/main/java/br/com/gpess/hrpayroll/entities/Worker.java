package br.com.gpess.hrpayroll.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor

public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double dailyIncome;

}
