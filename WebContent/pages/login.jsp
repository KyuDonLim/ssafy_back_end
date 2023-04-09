<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div
      class="modal fade"
      id="loginModal"
      data-bs-backdrop="static"
      data-bs-keyboard="false"
      tabindex="-1"
      aria-labelledby="staticBackdropLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">
              <i class="bi bi-chat-fill text-info"> 로그인</i>
            </h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>

            <form action="${root}/member"  method = "post">
          <div class="modal-body">
            <input type = "hidden" name = "action" value ="login">
              <div class="row mb-3 mt-3">
                <div class="col-md-12">
                  <i class="bi bi-person-fill text-primary"></i>
                  <label for="login-input-id" class="login-input-id-label">ID</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="ID를 입력하세요."
                    id="login-input-id"
                    name="userId"
                  />
                </div>
              </div>
              <div class="mb-3">
                <i class="bi bi-lock-fill" style="color: rgb(121, 2, 119)"></i>
                <label for="login-input-pwd" class="login-input-pwd-label">PASSWORD</label>
                <input
                  type="password"
                  class="form-control"
                  placeholder="Password를 입력하세요."
                  id="login-input-pwd"
                  name="userPw"
                />
              </div>
          </div>

          <div class="modal-footer">
            <input type ="submit" class="btn btn-primary btn-sm" value="로그인">
            <button type="button" class="btn btn-outline-danger btn-sm" data-bs-dismiss="modal">
            	  취소
            </button>
          </div>
            </form>
        </div>
      </div>
    </div>