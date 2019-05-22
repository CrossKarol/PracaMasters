<html lang=''>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/resources/css/styles.css">
<link rel="stylesheet" href="/resources/css/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

</head>
<body>

<div class="container">
	<div class="card">
		<c:forEach var="a" items="${spottedCommentList }">
			<c:set var="postyid" value="${u.id }"/>
			<c:if test="${a.id_post == postyid }">
				<div class="card-body">
					<div class="row">
							<div class="col-md-2">
							<img src="data:image/jpeg;base64,${a.image}" alt="" class="img img-rounded img-fluid"/>
							<p class="text-secondary text-center"><c:out value="${a.author }"/></p>
							</div>
						<div class="col-md-10">
							<p>
							<a class="float-left" ><strong><c:out value="${a.title }"/></strong></a>
							<span class="float-right"><c:out value="${a.createOn }"/></span>
							</p>
							<div class="clearfix"></div>
							<p><c:out value="${a.content }"/></p>
							<p>
								<form id="formula1" action="spottedall/likecomment/${a.id }" >
									<input type="hidden" name="spottedLikeComment" id="spottedLikeComment" value="${a.spottedLikeComment + 1 }"/>
									<button class="float-right btn text-white btn-danger" type="submit" id="submit"><i class="fa fa-heart"></i>Like! <c:out value="${a.spottedLikeComment }"/></button>
								</form>
							</p>
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>
</div>

</body>
<html>