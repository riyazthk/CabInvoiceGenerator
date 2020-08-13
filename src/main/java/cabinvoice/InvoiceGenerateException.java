package cabinvoice;


public class InvoiceGenerateException extends Exception {
    public static  ExceptionType USER_ID_BE_A_NOTNULL_OR_NOTEMPTY;
    public ExceptionType type;


    public enum ExceptionType {
        USER_ID_BE_A_NOTNULL_OR_NOTEMPTY;;
    }

    public InvoiceGenerateException(String message, ExceptionType type){
        super(message);
        this.type=type;
    }
}
