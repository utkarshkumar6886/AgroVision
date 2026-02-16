/* ==========================================
   AgroVision - Common API Connector
   Used by: auth.js, upload.js, history.js
   ========================================== */

const API_BASE_URL = "http://localhost:8081/api";

/* Generic POST request */
async function postRequest(endpoint, data) {
    try {
        const response = await fetch(`${API_BASE_URL}${endpoint}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        return await response.json();
    } catch (error) {
        return {
            success: false,
            message: "Server error. Please try again."
        };
    }
}

/* Generic GET request */
async function getRequest(endpoint) {
    try {
        const response = await fetch(`${API_BASE_URL}${endpoint}`);
        return await response.json();
    } catch (error) {
        return {
            success: false,
            message: "Server error. Please try again."
        };
    }
}
