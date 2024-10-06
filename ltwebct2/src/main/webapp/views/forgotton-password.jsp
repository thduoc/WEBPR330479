<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-9">
            <h1>Forgot Your Password?</h1>
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                	<c:if test="${alert !=null}">
						<h3 class="alert alert danger">${alert}</h3>
					</c:if>
                  <form action="${pageContext.request.contextPath}/forgotton-password" method="post" class="form-horizontal form-without-legend" role="form">                    
                    <div class="form-group">
                      <label for="username" class="col-lg-4 control-label">Username</label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="username" name="username" required>
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="new-password" class="col-lg-4 control-label">New Password</label>
                      <div class="col-lg-8">
                        <input type="password" class="form-control" id="new-password" name="new-password" required>
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="repeat-password" class="col-lg-4 control-label">New Password</label>
                      <div class="col-lg-8">
                        <input type="password" class="form-control" id="repeat-password" name="repeat-password" required>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-5">
                        <button type="submit" class="btn btn-primary">Send</button>
                      </div>
                    </div>
                  </form>
                </div>
                <div class="col-md-4 col-sm-4 pull-right">
                  <div class="form-info">
                    <h2><em>Important</em> Information</h2>
                    <p>Enter the e-mail address associated with your account. Click submit to have your password e-mailed to you.</p>

                    <button type="button" class="btn btn-default">More details</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- END CONTENT -->