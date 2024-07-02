const API_BASE_URL = 'http://localhost:8080/api/v1'; // Replace with your backend base URL

// Function to compile and run Java code
export const compileAndRunCode = async (code) => {
  try {
    const response = await fetch(`${API_BASE_URL}/runAndCompile`, {
      method: 'POST',
      headers: {
        'Content-Type': 'text/plain',
        'Access-Control-Allow-Origin':'*'
      },
      body: code,
    });

    if (!response.ok) {
      throw new Error(`Error: ${response.statusText}`);
    }

    const data = await response.text();
    return data;
  } catch (error) {
    throw new Error(`Error compiling code: ${error.message}`);
  }
};

// Add more methods as needed

// Example: Function to get server status
export const getServerStatus = async () => {
  try {
    const response = await fetch(`${API_BASE_URL}/status`);

    if (!response.ok) {
      throw new Error(`Error: ${response.statusText}`);
    }

    const data = await response.json();
    return data;
  } catch (error) {
    throw new Error(`Error getting server status: ${error.message}`);
  }
};

// Example: Function to fetch all logs
export const fetchAllLogs = async () => {
  try {
    const response = await fetch(`${API_BASE_URL}/logs`);

    if (!response.ok) {
      throw new Error(`Error: ${response.statusText}`);
    }

    const data = await response.json();
    return data;
  } catch (error) {
    throw new Error(`Error fetching logs: ${error.message}`);
  }
};
