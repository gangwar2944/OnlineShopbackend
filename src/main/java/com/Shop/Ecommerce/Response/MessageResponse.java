package com.Shop.Ecommerce.Response;
import lombok.Builder;

@Builder
public class MessageResponse{
    private String message;

    private HttpStatus status;

    Object data;



    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public MessageResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public MessageResponse(String message, HttpStatus status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}