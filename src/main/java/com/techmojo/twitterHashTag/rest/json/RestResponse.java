package com.techmojo.twitterHashTag.rest.json;

import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@ToString
public class RestResponse<T> {

    @ApiModelProperty(value = "Error Code, if no error will be OK", required = true, example = "ERROR_XXX_XXX")
    protected Status status = Status.OK;

    @ApiModelProperty(value = "Error Message", required = false, example = "connot get Rate info base on rateId")
    protected String message;

    @ApiModelProperty(value = "Timestamp, return number of milliseconds since January 1, 1970, 00:00:00 GMT", required = true, example = "......")
    protected long timestamp = System.currentTimeMillis();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @ApiModelProperty(value = "data", required = true, example = "data:{}")
    protected T data;


}
