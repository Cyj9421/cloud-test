package com.cyj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
 public class Payment implements Serializable {
     private Long id; //Long  非long
     private String serial;
 }
