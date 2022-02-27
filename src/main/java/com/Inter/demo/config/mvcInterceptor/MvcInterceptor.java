/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "27.02.2022, 13:57"
 * @version V 1.0.0
 */

package com.Inter.demo.config.mvcInterceptor;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import org.assertj.core.util.Strings;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class MvcInterceptor implements HandlerInterceptor {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse  response, Object handler) {

        String loggerMvc = "[" + request.getMethod() + "]" + request.getRequestURI() + getParameters(request);

        log.info(loggerMvc);
        kafkaTemplate.send("mvcIn", loggerMvc);
        return true;
    }

    private String getParameters(final HttpServletRequest request) {
        final StringBuilder posted = new StringBuilder();
        final Enumeration<?> e = request.getParameterNames();
        if (e != null)
            posted.append("?");
        while (e != null && e.hasMoreElements()) {
            if (posted.length() > 1)
                posted.append("&");
            final String curr = (String) e.nextElement();
            posted.append(curr)
                    .append("=")
                    .append(request.getParameter(curr));
        }
        final String ip = request.getHeader("X-FORWARDED-FOR");
        final String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
        if (!Strings.isNullOrEmpty(ipAddr))
            posted.append(" ip=").append(ipAddr);
        return posted.toString();
    }

    private String getRemoteAddr(final HttpServletRequest request) {
        final String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
        if (ipFromHeader != null && ipFromHeader.length() > 0) {
            log.debug("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
            return ipFromHeader;
        }
        return request.getRemoteAddr();
    }
}
