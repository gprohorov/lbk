package com.example.lbk.security;
/*
  @author   george
  @project   lbk
  @class  Role
  @version  1.0.0 
  @since 12.05.2021 - 09.02
*/

public enum Role {
    ADMIN, USER;
    private String name;

    public String getName() {
        return name;
    }
}
