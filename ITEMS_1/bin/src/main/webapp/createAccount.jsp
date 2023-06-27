<div id="createAccount" class="content-section-b" style="border-top: 0">
    <div class="container">
	   <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center wrap_title">
				<h2>Create Account</h2>
				<p class="lead" style="margin-top:0">Fill this form to create your account.</p>
			</div>
			
			<form role="form" action="/ITEMS/clientCreateAccount" method="post" >
				<div class="col-md-6">
                    <div class="form-group">
						<label for="InputName">Your Name</label>
						<div class="input-group">
							<input type="text" class="form-control" name="InputName" id="InputName" placeholder="Enter Name" required>
							<span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
					</div>
                    <div class="form-group">
						<label for="InputName">Your Contact No.</label>
                        <div class="input-group">
							 <input type="text" class="form-control" name="InputContact" id="InputContact" placeholder="Enter Contact No.">
							 <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span>
                        </div>
					</div>

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
					
					<input type="submit" name="submit" id="submit" value="Submit Form" class="btn wow tada btn-embossed btn-primary pull-right">
				</div>
			</form>
			
			<hr class="featurette-divider hidden-lg">
				
			</div>
		</div>
	</div>