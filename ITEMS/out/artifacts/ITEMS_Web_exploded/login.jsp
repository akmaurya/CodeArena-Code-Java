<div id="login" class="content-section-b" style="border-top: 0">
    <div class="container">
	   <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center wrap_title">
               <h2>Login</h2>
                    <p class="lead" style="margin-top:0">Login to find your items.</p>
            </div>
			
			<form role="form" action="/ITEMS/clientLogin" method="post" >
				<div class="col-md-6">
					<div class="form-group">
						<label for="InputName">Your Email</label>
						<div class="input-group">
							<input type="text" class="form-control" name="InputEmail" id="InputEmail" placeholder="Enter Email" required>
							<span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
					</div>
				    <div class="form-group">
						<label for="InputEmail">Your Password</label>
                            <div class="input-group">
							     <input type="password" class="form-control" id="InputPassword" name="InputPassword" placeholder="Enter Password" required  >
							     <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span>
                            </div>
					</div>
					<input type="submit" name="submit" id="submit" value="Login" class="btn wow tada btn-embossed btn-primary pull-right">
				</div>
			</form>				
		</div>
    </div>
</div>
	
	