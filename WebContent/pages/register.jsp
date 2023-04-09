<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div
      class="modal fade"
      id="registerModal"
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
              <i class="bi bi-chat-fill text-info"> 회원가입</i>
            </h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>
            <form action="${root}/member"  method = "post">

          <div class="modal-body">
            <input type = "hidden" name = "action" value ="register">
              <div class="row mb-3 mt-3">
                <div class="col-md-12">
                  <i class="bi bi-person-fill text-primary"></i>
                  <label for="register-input-id" class="register-input-id-label">ID</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="ID를 입력하세요."
                    id="register-input-id"
                    name="id"
                  />
                </div>
              </div>
              <div class="mb-3">
                <i class="bi bi-lock-fill" style="color: rgb(121, 2, 119)"></i>
                <label for="register-input-pwd" class="register-input-pwd-label">PASSWORD</label>
                <input
                  type="password"
                  class="form-control"
                  placeholder="Password를 입력하세요."
                  id="register-input-pwd"
                  name="pwd"
                />
              </div>
              <div class="mb-3">
                <i class="bi bi-lock-fill" style="color: rgb(121, 2, 119)"></i>
                <label for="register-input-pwd" class="register-input-pwd-label">이름</label>
                <input
                  type="text"
                  class="form-control"
                  placeholder="이름을 입력하세요."
                  name="name"
                />
              </div>
              <div class="mb-3">
                <i class="bi bi-messenger" style="color: rgb(121, 2, 119)"></i>
                <label for="register-input-pwd" class="register-input-pwd-label">이메일</label>
                <input
                  type="email"
                  class="form-control"
                  placeholder="이메일을 입력하세요."
                  name="email"
                />
              </div>
              <div class="mb-3">
                <i class="bi bi-mailbox" style="color: rgb(121, 2, 119)"></i>
                <label for="register-input-pwd" class="register-input-pwd-label">주소</label>
                <input
                  type="text"
                  class="form-control"
                  placeholder="주소를 입력하세요."
                  name="addr"
                />
              </div>
              <div class="mb-3">
                <i class="bi bi-phone" style="color: rgb(121, 2, 119)"></i>
                <label for="register-input-pwd" class="register-input-pwd-label">전화번호</label>
                <input
                  type="tel"
                  class="form-control"
                  placeholder="전화번호를 입력하세요."
                  name="phone"
                />
              </div>
          </div>

          <div class="modal-footer">
            <input type ="submit" class="btn btn-primary btn-sm" value="회원가입">
            
            <button type="button" class="btn btn-outline-danger btn-sm" data-bs-dismiss="modal">
              취소
            </button>
          </div>
            </form>
        </div>
      </div>
    </div>