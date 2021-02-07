package com.user.entity;


import java.util.List;

public class Result {
    private boolean success = true;
    private Object result;

    public Result() {

    }

    public Result(boolean success, Object result) {
        this.success = success;
        this.result = result;
    }

    public static Result success(Object result){
        return new Result(true,result);
    }

    public static Result success(){
        return new Result();
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", result=" + result +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
