const passwordInput = document.getElementById('password');
const passwordcheckInput = document.getElementById('passwordcheck');
const passwordMismatch = document.getElementById('passwordMismatch');

passwordcheckInput.addEventListener('input', () => {
  if (passwordInput.value !== passwordcheckInput.value) {
    passwordMismatch.textContent = '비밀번호가 일치하지 않습니다.';
  } else {
    passwordMismatch.textContent = '';
  }
});
