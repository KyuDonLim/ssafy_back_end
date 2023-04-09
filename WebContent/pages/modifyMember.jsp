<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="updateModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
  aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">

      <div class="modal-header">
        <h4 class="modal-title">
          <i class="bi bi-chat-fill text-info"> 회원 정보 수정</i>
        </h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

        <form action="${root}/member" method = "post">
      <div class="modal-body">
              <input type="hidden" name="action" value = "modify" />
              <input type="hidden" name="userId" value = "${sessionScope.loginInfo.id}" />
          <div class="mb-3">
            <i class="bi bi-lock-fill" style="color: rgb(121, 2, 119)"></i>
            <label for="update-input-pwd" class="update-input-pwd-label">이름</label>
            <input type="text" class="form-control" placeholder="이름을 입력하세요." name="name" />
          </div>
          <div class="mb-3">
            <i class="bi bi-messenger" style="color: rgb(121, 2, 119)"></i>
            <label for="update-input-pwd" class="update-input-pwd-label">이메일</label>
            <input type="email" class="form-control" placeholder="이메일을 입력하세요." name="email" />
          </div>
          <div class="mb-3">
            <i class="bi bi-mailbox" style="color: rgb(121, 2, 119)"></i>
            <label for="update-input-pwd" class="update-input-pwd-label">주소</label>
            <input type="text" class="form-control" placeholder="주소를 입력하세요." name="addr" />
          </div>
          <div class="mb-3">
            <i class="bi bi-phone" style="color: rgb(121, 2, 119)"></i>
            <label for="update-input-pwd" class="update-input-pwd-label">전화번호</label>
            <input type="tel" class="form-control" placeholder="전화번호를 입력하세요." name="phone" />
          </div>

      <div class="modal-footer">
        <input type ="submit" class="btn btn-primary btn-sm" value="수정">
        <button type="button" class="btn btn-outline-danger btn-sm" data-bs-dismiss="modal">
          취소
        </button>
      </div>
      </div>
        </form>
    </div>
  </div>
</div>