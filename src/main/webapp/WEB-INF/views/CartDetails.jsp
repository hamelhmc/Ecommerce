
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.wirtz.ecommerce.model.util.Global"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
						<th>remove to cart...</th>
					</tr>
				</thead>
				<tbody>
				<form:form method="POST" modelAttribute="userProfile" action="${pageContext.request.contextPath}/update">
					<c:forEach items="${userProfile.cartline}" var="cartline" varStatus="varStatus">
						<tr>
							<td><spring:url
									value="/products/${cartline.product.productId}"
									var="pDetailsUrl"></spring:url> <a href="${pDetailsUrl}">${cartline.product.name}</a>
									 <form:hidden
                               path="cartline[${varStatus.index}].product.productId" />
                
            
							</td>
							<td><fmt:formatNumber value="${cartline.product.price}" type="currency"/></td> 
							
							<td><form:input
                               path="cartline[${varStatus.index}].quantity" type="number"/></td>
							<td><fmt:formatNumber value="${cartline.quantity*cartline.product.price}" type="currency"/></td>
							<td><spring:url value="/cart/remove/${cartline.cartlineId}"
									var="removeCartUrl"></spring:url> <a href="${removeCartUrl}">remove
									to cart...</a></td>
						</tr>
					
					</c:forEach>
					<input type="submit" value="Actualizar" />
						</form:form>
				</tbody>
			</table>
		
	</div>
</c:if>




<%@ include file="layout/footer.jsp"%>