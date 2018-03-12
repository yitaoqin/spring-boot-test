package com.example.domain;

import java.io.Serializable;

public class BaseEntity implements Serializable{
    protected int page=1;
    protected int size=20;
    protected String sidx="date_created";
}
