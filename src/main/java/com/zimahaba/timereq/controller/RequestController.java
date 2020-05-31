package com.zimahaba.timereq.controller;

import com.zimahaba.timereq.entity.Request;
import com.zimahaba.timereq.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RequestController {

    @Autowired
    private RequestService requestService;

    private static final String VIEW_REQUEST_MAINTENANCE = "request-maintenance";
    private static final String VIEW_REQUEST_NEW_EDIT = "request-new-edit";
    private static final String VIEW_REQUEST_DETAIL = "request-detail";
    private static final String VIEW_REQUEST_DELETE = "request-delete";

    @GetMapping("/requests")
    public ModelAndView showRequestMaintenance() {
        final ModelAndView modelAndView = new ModelAndView(VIEW_REQUEST_MAINTENANCE);
        modelAndView.addObject("requests", requestService.findAll());
        return modelAndView;
    }

    @GetMapping("/request-new")
    public ModelAndView showRequestNew() {
        final ModelAndView modelAndView = new ModelAndView(VIEW_REQUEST_NEW_EDIT);
        modelAndView.addObject("request", new Request());
        modelAndView.addObject("method", "post");
        return modelAndView;
    }

    @GetMapping("/request-edit/{id}")
    public ModelAndView showRequestEdit(@PathVariable Long id) {
        final ModelAndView modelAndView = new ModelAndView(VIEW_REQUEST_NEW_EDIT);
        modelAndView.addObject("request", requestService.findById(id));
        modelAndView.addObject("method", "put");
        return modelAndView;
    }

    @GetMapping("/request/{id}")
    public ModelAndView showRequestDetail(@PathVariable Long id) {
        final ModelAndView modelAndView = new ModelAndView(VIEW_REQUEST_DETAIL);
        modelAndView.addObject("request", requestService.findById(id));
        return modelAndView;
    }

    @GetMapping("/request-delete/{id}")
    public ModelAndView showRequestDelete(@PathVariable Long id) {
        final ModelAndView modelAndView = new ModelAndView(VIEW_REQUEST_DELETE);
        return modelAndView;
    }

    @PostMapping("/request")
    public String saveRequest(@ModelAttribute Request request, BindingResult result, RedirectAttributes redirect) {
        requestService.save(request);
        redirect.addFlashAttribute("message", "Request successfully created.");
        return "redirect:requests";
    }

    @PutMapping("/request")
    public String updateRequest(@ModelAttribute Request request, BindingResult result, RedirectAttributes redirect) {
        requestService.save(request);
        redirect.addFlashAttribute("message", "Request successfully updated.");
        return "redirect:requests";
    }
}
