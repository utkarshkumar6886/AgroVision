// Base API URL (Spring Boot backend)
const BASE_URL = "http://localhost:8081/api";

// Generic API call function
async function apiCall(endpoint, method = "GET", data = null) {
    try {
        const options = {
            method: method,
            headers: {
                "Content-Type": "application/json"
            }
        };

        // Attach body only for POST/PUT
        if (data) {
            options.body = JSON.stringify(data);
        }

        const response = await fetch(BASE_URL + endpoint, options);

        const result = await response.json();
        return result;

    } catch (error) {
        console.error("API Error:", error);
        return {
            success: false,
            message: "Server error. Please try again."
        };
    }
}
