package com.ch.client.web.servlet;

import com.ch.client.service.ClientAdvertisementService;
import com.ch.common.web.application.ApplicationEventPublisher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: Jack Wang
 * Date: 15-3-18
 * Time: 下午3:20
 *
 * Servlet just init once
 */
public class ClientOpenAdvertisementServlet extends HttpServlet {

    private ClientAdvertisementService clientAdvertisementService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (clientAdvertisementService == null) {
            clientAdvertisementService = (ClientAdvertisementService) ApplicationEventPublisher.getCtx().getBean("clientAdvertisementService");
        }

        String responseJSON = clientAdvertisementService.obtainClientOpenAdvertisement();

        //返回结果
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(responseJSON);
        writer.flush();
        writer.close();
    }
}
