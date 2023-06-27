<div id="whatis" class="content-section-b" style="border-top: 0">
		<div class="container">

			<div class="col-md-6 col-md-offset-3 text-center wrap_title">
			
				<h2>What is?</h2>
				<p class="lead" style="margin-top:0">Find | Add | Delete</p>
				
			</div>
			
			<div class="row">
			
				<div class="col-sm-4 wow fadeInDown text-center">
				    <img class="rotate" src="img/icon/tweet.svg" alt="Generic placeholder image">
					  <h3>Find an Item</h3>
					  <p class="lead">Find your item where it is. </p>
					  <form role="form" action="/ITEMS/findItem" method="post" >
						<div class="col-md-6">
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" name="InputName" id="InputName" placeholder="Input Item Name" required>
									<span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span>
								</div>
							</div>
						    <input type="submit" name="submit" id="submit" value="Find" class="btn wow tada btn-embossed btn-primary pull-right">
						</div>
					</form>	
				</div><!-- /.col-lg-4 -->
				
				<div class="col-sm-4 wow fadeInDown text-center">
					<img  class="rotate" src="img/icon/picture.svg" alt="Generic placeholder image">
					   <h3>Add an Item</h3>
					   <p class="lead">Add an item into your box. </p>
					<form role="form" method="post" >
						<div class="col-md-6">
							<div class="form-group">
								
								<div class="input-group">
									<input type="text" class="form-control" name="InputItemName" id="InputItemName" placeholder="Enter Item Name" required>
									<span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span>
								</div>
							</div>
						    <div class="form-group">
								    <div class="input-group">
									     <input type="text" class="form-control" id="InputPlace" name="InputPlace" placeholder="Enter Place" required  >
									     <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span>
		                            </div>
							</div>
							<input type="submit" onclick="loadDoc()" name="submit" id="submit" value="Add" class="btn wow tada btn-embossed btn-primary pull-right">
						</div>
					</form>	
					<%
						String msg1 = (String) request.getAttribute("messageItem");
						if (msg1 != null && msg1.length()<30) 
						{
					%>
							<h4 style="color: #ff0000">
							<%=msg1%>
							</h4>
					<%
						}
						else if (msg1 != null && msg1.length()>30) 
						{
					%>
							<h4 style="color: #00ffd8">
							<%=msg1%>
							</h4>
					<%
						}
					%>
						
				   <!-- <p><a class="btn btn-embossed btn-primary view" role="button">View Details</a></p> -->
				</div><!-- /.col-lg-4 -->
				
				<div class="col-sm-4 wow fadeInDown text-center">
				  	<img  class="rotate" src="img/icon/retina.svg" alt="Generic placeholder image">
				   		<h3>Delete an Item</h3>
						<p class="lead">Delete an item from your box. </p>
							<form role="form" action="/ITEMS/deleteItem" method="post" >
								<div class="col-md-6">
									<div class="form-group">
										<div class="input-group">
											<input type="text" class="form-control" name="InputName" id="InputName" placeholder="Input Item Name" required>
											<span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span>
										</div>
									</div>
								    <input type="submit" name="submit" id="submit" value="Delete" class="btn wow tada btn-embossed btn-primary pull-right">
								</div>
							</form>	
				  <!-- <p><a class="btn btn-embossed btn-primary view" role="button">View Details</a></p> -->
				</div><!-- /.col-lg-4 -->
				
			</div><!-- /.row -->
				
			
		</div>
</div>
<script>
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
      myFunction(xhttp);
    }
  };
  xhttp.open("GET", "/ITEMS/addItem", true);
  xhttp.send();
}
function myFunction(xml) {
  var i;
  var xmlDoc = xml.responseXML;
  var table="<tr><th>Artist</th><th>Title</th></tr>";
  var x = xmlDoc.getElementsByTagName("CD");
  
  document.getElementById("demo").innerHTML = table;
}
</script>