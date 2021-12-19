package com.insurances.reports.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResponseMessage {

    private String message;
    private String fileDownloadUri;

    public ResponseMessage(String message,String fileDownloadUri){
        this.message=message;
        this.fileDownloadUri=fileDownloadUri;
    }
}
