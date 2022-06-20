package com.multi.contactsapp.domain;

import lombok.*;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@AllArgsConstructor
@ToString
public class Contact {

    private long no;
    private String name;
    private String tel;
    private String address;

}
