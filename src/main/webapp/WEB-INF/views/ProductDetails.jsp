
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.wirtz.ecommerce.model.util.Global"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="layout/header.jsp"%>


	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Title</th>
					<th>Price</th>
					<th>stock</th>
					<c:if test="${sessionScope.userProfileId != null}">
					<th>Add to cart...</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>${block.name}</td>
						<td>${block.price}</td>
						<td>${block.stock}</td>
						<c:if test="${sessionScope.userProfileId != null}">
							<td><spring:url value="/cart/${block.productId}"
									var="addCartUrl"></spring:url> <a href="${addCartUrl}">Add
									to cart</a></td>
						</c:if>
					</tr>
			</tbody>
		</table>
	</div>


<c:if test="${empty block}">
No results found
</c:if>

<%@ include file="layout/footer.jsp"%>