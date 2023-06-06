function validateForm() {
  var name = document.getElementById("name").value;
  var gender = document.getElementById("gender").value;
  var phone = document.getElementById("phone").value;
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;

  if (name === "" || gender === "" || phone === "" || email === "" || password === "") {
    alert("全ての項目を入力してください。");
    return false;
  }
}