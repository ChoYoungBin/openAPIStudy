package com.multi.contactssvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JacksonXmlRootElement(localName = "contact")
public class Contact {
    @JacksonXmlProperty(isAttribute = true)
    private long no;
    private String name;
    @JacksonXmlProperty(localName = "phone")
    private String tel;
    private String address;

}
