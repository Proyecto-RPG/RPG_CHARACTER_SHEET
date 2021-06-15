const form = document.getElementById('registerForm');
const inputs = document.querySelectorAll('#registerForm input');

inputs.forEach((input) => {
    input.addEventListener('keyup', validate)
})

form.addEventListener('submit', (e) => {
    e.preventDefault();
});

function validate() {
                var pass1 = document.getElementsById("pass1").value;
                var pass2 = document.getElementsById("pass2").value;
                if (pass1 === pass2) {
                    return true;
                } else {
                    document.getElementsById("pass1").focus()
                    alert("Las contraseñas no coinciden");
                    return false;
                }
            }

