package com.swagger.openapi.exception;

// Exception class for Merchant Token Eligibility errors
public class ServiceInvocationException extends RuntimeException {
   private static final long serialVersionUID = 1L;

   private final String code;
   private final String message;

   public ServiceInvocationException() {
      super();
      this.code = "";
      this.message = "";
   }

   public ServiceInvocationException(String message, Throwable cause) {
      super(message, cause);
      this.code = "";
      this.message = "";
   }

   public ServiceInvocationException(String code, String message) {
      super("code: " + code + "message: " + message);
      this.code = "";
      this.message = "";
   }

   public ServiceInvocationException(String message) {
      super(message);
      this.code = "";
      this.message = "";
   }

   public String getCode() {
      return code;
   }

   @Override
   public String getMessage() {
      return message;
   }

   @Override
   public String toString() {
      return "ServiceInvocationException [code= " + code + "message=" + message + "]";
   }

}
