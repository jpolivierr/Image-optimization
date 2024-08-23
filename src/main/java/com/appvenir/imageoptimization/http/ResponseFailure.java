package com.appvenir.imageoptimization.http;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseFailure {

    private LocalDateTime timeStamp = LocalDateTime.now();
    private String message;
    private Object body;
    private String path;
    private String exceptionClass;
    private String cause;
    private ArrayList<String> stackTrace;

    private ResponseFailure(Builder builder){
        this.timeStamp = builder.getTimeStamp();
        this.message = builder.getMessage();
        this.body = builder.getBody();
        this.path = builder.getPath();
        this.exceptionClass = builder.getExceptionClass();
        this.cause = builder.getCause();
        this.stackTrace = builder.getStackTrace();
    }

    @Getter
    @Setter
    public static class Builder {

        private LocalDateTime timeStamp = LocalDateTime.now();
        private String message;
        private Object body;
        private String path;
        private String exceptionClass;
        private String cause;
        private ArrayList<String> stackTrace;
        private Exception exception;

        public Builder(Exception ex){
            this.exception = ex;
        }

        public Builder setMessage(String message){
            this.message = message;
            return this;
        }

        public Builder setBody(Object body){
            this.body = body;
            return this;
        }

        public ResponseFailure build(String environment){

            if("dev".equalsIgnoreCase(environment)){
                setExceptionClass(exception.getClass().getName());
                setCause(exception.getCause() != null ? exception.getCause().toString() : null);
                setStackTrace(getStackTraceAsString(exception));
                return new ResponseFailure(this);
            }

            if("prod".equalsIgnoreCase(environment)){
                return new ResponseFailure(this);
            }
            
            throw new IllegalArgumentException("Environment not recognized");
        }

        private static ArrayList<String> getStackTraceAsString(Exception ex) {
            ArrayList<String> stackTrace = new ArrayList<>();
            for (StackTraceElement element : ex.getStackTrace()) {
                stackTrace.add(element.toString());
            }
            return stackTrace;
        }
        
    }


    public static Builder builder(Exception ex) {
        return new Builder(ex);
    }
   
}
