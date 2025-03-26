// js/script.js
const loginBtn = document.getElementById('loginBtn');
const loginModal = document.getElementById('loginModal');
const closeBtn = document.getElementById('closeBtn');
const hasErrors = /*[[${#fields.hasErrors('*')}]]*/ false || /*[[${#fields.hasGlobalErrors()}]]*/ false;

loginBtn.addEventListener('click', function() {
    loginModal.style.display = 'block';
});

closeBtn.addEventListener('click', function() {
    loginModal.style.display = 'none';
});

if (hasErrors) {
    loginModal.style.display = "block";
}

