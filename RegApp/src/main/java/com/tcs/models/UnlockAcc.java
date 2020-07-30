package com.tcs.models;

import lombok.Data;

@Data
public class UnlockAcc {

	private String email;

    private String tempPwd;
	private String newPwd;

    private String confimPwd;
    
}
