package br.demo.turbotodo.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {

    private Date currentDate;

    private String message;

    public ErrorMessage() {

    }

}
