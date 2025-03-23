package com.m0wn1la.app2.exception;

import lombok.Data;

@Data
public class DuplicateEntryException extends TheUpdaterException{
    public String duplicatedModal;
    public  String duplicatedFieldName;
    public String duplicatedFieldValue;
    public DuplicateEntryException(String message) {
        super(message);
    }
    public DuplicateEntryException(String message,String duplicatedModal, String duplicatedFieldName, String duplicatedFieldValue) {
        super(message);
        this.duplicatedModal = duplicatedModal;
        this.duplicatedFieldName = duplicatedFieldName;
        this.duplicatedFieldValue = duplicatedFieldValue;
    }
}
