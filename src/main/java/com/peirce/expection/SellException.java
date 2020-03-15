package com.peirce.expection;

import com.peirce.enums.ResultEnum;

import javax.persistence.criteria.CriteriaBuilder;
import java.nio.channels.SeekableByteChannel;

public class SellException extends RuntimeException {

    private Integer code;

    public SellException (ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public SellException(Integer code,String message){
        super(message);
        this.code = code;
    }


}
