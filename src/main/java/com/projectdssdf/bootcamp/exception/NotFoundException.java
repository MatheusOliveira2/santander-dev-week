package com.projectdssdf.bootcamp.exception;

import com.projectdssdf.bootcamp.util.MessageUtils;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super(MessageUtils.NO_RECORD_FOUND);
    }
}
