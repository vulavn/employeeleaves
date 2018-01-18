package com.employee.model_attribule;

import com.employee.utility.Message;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginParam {

    @NotEmpty(message = Message.EMPTY_ACCOUNT)
    private String txtAccount;

    @NotEmpty(message = Message.EMPTY_PASSWORD)
    private String txtPassword;

    public String getTxtAccount() {
        return txtAccount;
    }

    public void setTxtAccount(String txtAccount) {
        this.txtAccount = txtAccount;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }
}
