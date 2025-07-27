// Register User
document.getElementById("registerForm").addEventListener("submit", function(e) {
  e.preventDefault();

  const user = {
    username: document.getElementById("username").value,
    email: document.getElementById("email").value,
    password: document.getElementById("password").value
  };

  fetch("http://localhost:8080/api/users/register", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(user)
  })
    .then(response => response.json())
    .then(data => alert("Registered: " + data.username))
    .catch(error => console.error("Registration error:", error));
});

// Login User
document.getElementById("loginForm").addEventListener("submit", function(e) {
  e.preventDefault();

  const credentials = {
    email: document.getElementById("loginEmail").value,
    password: document.getElementById("loginPassword").value
  };

  fetch("http://localhost:8080/api/users/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(credentials)
  })
    .then(res => res.ok ? res.json() : Promise.reject("Invalid credentials"))
    .then(data => alert("Login successful for: " + data.username))
    .catch(err => alert(err));
});

// Get All Users
document.getElementById("getUsersBtn").addEventListener("click", function() {
  fetch("http://localhost:8080/api/users")
    .then(response => response.json())
    .then(users => {
      const userList = document.getElementById("userList");
      userList.innerHTML = "";
      users.forEach(user => {
        const li = document.createElement("li");
        li.textContent = `ID: ${user.id}, Name: ${user.username}, Email: ${user.email}`;
        userList.appendChild(li);
      });
    })
    .catch(error => console.error("Error loading users:", error));
});
