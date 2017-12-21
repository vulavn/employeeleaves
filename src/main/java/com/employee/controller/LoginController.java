package com.employee.controller;

import com.employee.dao.EmployeeDao;
import com.employee.dao.LeaveHistoryDao;
import com.employee.entity.Employee;
import com.employee.entity.LeaveHistory;
import com.employee.model_attribule.LoginParam;
import com.employee.utility.Common;
import com.employee.utility.Constants;
import com.employee.utility.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private LeaveHistoryDao leaveHistoryDao;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String displayLogin(Model model) {

        return "login";
    }

    @RequestMapping(value = "home", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute LoginParam param, BindingResult bindingResult, Model model) {

        // Validate Error
        if (bindingResult.hasErrors()) {

            // Create message
            List<String> listValidateMessage = Common.createErrorMessage(bindingResult.getAllErrors());

            if (listValidateMessage != null) {
                // Add message
                model.addAttribute("errorMessage", listValidateMessage);
            }

            return "login";
        }

        // Get employee
        Employee employee = employeeDao.getByLoginAcc(param.getTxtAccount(), param.getTxtPassword());

        // Login fail
        if (employee == null) {

            model.addAttribute("errorMessage", Message.LOGIN_FAIL);
            return "login";
        }

        // Role Member
        if (employee.getRole().getId() == Constants.ROLE_MEMBER) {

            // Add member information
            model.addAttribute("member", employee);

            // Get employee Leave history
            List<LeaveHistory> listLeaveHistory = leaveHistoryDao.getLeaveHistoryOfMember(param.getTxtAccount());

            if (listLeaveHistory != null && !listLeaveHistory.isEmpty()) {
                model.addAttribute("listLeaveHistory", listLeaveHistory);
            }

            return "employee";
        }

        // Role Manager
        model.addAttribute("manager", employee);
        return "manager";

    }
}
