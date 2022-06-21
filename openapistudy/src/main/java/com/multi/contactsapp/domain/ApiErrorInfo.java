package com.multi.contactsapp.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JacksonXmlRootElement(localName = "restApiError")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorInfo {
    private String message;
    private String status;
}
