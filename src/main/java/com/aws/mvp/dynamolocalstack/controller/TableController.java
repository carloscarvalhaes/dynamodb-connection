package com.aws.mvp.dynamolocalstack.controller;

import com.aws.mvp.dynamolocalstack.svc.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dynamo")
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;

    @PostMapping("/create")
    public HttpStatus createTable() {

        int httpStatus = tableService.createTable();
        return HttpStatus.valueOf(httpStatus);

    }

}
