package com.ch.client.web.servlet;

import com.ch.client.service.ClientAdvertisementService;
import com.ch.common.web.application.ApplicationEventPublisher;
import org.springframework.web.bind.ServletRequestUtils;

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
 * <p/>
 * Servlet just init once
 */
public class ClientOpenAdvertisementServlet extends HttpServlet {

    public ClientAdvertisementService clientAdvertisementService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (clientAdvertisementService == null) {
            clientAdvertisementService = (ClientAdvertisementService) ApplicationEventPublisher.getCtx().getBean("clientAdvertisementService");
        }

        String requestURL = request.getRequestURI();
        String responseJSON = "";

        if ("/dvbott/client/getopenadcontent".equals(requestURL)) {
            responseJSON = clientAdvertisementService.obtainClientOpenAdvertisement();

        } else if ("/dvbott/client/getmainmodulecontent".equals(requestURL)) {
            responseJSON = clientAdvertisementService.obtainClientModuleAdvertisement();

        } else if ("/dvbott/client/getsubmodulecontent".equals(requestURL)) {

            int moduleAdvertisementId = ServletRequestUtils.getIntParameter(request, "index");
            responseJSON = clientAdvertisementService.obtainClientSubModule(moduleAdvertisementId);
        } else if ("/dvbott/client/getbannercontent".equals(requestURL)) {

            responseJSON = clientAdvertisementService.obtainClientBannerAdvertisement();
        }

        //返回结果
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(responseJSON);
        writer.flush();
        writer.close();
    }
}
