/* ==========================================
   AgroVision Authentication Script
   Handles:
   - Register
   - Login
   - Success/Error messages
   ========================================== */


/* ================= REGISTER ================= */

async function registerUser(event) {
    event.preventDefault();

    const data = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        phone: document.getElementById("phone").value
    };

    const response = await postRequest("/auth/register", data);

    if (response.success) {
        alert("Registration successful! Please login.");
        window.location.href = "/login.html";
    } else {
        alert(response.message || "Registration failed");
    }
}


/* ================= LOGIN ================= */

async function loginUser(event) {
    event.preventDefault();

    const data = {
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };

    const response = await postRequest("/auth/login", data);

    if (response.success) {
        alert("Login successful!");

        // store user session
        localStorage.setItem("userId", response.data.userId);
        localStorage.setItem("userName", response.data.name);

        // redirect to upload page
        window.location.href = "/upload.html";
    } else {
        alert(response.message || "Invalid credentials");
    }
}
