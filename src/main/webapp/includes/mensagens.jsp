<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="hasActionMessages()">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <s:actionmessage/>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</s:if>

<s:if test="hasActionErrors()">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <s:actionerror/>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</s:if>

<s:if test="hasFieldErrors()">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <s:fielderror/>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</s:if> 