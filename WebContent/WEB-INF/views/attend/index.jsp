<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    <form>
    <h2>勤務一覧表</h2>
    <h3>8月</h3>
    <input type="submit" value="保存">
        <table id="kintai_list">
            <tbody>
                <tr>
                    <th class="attend_day">日付</th>
                    <th class="attend_begin">出勤</th>
                    <th class="attend_finish">退勤</th>
                    <th class="attend_break">休憩</th>
                    <th class="attend_work">実働時間</th>
                </tr>

                <c:forEach var="message" items="${messages}">
                <tr>
                    <td class="attend_day">
                        <c:out value="${attendance.month}" />月&nbsp;
                        <c:out value="${attendance.day}" />日&nbsp;
                        <c:out value="${attendance.week}" />曜日&nbsp;
                    </td>
                    <td class="attend_begin">
                        <input type="text" value="${attendance.attend_begin}">
                    </td>
                    <td class="attend_finish">
                        <input type="text" value="${attendance.attend_finish}">
                    </td>
                    <td  class="attend_break">
                        <input type="text" value="${attendance.attend_break}">
                    </td>
                    <td class="attend_work">
                        <input type="text" value="${attendance.attend_work}">
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
    </c:param>
</c:import>