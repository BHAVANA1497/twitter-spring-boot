package com.techmojo.twitterHashTag.rest.json;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Status{
    OK("OK"),
    ERROR("ERROR");

    private final static Map<String, Status> stateMap = new HashMap<>();
    static{
        Arrays.stream(Status.values()).forEach(e -> stateMap.put(e.getCode(), e));

    }

    private String code;

    @JsonValue
    public String getCode(){
        return code;
    }

    Status(String code){
        this.code = code;
    }

    public static Status of(String code){
        return stateMap.get(code);
    }

    @Override
    public String toString(){
        return getCode().toString();
    }
}

