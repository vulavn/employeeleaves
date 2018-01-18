package com.employee.controller;

import com.employee.dao.LeaveHistoryDao;
import com.employee.dao.LeaveTypeDao;
import com.employee.entity.LeaveHistory;
import com.employee.entity.LeaveType;
import com.employee.model_attribule.AddLeaveParam;
import com.employee.utility.Common;
import com.employee.utility.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.*;

@Controller
public class EmployeeController {

    @Autowired
    private LeaveTypeDao leaveTypeDao;

    @Autowired
    private LeaveHistoryDao leaveHistoryDao;

    @RequestMapping(value = "displayAddLeave", method = RequestMethod.GET)
    public String displayAddLeave(@RequestParam("hdnAccount") String hdnAccount, Model model) {

        // Get all type
        ArrayList<LeaveType> listLeaveType = leaveTypeDao.getAllLeaveType();

        // Add to dropdown list
        model.addAttribute("listLeaveType", listLeaveType);

        model.addAttribute("hdnAccount", hdnAccount);

        return "add_leave";
    }

    @RequestMapping(value = "addLeave", method = RequestMethod.POST)
    public String addLeave(@Valid @ModelAttribute AddLeaveParam param, BindingResult bindingResult, Model model) {

        Date dtStart = null;
        Date dtEnd = null;

        List<String> listValidateMessage = new ArrayList<>();
        // Validate Error
        if (bindingResult.hasErrors()) {

            // Create message
            listValidateMessage = Common.createErrorMessage(bindingResult.getAllErrors());

            if (listValidateMessage != null && !listValidateMessage.isEmpty()) {
                // Add message
                model.addAttribute("listMessage", listValidateMessage);
            }

            return displayAddLeave(param.getHdnAccount(), model);
        }

        try {
            // Check invalid of end time
            String strStart = param.getDtStart() + " " + param.getSelStartTime();
            String strEnd = param.getDtEnd() + " " + param.getSelEndTime();

            dtStart = Common.convertStringToDate(strStart, "yyyy-MM-dd HH:MM");
            dtEnd = Common.convertStringToDate(strEnd, "yyyy-MM-dd HH:MM");

            // Error when dtStart is greater than dtEnd
            if (dtStart.after(dtEnd) || dtStart.equals(dtEnd)) {
                listValidateMessage.add(Message.INVALID_END_DATE);
            }

            if (listValidateMessage != null && !listValidateMessage.isEmpty()) {
                // Add message
                model.addAttribute("listMessage", listValidateMessage);
                return displayAddLeave(param.getHdnAccount(), model);
            }

            // Create new LeaveHistory
            LeaveHistory leaveHistory = new LeaveHistory();
            leaveHistory.setId(3);
            leaveHistory.setAccount(param.getHdnAccount());
            leaveHistory.setStart(new Timestamp(dtStart.getTime()));
            leaveHistory.setEnd(new Timestamp(dtEnd.getTime()));
            leaveHistory.setReason(param.getTxtReason());
            leaveHistory.setStatus(0);

            Date applyDate = new Date();
            leaveHistory.setStart(new Timestamp(applyDate.getTime()));
            leaveHistory.setYear(Common.getYear(applyDate));

            // Get leave type
            LeaveType leaveType = leaveTypeDao.getLeaveTypeById(param.getSelLeaveType());
            leaveHistory.setLeaveType(leaveType);

            int id = leaveHistoryDao.addLeave(leaveHistory);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "add_leave";
    }


}
