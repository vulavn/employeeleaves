package com.employee.utility;

import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class Common {

    public static List<String> createErrorMessage(List<ObjectError> listError) {

        if (null == listError || listError.isEmpty()) {
            return null;
        }

        List<String> listMessage = new ArrayList<>();
        for (ObjectError error : listError) {
            listMessage.add(error.getDefaultMessage());
        }
        return listMessage;
    }
}
