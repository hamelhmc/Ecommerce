
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.wirtz.ecommerce.model.util.Global"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="layout/header.jsp"%>
<h2>Cart</h2>

<c:if test="${sessionScope.userProfileId != null}">

	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Title</th>
					<th>Price</th>
					<th>Numero de unidades</th>
					<th>Price total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartline}" var="cartline">
					<tr>
						<td><spring:url
								value="/products/${cartline.product.productId}"
								var="pDetailsUrl"></spring:url> <a href="${pDetailsUrl}">${cartline.product.name}</a>
						</td>
						<td>$cartline.product.price}</td>

						<td>${cartline.quantity}</td>
						<td>${cartline.quantity}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</c:if>


<c:if test="${empty block.items}">
No results found
</c:if>

<%@ include file="layout/footer.jsp"%>