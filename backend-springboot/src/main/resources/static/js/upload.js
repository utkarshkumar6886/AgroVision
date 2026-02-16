/* ==========================================
   AgroVision Upload Script
   Handles:
   - Image selection
   - Send upload request to backend
   - Save detection record
   ========================================== */

async function uploadImage(event) {
    event.preventDefault();

    const fileInput = document.getElementById("imageFile");
    const file = fileInput.files[0];

    if (!file) {
        alert("Please select an image first.");
        return;
    }

    // get logged-in userId from localStorage
    const userId = localStorage.getItem("userId");

    if (!userId) {
        alert("Session expired. Please login again.");
        window.location.href = "/login.html";
        return;
    }

    // Prepare data for backend
    const data = {
        userId: userId,
        imageName: file.name,
        imagePath: "uploads/" + file.name   // temporary path (real upload later)
    };

    const response = await postRequest("/detection/upload", data);

    if (response.success) {
        alert("Image uploaded successfully!");

        // redirect to result page later
        window.location.href = "/result.html";
    } else {
        alert(response.message || "Upload failed");
    }
}
