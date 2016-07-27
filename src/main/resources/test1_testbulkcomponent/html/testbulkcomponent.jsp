<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="template" uri="http://www.jahia.org/tags/templateLib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="jcr" uri="http://www.jahia.org/tags/jcr" %>
<%@ taglib prefix="ui" uri="http://www.jahia.org/tags/uiComponentsLib" %>
<%@ taglib prefix="functions" uri="http://www.jahia.org/tags/functions" %>
<%@ taglib prefix="query" uri="http://www.jahia.org/tags/queryLib" %>
<%@ taglib prefix="utility" uri="http://www.jahia.org/tags/utilityLib" %>
<%@ taglib prefix="s" uri="http://www.jahia.org/tags/search" %>
<%--@elvariable id="currentNode" type="org.jahia.services.content.JCRNodeWrapper"--%>
<%--@elvariable id="out" type="java.io.PrintWriter"--%>
<%--@elvariable id="script" type="org.jahia.services.render.scripting.Script"--%>
<%--@elvariable id="scriptInfo" type="java.lang.String"--%>
<%--@elvariable id="workspace" type="java.lang.String"--%>
<%--@elvariable id="renderContext" type="org.jahia.services.render.RenderContext"--%>
<%--@elvariable id="currentResource" type="org.jahia.services.render.Resource"--%>
<%--@elvariable id="url" type="org.jahia.services.render.URLGenerator"--%>

<p> Hello that's my JSP view </p>
<form action="<c:url value='${currentNode.path}.addpages.do' context='${url.base}' />" method="post" enctype="multipart/form-data" autocomplete="off">
  
  <fieldset>
    <div class="alert alert-info">
      <label for="csvFile">CSV File <span class="text-error"><strong>*</strong></span></label>
      <input type="file" name="csvFile" id="csvFile"/>
    </div>
    <label for="csvSeparator"><fmt:message key="label.csvSeparator"/></label>
    <input class="span6" type="text" name="csvSeparator" value="${csvFile.csvSeparator}" id="csvSeparator"/>
  </fieldset>
  
  <fieldset>
    <button class="btn btn-primary" type="submit" name="_eventId_confirm" id="${currentNode.identifier}-confirm">
      <i class="icon-ok icon-white"></i>
      &nbsp;<fmt:message key='label.ok'/>
    </button>
    <button class="btn" type="submit" name="_eventId_cancel">
      <i class="icon-ban-circle"></i>
      &nbsp;<fmt:message key='label.cancel'/>
    </button>
  </fieldset>
</form>